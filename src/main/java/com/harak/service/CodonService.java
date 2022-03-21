package com.harak.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harak.domain.CodonEntity;
import com.harak.repository.CodonRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Singleton
public class CodonService {
    @Inject
    private ObjectMapper objectMapper;


    private final CodonRepository codonRepository;


    private static final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() - 1);


    public CodonService(CodonRepository codonRepository) {
        this.codonRepository = codonRepository;
    }

    public String populate() throws IOException, ExecutionException, InterruptedException {
        List<CodonEntity> codonEntities = objectMapper.readValue(Paths.get("data/CODON.json").toFile(), new TypeReference<List<CodonEntity>>() {
        });

        long start = System.currentTimeMillis();
        ForkJoinPool customThread = new ForkJoinPool(4);
        codonRepository.saveAll(codonEntities);
        try {
            customThread.submit(() ->
                    codonEntities.parallelStream().forEach(codonEntity -> {
                        codonRepository.save(codonEntity);
                        System.out.println(Thread.currentThread().getName());
                    })

            );
        } catch (Exception e) {

        } finally {
            customThread.shutdown();
        }

        long end = System.currentTimeMillis();

        System.out.println();
        System.out.println("Elapsed Time in nano seconds  " + (end - start));
        return "success";
    }

    public String populateAsync() throws IOException, ExecutionException, InterruptedException {
        List<CodonEntity> codonEntities = objectMapper.readValue(Paths.get("data/CODON.json").toFile(), new TypeReference<List<CodonEntity>>() {
        });
        final AtomicInteger count = new AtomicInteger();
        long start = System.currentTimeMillis();

        CompletableFuture[] future = codonEntities.stream()
                .collect(Collectors.groupingBy(c -> count.getAndIncrement() / 10))
                .values()
                .stream().map(this::executeBatch).toArray(CompletableFuture[]::new);
        CompletableFuture<Void> run = CompletableFuture.allOf(future);
        run.get();

        long end = System.currentTimeMillis();

        System.out.println("Elapsed Time in nano seconds  " + (end - start));
        // codonRepository.saveAll(codonEntities);
        return "success";
    }

    public CompletableFuture<Void> executeBatch(List<CodonEntity> list) {

        return CompletableFuture.runAsync(() -> {
            for (CodonEntity entity : list) {
                codonRepository.save(entity);
            }
        }, executor);
    }
}

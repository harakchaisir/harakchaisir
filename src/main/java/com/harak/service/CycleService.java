package com.harak.service;

import com.harak.generics.BaseRepository;
import com.harak.generics.BaseServiceImpl;
import jakarta.inject.Singleton;

@Singleton
public class CycleService extends BaseServiceImpl {
    public CycleService(BaseRepository repository) {
        super(repository);
    }
}

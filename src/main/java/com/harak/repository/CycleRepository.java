package com.harak.repository;

import com.harak.domain.CycleEntity;
import com.harak.generics.BaseRepository;
import io.micronaut.data.annotation.Repository;

@Repository
public interface CycleRepository extends BaseRepository<CycleEntity> {
}

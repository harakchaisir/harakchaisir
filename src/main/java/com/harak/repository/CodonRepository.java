package com.harak.repository;

import com.harak.domain.CodonEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
@Repository
public interface CodonRepository extends CrudRepository<CodonEntity , Long> {
}

package com.harak.generics;

import io.micronaut.data.jpa.repository.JpaRepository;

public interface BaseRepository<T extends BaseEntity<T>> extends JpaRepository<T, Long> {
}

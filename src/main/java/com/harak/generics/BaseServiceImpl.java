package com.harak.generics;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Map;
@Singleton
public abstract class BaseServiceImpl<T extends BaseEntity<T>>{

    @Inject
    private BaseRepository<T> baseRepository;

    public BaseServiceImpl(BaseRepository<T> repository) {
        this.baseRepository=repository;
    }

    @Transactional
    public T create(T newDomain){
        return baseRepository.save(newDomain);
    }


}

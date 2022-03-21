package com.harak.generics;

import io.micronaut.data.repository.GenericRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Post;


public abstract class BaseController<T extends BaseEntity<T>> {

    private final BaseServiceImpl<T> genericService;

    protected BaseController(BaseRepository<T> repository) {
        this.genericService =new BaseServiceImpl<T>(repository){};
    }

    @Post
    public HttpResponse<?> save(@Body T entity) {
        return HttpResponse.ok(genericService.create(entity));
    }

}

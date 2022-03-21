package com.harak.Controller;

import com.harak.domain.CycleEntity;
import com.harak.generics.BaseController;
import com.harak.repository.CycleRepository;
import io.micronaut.http.annotation.Controller;

@Controller("/cycle")
public class CycleController extends BaseController<CycleEntity> {


    protected CycleController(CycleRepository cycleRepository) {
        super(cycleRepository);
    }

}

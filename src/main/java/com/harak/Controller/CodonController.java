package com.harak.Controller;

import com.harak.service.CodonService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

import javax.persistence.GeneratedValue;

@Controller
public class CodonController {

    @Inject
    private CodonService codonService;

    @Get("/populate")
    public HttpResponse<?> populateData(){
        try{
            codonService.populate();

        }catch (Exception e){
            e.printStackTrace();
        }
        return HttpResponse.ok();

    }

    @Get("/populate-async")
    public HttpResponse<?> populateAsyncData(){
        try{
            codonService.populateAsync();

        }catch (Exception e){
            e.printStackTrace();
        }
        return HttpResponse.ok();

    }

}

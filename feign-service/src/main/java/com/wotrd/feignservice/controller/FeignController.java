package com.wotrd.feignservice.controller;

import com.wotrd.feignservice.domain.Order;
import com.wotrd.feignservice.service.IProviderService;
import com.wotrd.nacos.common.conf.GlobalRequestBody;
import com.wotrd.nacos.common.conf.GlobalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("feign")
@RestController
public class FeignController {


    @Autowired
    private IProviderService providerService;

    @RequestMapping("add")
    public GlobalResponse add(@RequestBody @Valid GlobalRequestBody<Order> body){
        return providerService.addOrer(body);
    }

    @RequestMapping("getOrders")
    public GlobalResponse getOrders(){
        return providerService.getOrders();
    }

    @RequestMapping("helloFeign")
    public String helloFeign(){
        return providerService.helloFeign();
    }

    @RequestMapping("feignRetry")
    public String feignRetry(){
        return providerService.feignRetry();
    }

    @RequestMapping("getOrderById/{id}")
    public GlobalResponse getOrderById(@PathVariable("id") Long id){
        return providerService.findById(id);
    }


}

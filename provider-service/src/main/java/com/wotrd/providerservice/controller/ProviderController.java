package com.wotrd.providerservice.controller;

import com.wotrd.nacos.common.conf.GlobalRequestBody;
import com.wotrd.nacos.common.conf.GlobalResponse;
import com.wotrd.providerservice.domain.Order;
import com.wotrd.providerservice.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("provider")
@RestController
public class ProviderController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private ProviderService providerService;

    @RequestMapping("add")
    public GlobalResponse add(@RequestBody @Valid GlobalRequestBody<Order> body) {

        return providerService.add(body.getB());

    }

    @RequestMapping("getOrders")
    public GlobalResponse getOrders() {
        return providerService.getOrders();
    }

    @RequestMapping("helloFeign")
    public String helloFeign(){

        return "hello feign， serverport："+ serverPort;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public GlobalResponse findById(@PathVariable("id") Long id){
        return providerService.getOrderById(id);
    }

}

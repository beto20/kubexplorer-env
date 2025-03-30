package com.java1.demo;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "PersonFeign", url = "${person.url}")
public interface PersonFeign {

    @GetMapping("/api/full")
    List<PersonFull> getFull();
}

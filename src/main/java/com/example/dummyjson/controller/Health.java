package com.example.dummyjson.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/health")
@Tag(name = "Health Check")
public class Health {

    @GetMapping
    @Operation(summary = "Health Check")
    public String Health() {
        return "I'm healthy!";
    }
}

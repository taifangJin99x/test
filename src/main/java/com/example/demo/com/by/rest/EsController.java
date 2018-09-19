package com.example.demo.com.by.rest;

import com.example.demo.com.by.domain.EsTest;
import com.example.demo.com.by.repository.EsRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class EsController {
    private final EsRepository esRepository;

    public EsController(EsRepository esRepository) {
        this.esRepository = esRepository;
    }

    @RequestMapping("/getEs")
    public Iterable<EsTest> hello() {
        Iterable<EsTest> user = esRepository.findAll();
        return user;
    }
}

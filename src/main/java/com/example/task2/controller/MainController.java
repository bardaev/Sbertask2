package com.example.task2.controller;

import com.example.task2.pojo.Company;
import com.example.task2.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class MainController {
    private final ICompanyService companyService;
    private final Company source;
    private final Company destination;

    @Autowired
    public MainController(
            ICompanyService companyService,
            @Qualifier(value = "company1") Company company1,
            @Qualifier(value = "company2") Company company2
    ) {
        this.companyService = companyService;
        this.source = company1;
        this.destination = company2;
    }

    @GetMapping(path = "/incorporate")
    public ResponseEntity<String> incorporate() {
        companyService.handleCompany(source, destination);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/company1")
    public ResponseEntity<Integer> company1() {
        return new ResponseEntity<>(source.getSize(), HttpStatus.OK);
    }

    @GetMapping(path = "/company2")
    public ResponseEntity<Integer> company2() {
        return new ResponseEntity<>(destination.getSize(), HttpStatus.OK);
    }
}

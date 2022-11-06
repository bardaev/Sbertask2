package com.example.task2.service;

import com.example.task2.pojo.Company;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements ICompanyService {

    @Override
    public void handleCompany(Company source, Company destination) {
        destination.incorporate(source);
    }
}

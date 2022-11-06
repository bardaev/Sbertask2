package com.example.task2.config;

import com.example.task2.pojo.Company;
import com.example.task2.pojo.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class InitCompany {

    @Bean
    @Qualifier(value = "company1")
    public Company company1() {
        Company company = new Company();
        for (int i = 0; i < 1500; i++) {
            try {
                company.addEmployee(new Employee(UUID.randomUUID(), "name" + i, "mid" + i, "last" + i));
            } catch (Exception e) {
                break;
            }
        }
        return company;
    }

    @Bean
    @Qualifier(value = "company2")
    public Company company2() {
        Company company = new Company();
        for (int i = 0; i < 9000; i++) {
            try {
                company.addEmployee(new Employee(UUID.randomUUID(), "name" + i, "mid" + i, "last" + i));
            } catch (Exception e) {
                break;
            }
        }
        return company;
    }
}

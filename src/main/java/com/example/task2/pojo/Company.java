package com.example.task2.pojo;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private static final int EMPLOYEE_LIMIT = 10_000;
    private List<Employee> employees;

    public Company() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) throws Exception {
        if (employees.size() >= EMPLOYEE_LIMIT) {
            throw new Exception();
        } else {
            employees.add(employee);
        }
    }

    public Employee removeEmployee(int index) {
        return employees.remove(index);
    }

    public void incorporate(Company company) {
        int i = EMPLOYEE_LIMIT - getSize();
        if (company.getSize() < i) {
            i = company.getSize();
        }
        for (; i > 0; i--) {
            try {
                addEmployee(company.removeEmployee(i));
            } catch (Exception e) {
                break;
            }
        }
    }

    public int getSize() {
        return employees.size();
    }
}

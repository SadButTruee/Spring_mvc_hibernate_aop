package com.rtracee.spring.mvc_hibernate_aop.service;

import com.rtracee.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void addEmployee(Employee emp);

    Employee getEmployeeById(int id);

    void deleteEmployee(int id);
}

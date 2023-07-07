package com.rtracee.spring.mvc_hibernate_aop.dao;

import com.rtracee.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getAllEmployees();

    void addEmployee(Employee emp);

    Employee getEmployeeById(int id);
}

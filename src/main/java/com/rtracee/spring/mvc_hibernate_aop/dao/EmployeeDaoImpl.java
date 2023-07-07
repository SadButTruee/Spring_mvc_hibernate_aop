package com.rtracee.spring.mvc_hibernate_aop.dao;

import com.rtracee.spring.mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {

        Session session = sessionFactory.getCurrentSession();
        List<Employee> allEmployee = session.createQuery("from Employee", Employee.class).getResultList();

        return allEmployee;
    }

    @Override
    public void addEmployee(Employee emp) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(emp);
    }

    @Override
    public Employee getEmployeeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }
}

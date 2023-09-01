package com.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.api.models.Employee;

@Repository
public interface InterfaceEmployee extends CrudRepository<Employee, Integer>{
    List<Employee> findByStatus(Integer status);
}

package com.api.controllers;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.api.models.Employee;
import com.api.repository.InterfaceEmployee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private InterfaceEmployee interfaceEmployee;
	
	@GetMapping
	public List<Employee> employees()
	{
		return (List<Employee>)interfaceEmployee.findAll();
	}
	
	@PostMapping
	public ResponseEntity<String> InsertEmployee(@RequestBody Employee emp) {
	    Integer empId = emp.getId();
	    Integer empStatus = emp.getStatus();
	    String name = emp.getName();
	    String last_name  = emp.getLast_name();
	    String date_of_admission  = emp.getDate_of_admission();

	    if (StringUtils.isEmpty(name) || StringUtils.isEmpty(last_name) || StringUtils.isEmpty(date_of_admission)) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body("The field name, last name, and date of admission are required");
	    }
	    
	    if(empStatus > 1) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body("This status is not valid, the status can be only 0 or 1");
	    }
	    
	    if (empId != null && interfaceEmployee.existsById(empId)) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body("Employee with the id: " + empId + " already exists");
	    } else {
	        interfaceEmployee.save(emp);
	        return ResponseEntity.status(HttpStatus.CREATED).body("Employee created successfully");
	    }
	}
	
	@PutMapping
	public ResponseEntity<String> updateEmployee(@RequestBody Employee emp) {
	    Integer empStatus = emp.getStatus();
	    String name = emp.getName();
	    String last_name  = emp.getLast_name();
	    String date_of_admission  = emp.getDate_of_admission();

	    if (StringUtils.isEmpty(name) || StringUtils.isEmpty(last_name) || StringUtils.isEmpty(date_of_admission)) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body("The field name, last name, and date of admission are required");
	    }
	    
	    if(empStatus > 1) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body("This status is not valid, the status can be only 0 or 1");
	    }
	    
	    if (interfaceEmployee.existsById(emp.getId())) {
	        interfaceEmployee.save(emp);
	        return ResponseEntity.ok("Employee updated successfully");
	    } else {
	    	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
	    }
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Integer id, Employee emp) {
	    emp.setId(id);
	    if (interfaceEmployee.existsById(emp.getId())) {
	        interfaceEmployee.deleteById(id);
	        return ResponseEntity.ok("Employee delete successfully");
	    } else {
	    	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
	    }
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<String> updateStatusEmployee(@PathVariable("id") Integer id, @RequestBody Employee empUpdate) {
		
	    Optional<Employee> existingEmployeeOptional = interfaceEmployee.findById(id);

	    if (existingEmployeeOptional.isPresent()) {
	        Employee existingEmployee = existingEmployeeOptional.get();
	        
	        existingEmployee.setStatus(empUpdate.getStatus());
	        
	        interfaceEmployee.save(existingEmployee);
	        return ResponseEntity.ok("Employee status updated successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
	    }
	}


	@GetMapping("/employees/inactive")
	public List<Employee> getEmployeesWithStatus0() {
	    List<Employee> employeesWithStatus0 = interfaceEmployee.findByStatus(0); //
	    return employeesWithStatus0;
	}

	
}

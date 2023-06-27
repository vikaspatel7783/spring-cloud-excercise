package com.vikas.springcloud.employeeservice.repository;

import com.vikas.springcloud.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

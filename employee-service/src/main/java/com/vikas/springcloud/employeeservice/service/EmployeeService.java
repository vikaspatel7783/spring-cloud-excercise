package com.vikas.springcloud.employeeservice.service;

import com.vikas.springcloud.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto findEmployeeById(Long id);
}

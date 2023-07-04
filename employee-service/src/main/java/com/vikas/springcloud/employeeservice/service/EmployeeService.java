package com.vikas.springcloud.employeeservice.service;

import com.vikas.springcloud.employeeservice.dto.ApiResponse;
import com.vikas.springcloud.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    ApiResponse findEmployeeById(Long id);
}

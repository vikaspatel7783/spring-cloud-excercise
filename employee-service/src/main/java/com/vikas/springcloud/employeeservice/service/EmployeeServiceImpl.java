package com.vikas.springcloud.employeeservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vikas.springcloud.employeeservice.dto.EmployeeDto;
import com.vikas.springcloud.employeeservice.entity.Employee;
import com.vikas.springcloud.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private ObjectMapper objectMapper;

    private Employee toEmployeeEntity(EmployeeDto employeeDto) {
        return objectMapper.convertValue(employeeDto, Employee.class);
    }

    private EmployeeDto toEmployeeDto(Employee employeeEntity) {
        return objectMapper.convertValue(employeeEntity, EmployeeDto.class);
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        return toEmployeeDto(employeeRepository.save(toEmployeeEntity(employeeDto)));
    }

    @Override
    public EmployeeDto findEmployeeById(Long id) {
        Employee employeeById = employeeRepository.findById(id).get();
        return toEmployeeDto(employeeById);
    }
}

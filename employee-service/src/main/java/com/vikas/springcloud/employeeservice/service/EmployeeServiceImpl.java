package com.vikas.springcloud.employeeservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vikas.springcloud.employeeservice.dto.ApiResponse;
import com.vikas.springcloud.employeeservice.dto.DepartmentDto;
import com.vikas.springcloud.employeeservice.dto.EmployeeDto;
import com.vikas.springcloud.employeeservice.entity.Employee;
import com.vikas.springcloud.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ObjectMapper objectMapper;
//    private RestTemplate restTemplate;
//    private WebClient webClient;
    private FeignApiClient feignApiClient;

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
    public ApiResponse findEmployeeById(Long id) {
        Employee employeeById = employeeRepository.findById(id).get();

        // call using REST TEMPLATE
//        DepartmentDto departmentDto = restTemplate.getForEntity(
//                "http://localhost:8080/api/departments/"+employeeById.getDepartmentCode(),
//                DepartmentDto.class).getBody();

        // call using WebClient
//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/departments/"+employeeById.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();// Synchronous communication

        // call using Spring Cloud Feign client
        DepartmentDto departmentDto = feignApiClient.findByDepartmentCode(employeeById.getDepartmentCode());

        return new ApiResponse(toEmployeeDto(employeeById), departmentDto);
    }
}

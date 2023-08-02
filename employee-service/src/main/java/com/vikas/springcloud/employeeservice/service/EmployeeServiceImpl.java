package com.vikas.springcloud.employeeservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vikas.springcloud.employeeservice.dto.ApiResponse;
import com.vikas.springcloud.employeeservice.dto.DepartmentDto;
import com.vikas.springcloud.employeeservice.dto.EmployeeDto;
import com.vikas.springcloud.employeeservice.entity.Employee;
import com.vikas.springcloud.employeeservice.repository.EmployeeRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

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

//    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public ApiResponse findEmployeeById(Long id) {
        LOGGER.info("Inside findEmployeeById() method");
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

    public ApiResponse getDefaultDepartment(Long id, Exception e) {
        LOGGER.info("Inside getDefaultDepartment() method");
        Employee employeeById = employeeRepository.findById(id).get();

        // fallback department
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentCode("DEFAULT");
        departmentDto.setDepartmentName("DEFAULT DEPARTMENT");
        departmentDto.setDepartmentDescription("returning default department as department service is not responding");

        return new ApiResponse(toEmployeeDto(employeeById), departmentDto);
    }
}

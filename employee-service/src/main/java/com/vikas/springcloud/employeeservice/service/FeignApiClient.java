package com.vikas.springcloud.employeeservice.service;

import com.vikas.springcloud.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080/api", value = "department-service-feign-client")
public interface FeignApiClient {

    @GetMapping("departments/{department-code}")
    DepartmentDto findByDepartmentCode(@PathVariable("department-code") String departmentCode);
}

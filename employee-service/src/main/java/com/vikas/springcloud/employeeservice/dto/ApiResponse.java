package com.vikas.springcloud.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ApiResponse {
    private EmployeeDto employeeDto;
    private DepartmentDto departmentDto;
    private OrganizationDto organization;
}

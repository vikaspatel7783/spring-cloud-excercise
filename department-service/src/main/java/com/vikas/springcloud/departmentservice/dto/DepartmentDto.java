package com.vikas.springcloud.departmentservice.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class DepartmentDto {
    private Long id;

    @NotEmpty(message = "department name is mandatory")
    @Max(value = 20, message = "department name should not exceed than 20 characters")
    @Min(value = 5, message = "department name should at-least have 5 characters")
    private String departmentName;

    private String departmentDescription;

    @NotEmpty(message = "department code is mandatory")
    @Max(value = 15, message = "department code should not exceed more than 15 characters")
    @Min(value = 5, message = "department code should at-least have 5 characters")
    private String departmentCode;
}

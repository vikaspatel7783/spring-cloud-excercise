package com.vikas.springcloud.departmentservice.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class DepartmentDto {
    private Long id;

    @NotEmpty(message = "department name is mandatory")
    @Size(min = 3, max = 20, message = "department name should have minimum 3 and maximum 20 length")
    private String departmentName;

    private String departmentDescription;

    @NotEmpty(message = "department code is mandatory")
    @Size(min = 3, max = 20, message = "department code should have minimum 3 and maximum 20 length")
    private String departmentCode;
}

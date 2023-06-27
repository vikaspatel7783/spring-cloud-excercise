package com.vikas.springcloud.departmentservice.service;

import com.vikas.springcloud.departmentservice.dto.DepartmentDto;
import com.vikas.springcloud.departmentservice.entity.Department;

public interface DepartmentService {

    DepartmentDto save(DepartmentDto departmentDto);

    void delete(Long departmentId);

    DepartmentDto getDepartmentByCode(String departmentCode);
}

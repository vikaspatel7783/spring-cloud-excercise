package com.vikas.springcloud.departmentservice.service;

import com.vikas.springcloud.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

    DepartmentDto save(DepartmentDto departmentDto);

    void delete(Long departmentId);
}

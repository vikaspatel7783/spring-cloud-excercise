package com.vikas.springcloud.departmentservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vikas.springcloud.departmentservice.dto.DepartmentDto;
import com.vikas.springcloud.departmentservice.entity.Department;
import com.vikas.springcloud.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentRepository departmentRepository;
    private ObjectMapper objectMapper;

    private Department toDepartmentEntity(DepartmentDto departmentDto) {
        return objectMapper.convertValue(departmentDto, Department.class);
    }

    private DepartmentDto toDepartmentDto(Department departmentEntity) {
        return objectMapper.convertValue(departmentEntity, DepartmentDto.class);
    }

    @Override
    public DepartmentDto save(DepartmentDto departmentDto) {
        return toDepartmentDto(departmentRepository.save(toDepartmentEntity(departmentDto)));
    }

    @Override
    public void delete(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}

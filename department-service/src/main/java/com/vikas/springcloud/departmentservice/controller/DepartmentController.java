package com.vikas.springcloud.departmentservice.controller;

import com.vikas.springcloud.departmentservice.dto.DepartmentDto;
import com.vikas.springcloud.departmentservice.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody @Valid DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.save(departmentDto), HttpStatus.CREATED);
    }

    @DeleteMapping("{department-id}")
    public void deleteDepartment(@PathVariable("department-id") Long departmentId) {
        departmentService.delete(departmentId);
    }
}

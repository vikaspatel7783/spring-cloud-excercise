package com.vikas.springcloud.organizationservice.controller;

import com.vikas.springcloud.organizationservice.dto.OrganizationDto;
import com.vikas.springcloud.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<OrganizationDto> save(@RequestBody OrganizationDto organizationDto) {
        return new ResponseEntity<>(organizationService.save(organizationDto), HttpStatus.CREATED);
    }

    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> findByOrganizationCode(@PathVariable("code") String organizationCode) {
        return new ResponseEntity<>(organizationService.findByOrganizationCode(organizationCode), HttpStatus.OK);
    }

}

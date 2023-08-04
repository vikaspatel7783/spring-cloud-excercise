package com.vikas.springcloud.employeeservice.service;

import com.vikas.springcloud.employeeservice.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORGANIZATION-SERVICE")
public interface OrganizationServiceFeignApiClient {

    @GetMapping("api/organizations/{code}")
    OrganizationDto findByOrganizationCode(@PathVariable("code") String organizationCode);
}

package com.vikas.springcloud.organizationservice.service;

import com.vikas.springcloud.organizationservice.dto.OrganizationDto;

public interface OrganizationService {
    OrganizationDto save(OrganizationDto organizationDto);

    OrganizationDto findByOrganizationCode(String organizationCode);
}

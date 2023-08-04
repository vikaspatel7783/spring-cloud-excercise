package com.vikas.springcloud.organizationservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vikas.springcloud.organizationservice.dto.OrganizationDto;
import com.vikas.springcloud.organizationservice.entity.Organization;
import com.vikas.springcloud.organizationservice.repository.OrganizationRepository;
import com.vikas.springcloud.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;
    private ObjectMapper objectMapper;

    private OrganizationDto toOrganizationDto(Organization organization) {
        return objectMapper.convertValue(organization, OrganizationDto.class);
    }

    private Organization toOrganization(OrganizationDto organizationDto) {
        return objectMapper.convertValue(organizationDto, Organization.class);
    }

    @Override
    public OrganizationDto save(OrganizationDto organizationDto) {
        Organization organization = toOrganization(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);
        return toOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto findByOrganizationCode(String organizationCode) {
        return toOrganizationDto(organizationRepository.findByOrganizationCode(organizationCode));
    }
}

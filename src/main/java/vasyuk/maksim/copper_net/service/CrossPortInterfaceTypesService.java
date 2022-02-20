package vasyuk.maksim.copper_net.service;

import org.springframework.data.domain.Page;

import vasyuk.maksim.copper_net.dto.CrossPortInterfaceTypeDto;

public interface CrossPortInterfaceTypesService extends Service<CrossPortInterfaceTypeDto, CrossPortInterfaceTypeDto> {
    Page<CrossPortInterfaceTypeDto> getAllPage();
}

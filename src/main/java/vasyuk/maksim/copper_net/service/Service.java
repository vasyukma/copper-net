package vasyuk.maksim.copper_net.service;

import java.util.List;

interface Service<DTO, FOR_UPDATE_DTO> {
    List<DTO> getAll();

    DTO getById(Long id);

    DTO create(FOR_UPDATE_DTO dto);
    
    DTO update(FOR_UPDATE_DTO dto);
}

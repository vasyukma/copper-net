package vasyuk.maksim.copper_net.service;

import java.util.List;

interface Service<DTO> {
    List<DTO> getAll();

    DTO getById(Long id);

    DTO create(DTO dto);
    
    DTO update(DTO dto);
}

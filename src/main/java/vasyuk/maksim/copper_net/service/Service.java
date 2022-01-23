package vasyuk.maksim.copper_net.service;

import java.util.List;

interface Service<DTO> {
    List<DTO> getAll();

    DTO get(Long id);

    DTO post(DTO dto);
    
    DTO put(DTO dto);
}

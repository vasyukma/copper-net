package vasyuk.maksim.copper_net.service;

import java.util.List;

interface CommonService<DTO> {
    List<DTO> getAll();

    DTO getById(Long id);

    DTO add(DTO item) throws Exception;
}
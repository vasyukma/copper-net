package vasyuk.maksim.copper_net.dao;

import java.util.List;

interface CommonDao<DTO> {
    List<DTO> findAll();

    DTO findById(Long id);

    DTO save(DTO dto);
}

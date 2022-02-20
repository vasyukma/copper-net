package vasyuk.maksim.copper_net.service;

import org.springframework.data.domain.Page;

import vasyuk.maksim.copper_net.dto.NodeTypeDto;

public interface NodeTypesService extends Service<NodeTypeDto, NodeTypeDto> {
    Page<NodeTypeDto> getAllPage(Integer pageNumber, Integer pageSize, String sortBy);
}

package vasyuk.maksim.copper_net.dao;

import java.util.List;

import vasyuk.maksim.copper_net.dto.dao.NodeDto;
import vasyuk.maksim.copper_net.dto.dao.NodeTypeDto;


public interface NodesDao {
    List<NodeDto> getAll();

    NodeDto getById(Long id);

    List<NodeTypeDto> getTypes();
    
    void save(NodeDto nodeDto);
}

package vasyuk.maksim.copper_net.dao;

import java.util.List;

import vasyuk.maksim.copper_net.dao.node_types.NodeTypeDto;
import vasyuk.maksim.copper_net.dao.nodes.dto.NodeDto;


public interface NodesDao {
    List<NodeDto> getAll();

    NodeDto getById(Long id);

    List<NodeTypeDto> getTypes();
    
    NodeDto save(NodeDto nodeDto);
}

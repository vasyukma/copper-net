package vasyuk.maksim.copper_net.service.node_types;

import java.util.List;

import vasyuk.maksim.copper_net.service.node_types.model.NodeType;

public interface NodeTypes {

    NodeType getById(Long id);
    
    List<NodeType> getAll();
}

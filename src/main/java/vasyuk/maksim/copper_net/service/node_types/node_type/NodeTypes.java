package vasyuk.maksim.copper_net.service.node_types.node_type;

import java.util.List;

public interface NodeTypes {

    NodeType getById(Long id);
    
    List<NodeType> getAll();
}

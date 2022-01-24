package vasyuk.maksim.copper_net.dto.node_type;

import org.mapstruct.Mapper;

import vasyuk.maksim.copper_net.repository.model.NodeType;

@Mapper
public interface NodeTypeMapper {
    
    NodeType map(NodeTypeDto dto);

    NodeTypeDto map(NodeType entity);
}
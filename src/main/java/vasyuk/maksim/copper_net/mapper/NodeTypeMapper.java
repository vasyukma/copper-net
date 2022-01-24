package vasyuk.maksim.copper_net.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import vasyuk.maksim.copper_net.dto.NodeTypeDto;
import vasyuk.maksim.copper_net.model.NodeType;

@Mapper
public interface NodeTypeMapper {
    NodeType map(NodeTypeDto dto);

    NodeTypeDto map(NodeType entity);

    List<NodeTypeDto> map(List<NodeType> models);
    
    void updateModel(NodeTypeDto dto, @MappingTarget NodeType model); 
}
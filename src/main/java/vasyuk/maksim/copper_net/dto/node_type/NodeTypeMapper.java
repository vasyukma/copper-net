package vasyuk.maksim.copper_net.dto.node_type;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import vasyuk.maksim.copper_net.repository.model.NodeType;

@Mapper
public interface NodeTypeMapper {
    
//    NodeTypeMapper INSTANCE = Mappers.getMapper( NodeType.class );
//  @Mapping(source = "make", target = "manufacturer")
//  @Mapping(source = "numberOfSeats", target = "seatCount")
    NodeType ToEntity(NodeTypeDto dto);

    NodeTypeDto ToDto(NodeType entity);
}
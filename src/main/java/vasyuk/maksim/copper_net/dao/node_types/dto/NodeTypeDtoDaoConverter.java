package vasyuk.maksim.copper_net.dao.node_types.dto;

import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dao.node_types.NodeType;
import vasyuk.maksim.copper_net.dao.node_types.NodeTypeDto;
import vasyuk.maksim.copper_net.service.common.dto.DtoConverter;

@Service
public class NodeTypeDtoDaoConverter implements DtoConverter<NodeType, NodeTypeDto> {

    @Override
    public NodeTypeDto toDto(NodeType model, NodeTypeDto dto) {

        dto.id = model.getId();
        dto.shortName = model.getShortName();
        dto.longName = model.getLongName();
        dto.description = model.getDescription();

        return dto;
    }

    @Override
    public NodeType toModel(NodeTypeDto dto, NodeType model) {
        // TODO Auto-generated method stub
        return null;
    }

}

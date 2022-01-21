package vasyuk.maksim.copper_net.service.node_types.dto;

import org.springframework.stereotype.Service;


import vasyuk.maksim.copper_net.service.common.dto.DtoConverter;
import vasyuk.maksim.copper_net.service.node_types.model.NodeType;

@Service
public class NodeTypeDtoServiceConverter implements DtoConverter<NodeType, NodeTypeDto> {
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
        model.setId(dto.id);
        model.setShortName(dto.shortName);
        model.setLongName(dto.longName);
        model.setDescription(dto.description);
        return model;
    }
}

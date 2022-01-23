package vasyuk.maksim.copper_net.service.node_types.dto;

import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dto.DtoConvertor;
import vasyuk.maksim.copper_net.dto.node_type.NodeTypeDto;
import vasyuk.maksim.copper_net.dto.node_type.NodeTypeDtoCommon;
import vasyuk.maksim.copper_net.service.node_types.model.NodeType;

@Service
public class NodeTypeDtoServiceConvertor implements DtoConvertor<NodeType, NodeTypeDtoCommon> {
    @Override
    public NodeTypeDtoCommon toDto(NodeType model) {
        return new NodeTypeDto.Common.Creator(model.getId(), model.getShortName(), model.getLongName(), model
                .getDescription());
//        dto.id = model.getId();
//        dto.shortName = model.getShortName();
//        dto.longName = model.getLongName();
//        dto.description = model.getDescription();
//        return dto;
    }

    @Override
    public NodeType toModel(NodeTypeDtoCommon dto) {
//        NodeType model = 
//        model.setId(dto.id);
//        model.setShortName(dto.shortName);
//        model.setLongName(dto.longName);
//        model.setDescription(dto.description);
//        return model;
        return null;
    }
}

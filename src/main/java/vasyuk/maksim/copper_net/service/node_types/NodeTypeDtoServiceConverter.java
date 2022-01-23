package vasyuk.maksim.copper_net.service.node_types;

import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dto.DtoConverter;
import vasyuk.maksim.copper_net.dto.node_type.NodeTypeDto;
import vasyuk.maksim.copper_net.dto.node_type.NodeTypeDtoCommon;
import vasyuk.maksim.copper_net.repository.model.NodeType;

@Service
class NodeTypeDtoServiceConverter implements DtoConverter<NodeType, NodeTypeDtoCommon> {
    @Override
    public NodeTypeDtoCommon toDto(NodeType model) {
        return new NodeTypeDto.Common.Creator(model.getId(), model.getShortName(), model.getLongName(), model
                .getDescription());
    }

    @Override
    public NodeType toModel(NodeTypeDtoCommon dto) {
        return null;
    }
}

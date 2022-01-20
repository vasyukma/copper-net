package vasyuk.maksim.copper_net.service.dto;

import vasyuk.maksim.copper_net.dto.service.NodeTypeDto;
import vasyuk.maksim.copper_net.service.node_types.node_type.NodeType;

public class NodeTypeToDto implements ToDto<NodeType, NodeTypeDto> {

    @Override
    public NodeTypeDto convert(NodeType item, NodeTypeDto dto) {
        dto.id = item.getId();
        dto.shortName = item.getShortName();
        dto.longName = item.getLongName();
        dto.description = item.getDescription();
        return dto;
    }
}

package vasyuk.maksim.copper_net.service.node_types;

import vasyuk.maksim.copper_net.dto.DtoCommonConverter;
import vasyuk.maksim.copper_net.dto.node_type.NodeTypeDtoDep;
import vasyuk.maksim.copper_net.repository.model.NodeType;

interface NodeTypeDtoConverter extends DtoCommonConverter<NodeType, NodeTypeDtoDep>{
}

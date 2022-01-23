package vasyuk.maksim.copper_net.service.node_types;

import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dto.node_type.NodeTypeDtoEnum;
import vasyuk.maksim.copper_net.dto.node_type.NodeTypeDtoDep;
import vasyuk.maksim.copper_net.repository.model.NodeType;

@Service
class NodeTypeDtoConverterImpl implements NodeTypeDtoConverter {
    @Override
    public NodeTypeDtoDep toDto(NodeType model) {
        return new NodeTypeDtoEnum.Common.New(model.getId(), model.getShortName(), model.getLongName(), model
                .getDescription());
    }

    @Override
    public NodeType toModel(NodeTypeDtoDep dto) {
        return new NodeType(dto.getId(), dto.getShortName(), dto.getLongName(), dto.getDescription());
    }
}

package vasyuk.maksim.copper_net.dao.node_types;

import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dto.node_type.NodeTypeDtoCommon;

@Service
class DtoConverterImpl implements DtoConverter {
    @Override
    public NodeTypeDtoCommon toDto(NodeType model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public NodeType toModel(NodeTypeDtoCommon dto) {
        NodeType model = new NodeType();
        model.setId(dto.getId());
        model.setShortName(dto.getShortName());
        model.setLongName(dto.getLongName());
        model.setDescription(dto.getDescription());
        return model;
    }
}

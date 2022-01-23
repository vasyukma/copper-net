package vasyuk.maksim.copper_net.dao.node_types;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dao.DaoDtoConverter;
import vasyuk.maksim.copper_net.dao.NodeTypesDao;
import vasyuk.maksim.copper_net.dto.node_type.NodeTypeDto;
import vasyuk.maksim.copper_net.dto.node_type.NodeTypeDtoCommon;

@Service
class NodeTypesDaoImpl implements NodeTypesDao {
    private NodeTypesRepository nodeTypesRepository;
    private DaoDtoConverter<NodeType, NodeTypeDtoCommon> dtoConvertor;

    @Autowired
    protected NodeTypesDaoImpl(NodeTypesRepository nodeTypesRepository,
            DaoDtoConverter<NodeType, NodeTypeDtoCommon> dtoConvertor) {
        this.nodeTypesRepository = nodeTypesRepository;
    }

    @Override
    public List<NodeTypeDtoCommon> findAll() {
        List<NodeTypeDtoCommon> result = new ArrayList<>();
        for (NodeType model : nodeTypesRepository.findAll()) {
            result.add(convertToDtoCommon(model));
        }
        return result;
    }

    @Override
    public NodeTypeDtoCommon findById(Long id) {
        return convertToDtoCommon(nodeTypesRepository.getById(id));
    }

    @Override
    public NodeTypeDtoCommon save(NodeTypeDtoCommon dto) {
        // TODO Auto-generated method stub
        return null;
    }

    private NodeTypeDtoCommon convertToDtoCommon(NodeType model) {
        return new NodeTypeDto.Common.Creator(model.getId(), model.getShortName(), model.getLongName(), model
                .getDescription());
    }

    private NodeType convertToModel(NodeTypeDtoCommon dto) {
        NodeType model = new NodeType();
        model.setId(dto.getId());
        model.setShortName(dto.getShortName());
        model.setLongName(dto.getLongName());
        model.setDescription(dto.getDescription());
        return model;
    }
}

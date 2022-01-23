package vasyuk.maksim.copper_net.dao.nodes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dao.NodesDao;
import vasyuk.maksim.copper_net.dao.node_types.NodeTypesRepository;
import vasyuk.maksim.copper_net.dto.node.NodeDto;
import vasyuk.maksim.copper_net.dto.node.NodeDtoCommon;

@Service
public class NodesDaoImpl implements NodesDao {
    private NodesRepository nodesRepository;
    private NodeTypesRepository nodeTypesRepository;

    @Autowired
    public NodesDaoImpl(NodesRepository nodeRepository, NodeTypesRepository nodeTypeRepository) {
        super();
        this.nodesRepository = nodeRepository;
        this.nodeTypesRepository = nodeTypeRepository;
    }

    @Override
    public List<NodeDtoCommon> findAll() {
        List<NodeDtoCommon> result = new ArrayList<>();
        for (Node model : nodesRepository.findAll()) {
            result.add(convertToDtoCommon(model));
        }
        return result;
    }

//    @Override
//    public List<NodeTypeDtoCommon> getTypes() {
//        List<NodeTypeDtoCommon> result = new ArrayList<>();
//        nodeTypesRepository.findAll().stream().forEach(model -> {
//            result.add(new NodeTypeDto.Common.Create(model.getId(), model.getShortName(), model.getLongName(), model
//                    .getDescription()));
//        });
//        return result;
//    }

    @Override
    public NodeDtoCommon findById(Long id) {
        return convertToDtoCommon(nodesRepository.getById(id));
    }

    @Override
    public NodeDtoCommon save(NodeDtoCommon dto) {
        var model = nodesRepository.save(convertToModelForAdd(dto));
        return convertToDtoCommon(model);
    }

    private NodeDtoCommon convertToDtoCommon(Node model) {
        return new NodeDto.Common.Creator(model.getId(), model.getShortName(), model.getLongName(), model
                .getDescription(), model.getType().getId(), model.getParent().getId());
    }

    private Node convertToModelForAdd(NodeDtoCommon dto) {
        Node model = new Node();
        model.setShortName(dto.getShortName());
        model.setLongName(dto.getLongName());
        model.setDescription(dto.getDescription());
        model.setParent(nodesRepository.getById(dto.getParentId()));
        model.setType(nodeTypesRepository.getById(dto.getTypeId()));
        return model;
    }
}

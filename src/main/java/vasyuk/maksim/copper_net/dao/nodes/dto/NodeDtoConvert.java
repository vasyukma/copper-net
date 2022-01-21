package vasyuk.maksim.copper_net.dao.nodes.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dao.node_types.NodeTypesRepository;
import vasyuk.maksim.copper_net.dao.nodes.Node;
import vasyuk.maksim.copper_net.dao.nodes.NodesRepository;
import vasyuk.maksim.copper_net.service.common.dto.DtoConvert;

@Service
public class NodeDtoConvert implements DtoConvert<Node, NodeDto> {
    private NodesRepository nodesRepository;
    private NodeTypesRepository nodeTypesRepository;

    @Autowired
    protected NodeDtoConvert(NodesRepository nodesRepository, NodeTypesRepository nodeTypesRepository) {
        super();
        this.nodesRepository = nodesRepository;
        this.nodeTypesRepository = nodeTypesRepository;
    }

    @Override
    public NodeDto toDto(Node model, NodeDto dto) {
        dto.id = model.getId();
        dto.shortName = model.getShortName();
        dto.longName = model.getLongName();
        dto.description = model.getDescription();
        dto.typeId = model.getType().getId();
        if (model.getParent() != null) {
            dto.parentId = model.getParent().getId();
        }
        return dto;
    }

    @Override
    public Node toModel(NodeDto dto, Node model) {
        model.setShortName(dto.shortName);
        model.setLongName(dto.longName);
        model.setDescription(dto.description);
        model.setParent(nodesRepository.getById(dto.parentId));
        model.setType(nodeTypesRepository.getById(dto.typeId));
        return model;
    }
}

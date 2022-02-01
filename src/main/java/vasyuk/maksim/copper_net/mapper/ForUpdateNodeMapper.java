package vasyuk.maksim.copper_net.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import vasyuk.maksim.copper_net.dto.NodeDto;
import vasyuk.maksim.copper_net.dto.ForUpdateNodeDto;
import vasyuk.maksim.copper_net.model.Node;
import vasyuk.maksim.copper_net.model.NodeType;
import vasyuk.maksim.copper_net.repository.NodeTypesRepository;
import vasyuk.maksim.copper_net.repository.NodesRepository;

@Mapper
public abstract class ForUpdateNodeMapper {
    @Autowired
    protected NodeTypesRepository nodeTypeRepository;
    @Autowired
    protected NodesRepository nodesRepository;

    @Mapping(source = "typeId", target = "type", qualifiedByName = "get_node_type")
    @Mapping(source = "parentId", target = "parent", qualifiedByName = "get_node")
    public abstract Node map(ForUpdateNodeDto dto);

    @Named("get_node_type")
    public NodeType getNodeType(Long id) {
        NodeType model = nodeTypeRepository.getById(id);
        return model;
    }

    @Named("get_node")
    public Node getNode(Long id) {
        Node model = nodesRepository.getById(id);
        return model;
    }

    @Mapping(source = "parent.id", target = "parentId")
    @Mapping(source = "type", target = "type")
    public abstract NodeDto map(Node model);

    public abstract List<NodeDto> map(List<Node> models);

    @Mapping(source = "typeId", target = "type", qualifiedByName = "get_node_type")
    @Mapping(source = "parentId", target = "parent", qualifiedByName = "get_node")
    public abstract void updateModel(ForUpdateNodeDto dto, @MappingTarget Node model);
}

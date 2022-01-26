package vasyuk.maksim.copper_net.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import vasyuk.maksim.copper_net.dto.TailDto;
import vasyuk.maksim.copper_net.model.Node;
import vasyuk.maksim.copper_net.model.Tail;
import vasyuk.maksim.copper_net.repository.NodesRepository;

@Mapper
public abstract class TailMapper {

//    @Autowired
//    private LinksRepository linksRepository;

    @Autowired
    private NodesRepository nodesRepository;

//    @Mapping(source = "linkId", target = "link", qualifiedByName = "get_link")
    @Mapping(source = "nodeId", target = "node", qualifiedByName = "get_node")
    public abstract Tail map(TailDto dto);

//    @Named("get_link")
//    public Link getLink(Long id) {
//        Link model = linksRepository.getById(id);
//        return model;
//    }

    @Named("get_node")
    public Node getNode(Long id) {
        Node model = nodesRepository.getById(id);
        return model;
    }

//    @Mapping(source = "link.id", target = "linkId")
    @Mapping(source = "node.id", target = "nodeId")
    public abstract TailDto map(Tail entity);

    public abstract List<TailDto> map(List<Tail> models);

//    @Mapping(source = "linkId", target = "link", qualifiedByName = "get_link")
    @Mapping(source = "nodeId", target = "node", qualifiedByName = "get_node")
    public abstract void updateModel(TailDto dto, @MappingTarget Tail model);
}

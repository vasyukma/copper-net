package vasyuk.maksim.copper_net.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import vasyuk.maksim.copper_net.dto.TailDto;
import vasyuk.maksim.copper_net.model.Link;
import vasyuk.maksim.copper_net.model.Node;
import vasyuk.maksim.copper_net.model.Tail;
import vasyuk.maksim.copper_net.repository.LinksRepository;
import vasyuk.maksim.copper_net.repository.NodesRepository;
import vasyuk.maksim.copper_net.service.NodesService;

@Mapper
public abstract class TailMapper {
    @Autowired
    private LinksRepository linksRepository;
    @Autowired
    private NodesRepository nodesRepository;
//    @Autowired
//    private NodesService nodesService;

    @Mapping(source = "linkId", target = "link", qualifiedByName = "get_link")
    @Mapping(source = "nodeId", target = "node", qualifiedByName = "get_node")
    public abstract Tail map(TailDto dto);

    @Named("get_link")
    public Link getLink(Long id) {
        Link model = linksRepository.getById(id);
        return model;
    }

    @Named("get_node")
    public Node getNode(Long id) {
        Node model = nodesRepository.getById(id);
        return model;
    }

    @Mapping(source = "link.id", target = "linkId")
    @Mapping(source = "node.id", target = "nodeId")
//    @Mapping(target = "path", qualifiedByName = "get_path")
    public abstract TailDto map(Tail entity);


    public abstract List<TailDto> map(List<Tail> models);

//    @Named("get_path")
//    public String getTextNodePath(Long id) {
//        return nodesService.getTextPath(id);
//    }

    @Mapping(source = "linkId", target = "link", qualifiedByName = "get_link")
    @Mapping(source = "nodeId", target = "node", qualifiedByName = "get_node")
    public abstract void updateModel(TailDto dto, @MappingTarget Tail model);
}

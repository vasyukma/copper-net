package vasyuk.maksim.copper_net.mapper;

import java.util.Deque;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import vasyuk.maksim.copper_net.dto.NodeDto;
import vasyuk.maksim.copper_net.model.Node;

@Mapper
public abstract class NodeMapper {
    @Mapping(source = "parent.id", target = "parentId")
    public abstract NodeDto map(Node model);

    public abstract List<NodeDto> map(List<Node> models);
    
//    public abstract Deque<NodeDto> map(Deque<Node> models);
}

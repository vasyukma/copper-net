package vasyuk.maksim.copper_net.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import vasyuk.maksim.copper_net.dto.NodePathDto;
import vasyuk.maksim.copper_net.model.Node;

@Mapper
public abstract class NodePathMapper {
    abstract NodePathDto map(String text, List<Node> models);
}

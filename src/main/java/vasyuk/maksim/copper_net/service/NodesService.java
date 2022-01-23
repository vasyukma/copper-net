package vasyuk.maksim.copper_net.service;

import java.util.List;

import vasyuk.maksim.copper_net.dto.node.NodeDto;
import vasyuk.maksim.copper_net.dto.node.NodeDtoRoot;

public interface NodesService extends Service<NodeDto> {
    List<NodeDto> getChildren(Long parentId);

    NodeDtoRoot getRoot();
}

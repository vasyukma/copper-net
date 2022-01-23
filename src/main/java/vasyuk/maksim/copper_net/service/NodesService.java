package vasyuk.maksim.copper_net.service;

import java.util.List;

import vasyuk.maksim.copper_net.dto.node.NodeDtoCommon;
import vasyuk.maksim.copper_net.dto.node.NodeDtoRoot;

public interface NodesService extends Service<NodeDtoCommon> {
    List<NodeDtoCommon> getChildren(Long parentId);

    NodeDtoRoot getRoot();
}

package vasyuk.maksim.copper_net.service;

import java.util.List;

import vasyuk.maksim.copper_net.dto.node.NodeDtoCommon;

public interface NodesService extends CommonService<NodeDtoCommon> {
    List<NodeDtoCommon> getChildren(Long id);

    NodeDtoCommon getRoot();
}

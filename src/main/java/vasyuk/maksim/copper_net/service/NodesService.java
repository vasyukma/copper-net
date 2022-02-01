package vasyuk.maksim.copper_net.service;

import java.util.List;

import vasyuk.maksim.copper_net.dto.ForUpdateNodeDto;
import vasyuk.maksim.copper_net.dto.NodeDto;

public interface NodesService extends Service<NodeDto, ForUpdateNodeDto> {
    List<NodeDto> getChildren(Long parentId);

    NodeDto getRoot();
    
    Long getParentsCount(Long nodeId);
}

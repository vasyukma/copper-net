package vasyuk.maksim.copper_net.service;

import java.util.List;

import vasyuk.maksim.copper_net.dto.ForUpdateNodeDto;
import vasyuk.maksim.copper_net.dto.NodeDto;
import vasyuk.maksim.copper_net.dto.NodePathDto;
import vasyuk.maksim.copper_net.dto.TextNodePathDto;
import vasyuk.maksim.copper_net.model.Node;

public interface NodesService extends Service<NodeDto, ForUpdateNodeDto> {
    List<NodeDto> getChildren(Long parentId);

    NodeDto getRoot();
    
    Long getParentsCount(Long nodeId);
    
//    List<NodeDto> getPathDto(Long nodeId);
    
    NodePathDto getPath(Long nodeId);
    
//    TextNodePathDto getTextPath(Long nodeId);
}

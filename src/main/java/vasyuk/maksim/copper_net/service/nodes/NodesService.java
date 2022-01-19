package vasyuk.maksim.copper_net.service.nodes;

import java.util.List;

import vasyuk.maksim.copper_net.dto.service.NodeDto;

public interface NodesService {
    List<NodeDto> getChildren(Long id);

    NodeDto getRoot();

    NodeDto getById(Long id);

    void add(NodeDto nodeDto) throws Exception;
}

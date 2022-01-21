package vasyuk.maksim.copper_net.service;

import java.util.List;

import vasyuk.maksim.copper_net.service.nodes.dto.NodeDto;

public interface NodesService {
    List<NodeDto> getChildren(Long id);

    NodeDto getRoot();

    NodeDto getById(Long id);

    void add(NodeDto nodeDto) throws Exception;
}

package vasyuk.maksim.copper_net.service.nodes.dto;

import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dto.DtoConvertor;
import vasyuk.maksim.copper_net.dto.node.NodeDtoCommon;
import vasyuk.maksim.copper_net.service.nodes.model.Node;

@Service
public class NodeDtoServiceConverter implements DtoConvertor<Node, NodeDtoCommon> {
    @Override
    public NodeDtoCommon toDto(Node model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Node toModel(NodeDtoCommon dto) {
        // TODO Auto-generated method stub
        return null;
    }
}

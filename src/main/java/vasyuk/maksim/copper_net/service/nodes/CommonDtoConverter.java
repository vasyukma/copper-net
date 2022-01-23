package vasyuk.maksim.copper_net.service.nodes;

import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dto.DtoConverter;
import vasyuk.maksim.copper_net.dto.node.NodeDto;
import vasyuk.maksim.copper_net.dto.node.NodeDtoCommon;
import vasyuk.maksim.copper_net.repository.model.Node;

@Service
class CommonDtoConverter implements DtoConverter<Node, NodeDtoCommon> {
    @Override
    public NodeDtoCommon toDto(Node model) {
        return new NodeDto.Common.Creater(model.getId(), model.getShortName(), model.getLongName(), model
                .getDescription(), model.getType().getId(), model.getParent().getId());
    }

    @Override
    public Node toModel(NodeDtoCommon dto) {
        // TODO Auto-generated method stub
        return null;
    }
}

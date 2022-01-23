package vasyuk.maksim.copper_net.service.nodes;

import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dto.DtoCommonConverter;
import vasyuk.maksim.copper_net.dto.node.NodeDtoEnum;
import vasyuk.maksim.copper_net.dto.node.NodeDtoRoot;
import vasyuk.maksim.copper_net.repository.model.Node;

@Service
class RootDtoConverter implements DtoCommonConverter<Node, NodeDtoRoot> {
    @Override
    public NodeDtoRoot toDto(Node model) {
        return new NodeDtoEnum.Special.Root(model.getId(), model.getShortName(), model.getLongName(), model
                .getDescription(), model.getType().getId());
    }

    @Override
    public Node toModel(NodeDtoRoot dto) {
        // TODO Auto-generated method stub
        return null;
    }
}

package vasyuk.maksim.copper_net.service.nodes;

import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dto.DtoCommonConverter;
import vasyuk.maksim.copper_net.dto.node.NodeDtoEnum;
import vasyuk.maksim.copper_net.dto.node.NodeDto;
import vasyuk.maksim.copper_net.repository.model.Node;

@Service
class CommonDtoConverter implements DtoCommonConverter<Node, NodeDto> {
    @Override
    public NodeDto toDto(Node model) {
        return new NodeDtoEnum.Common.New(model.getId(), model.getShortName(), model.getLongName(), model
                .getDescription(), model.getType().getId(), model.getParent().getId());
    }

    @Override
    public Node toModel(NodeDto dto) {
        // TODO Auto-generated method stub
        return null;
    }
}

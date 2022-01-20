package vasyuk.maksim.copper_net.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dto.service.NodeTypeDto;
import vasyuk.maksim.copper_net.service.common.SimpleTableService;
import vasyuk.maksim.copper_net.service.dto.NodeTypeToDto;
import vasyuk.maksim.copper_net.service.node_types.node_type.NodeType;
import vasyuk.maksim.copper_net.service.node_types.node_type.NodeTypes;

@Service
public class NodeTypesServiceImpl implements NodeTypesService<NodeTypeDto> {

    private NodeTypes nodeTypes;

    @Autowired
    public NodeTypesServiceImpl(NodeTypes nodeTypes) {
        this.nodeTypes = nodeTypes;
    }

    @Override
    public List<NodeTypeDto> getAll() {
        List<NodeTypeDto> result = new ArrayList<>();
        for (NodeType nodeType : nodeTypes.getAll()) {

//            NodeTypeDto nodeTypeDto = new NodeTypeDto();
//            nodeTypeDto.id = nodeType.getId();
//            nodeTypeDto.shortName = nodeType.getShortName();
//            nodeTypeDto.longName = nodeType.getLongName();
//            nodeTypeDto.description = nodeType.getDescription();
            result.add(new NodeTypeToDto().convert(nodeType, new NodeTypeDto()));
//            result.add(nodeTypeDto);
        }
        return result;
    }

    @Override
    public void add(NodeTypeDto item) {
        // TODO Auto-generated method stub

    }

    @Override
    public NodeTypeDto getById(Long id) {

//        NodeType nodeType = nodeTypes.getById(id);
//        NodeTypeDto nodeTypeDto = new NodeTypeDto();
//        nodeTypeDto.id = nodeType.getId();
//        nodeTypeDto.shortName = nodeType.getShortName();
//        nodeTypeDto.longName = nodeType.getLongName();
//        nodeTypeDto.description = nodeType.getDescription();
        return new NodeTypeToDto().convert(nodeTypes.getById(id), new NodeTypeDto());
//        return nodeTypeDto;
    }

}

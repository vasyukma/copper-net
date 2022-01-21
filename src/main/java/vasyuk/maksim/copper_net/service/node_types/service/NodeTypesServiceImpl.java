package vasyuk.maksim.copper_net.service.node_types.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.service.NodeTypesService;
import vasyuk.maksim.copper_net.service.node_types.NodeTypes;
import vasyuk.maksim.copper_net.service.node_types.dto.NodeTypeDto;
import vasyuk.maksim.copper_net.service.node_types.dto.NodeTypeDtoServiceConverter;
import vasyuk.maksim.copper_net.service.node_types.model.NodeType;

@Service
public class NodeTypesServiceImpl implements NodeTypesService<NodeTypeDto> {
    private NodeTypes nodeTypes;
    private NodeTypeDtoServiceConverter nodeTypeDtoServiceConverter;

    @Autowired
    public NodeTypesServiceImpl(NodeTypes nodeTypes, NodeTypeDtoServiceConverter nodeTypeDtoServiceConverter) {
        this.nodeTypes = nodeTypes;
        this.nodeTypeDtoServiceConverter = nodeTypeDtoServiceConverter;
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
            result.add(nodeTypeDtoServiceConverter.toDto(nodeType, new NodeTypeDto()));
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
        return nodeTypeDtoServiceConverter.toDto(nodeTypes.getById(id), new NodeTypeDto());
//        return nodeTypeDto;
    }
}

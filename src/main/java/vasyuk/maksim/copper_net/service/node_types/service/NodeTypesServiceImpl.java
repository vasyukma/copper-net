package vasyuk.maksim.copper_net.service.node_types.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.service.NodeTypesService;
import vasyuk.maksim.copper_net.service.node_types.NodeTypes;
import vasyuk.maksim.copper_net.service.node_types.dto.NodeTypeDto;
import vasyuk.maksim.copper_net.service.node_types.dto.NodeTypeDtoConvert;
import vasyuk.maksim.copper_net.service.node_types.model.NodeType;

@Service
public class NodeTypesServiceImpl implements NodeTypesService<NodeTypeDto> {
    private NodeTypes nodeTypes;
    private NodeTypeDtoConvert nodeTypeDtoConvert;

    @Autowired
    public NodeTypesServiceImpl(NodeTypes nodeTypes, NodeTypeDtoConvert nodeTypeDtoConvert) {
        this.nodeTypes = nodeTypes;
        this.nodeTypeDtoConvert = nodeTypeDtoConvert;
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
            result.add(nodeTypeDtoConvert.toDto(nodeType, new NodeTypeDto()));
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
        return nodeTypeDtoConvert.toDto(nodeTypes.getById(id), new NodeTypeDto());
//        return nodeTypeDto;
    }
}

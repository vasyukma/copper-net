package vasyuk.maksim.copper_net.service.node_types.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dto.node_type.NodeTypeDtoCommon;
import vasyuk.maksim.copper_net.service.NodeTypesService;
import vasyuk.maksim.copper_net.service.node_types.NodeTypes;
import vasyuk.maksim.copper_net.service.node_types.dto.NodeTypeDtoServiceConvertor;
import vasyuk.maksim.copper_net.service.node_types.model.NodeType;

@Service
public class NodeTypesServiceImpl implements NodeTypesService {
    private NodeTypes nodeTypes;
    private NodeTypeDtoServiceConvertor nodeTypeDtoServiceConverter;

    @Autowired
    public NodeTypesServiceImpl(NodeTypes nodeTypes, NodeTypeDtoServiceConvertor nodeTypeDtoServiceConverter) {
        this.nodeTypes = nodeTypes;
        this.nodeTypeDtoServiceConverter = nodeTypeDtoServiceConverter;
    }

    @Override
    public List<NodeTypeDtoCommon> getAll() {
        List<NodeTypeDtoCommon> result = new ArrayList<>();
        for (NodeType nodeType : nodeTypes.getAll()) {
//            NodeTypeDto nodeTypeDto = new NodeTypeDto();
//            nodeTypeDto.id = nodeType.getId();
//            nodeTypeDto.shortName = nodeType.getShortName();
//            nodeTypeDto.longName = nodeType.getLongName();
//            nodeTypeDto.description = nodeType.getDescription();
            result.add(nodeTypeDtoServiceConverter.toDto(nodeType));
//            result.add(nodeTypeDto);
        }
        return result;
    }

    @Override
    public NodeTypeDtoCommon getById(Long id) {
//        NodeType nodeType = nodeTypes.getById(id);
//        NodeTypeDto nodeTypeDto = new NodeTypeDto();
//        nodeTypeDto.id = nodeType.getId();
//        nodeTypeDto.shortName = nodeType.getShortName();
//        nodeTypeDto.longName = nodeType.getLongName();
//        nodeTypeDto.description = nodeType.getDescription();
        return nodeTypeDtoServiceConverter.toDto(nodeTypes.getById(id));
//        return nodeTypeDto;
    }

    @Override
    public NodeTypeDtoCommon add(NodeTypeDtoCommon item) {
        // TODO Auto-generated method stub
        return null;
    }
}

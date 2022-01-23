package vasyuk.maksim.copper_net.service.nodes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dto.node.NodeDtoCommon;
import vasyuk.maksim.copper_net.service.NodesService;
import vasyuk.maksim.copper_net.service.node_types.NodeTypes;
import vasyuk.maksim.copper_net.service.nodes.Nodes;
import vasyuk.maksim.copper_net.service.nodes.dto.NodeDto;
import vasyuk.maksim.copper_net.service.nodes.model.Node;

@Service
public class NodesServiceImpl implements NodesService {
    @Autowired
    private Nodes nodes;
    @Autowired
    NodeTypes nodeTypes;

    @Override
    public List<NodeDtoCommon> getChildren(Long id) {
        List<NodeDtoCommon> result = new ArrayList<>();
        for (Node childNode : nodes.getById(id).getChildren()) {
            result.add(getById(childNode.getId()));
        }
        return result;
    }

    @Override
    public NodeDtoCommon getById(Long id) {
//        Node node = nodes.getById(id);
//        NodeDto nodeDto = new NodeDto();
//        nodeDto.id = node.getId();
//        nodeDto.shortName = node.getShortName();
//        nodeDto.longName = node.getLongName();
//        nodeDto.typeId = node.getType().getId();
//        nodeDto.description = node.getDescription();
//        if (node.getParent() != null) {
//            nodeDto.parentId = node.getParent().getId();
//        }
//        return nodeDto;
        return null;
    }

    @Override
    public NodeDtoCommon getRoot() {
        Node rootNode = nodes.getRoot();
//        NodeDto rootNodeDto = new NodeDto();
//        rootNodeDto.id = rootNode.getId();
//        rootNodeDto.shortName = rootNode.getShortName();
//        rootNodeDto.longName = rootNode.getLongName();
//        rootNodeDto.typeId = rootNode.getType().getId();
//        rootNodeDto.description = rootNode.getDescription();
//        return rootNodeDto;
        return null;
    }

    @Override
    public NodeDtoCommon add(NodeDtoCommon nodeDto) throws Exception {
        Node newNode = nodes.createNode();
//        newNode.setId(nodeDto.id);
//        newNode.setShortName(nodeDto.shortName);
//        newNode.setLongName(nodeDto.longName);
//        newNode.setDescription(nodeDto.description);
//        newNode.setParent(nodes.getById(nodeDto.parentId));
//        newNode.setType(nodeTypes.getById(nodeDto.typeId));
        nodes.add(newNode);
        return null;
    }

    @Override
    public List<NodeDtoCommon> getAll() {
        // TODO Auto-generated method stub
        return null;
    }
    
//    public void add_(vasyuk.maksim.copper_net.common.dto.NodeDto.Controller.Request.ForAdd dto) {
//       
//        
//    }
}
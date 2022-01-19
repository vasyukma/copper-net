package vasyuk.maksim.copper_net.service.nodes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dto.service.NodeDto;
import vasyuk.maksim.copper_net.service.nodes.node.Node;
import vasyuk.maksim.copper_net.service.nodes.node.Nodes;
import vasyuk.maksim.copper_net.service.nodes.types.NodeTypes;

@Service
public class NodesServiceImpl implements NodesService {
    @Autowired
    private Nodes nodes;
    @Autowired
    NodeTypes nodeTypes;

    @Override
    public List<NodeDto> getChildren(Long id) {
        List<NodeDto> result = new ArrayList<>();
        for (Node childNode : nodes.getById(id).getChildren()) {
            result.add(getById(childNode.getId()));
        }
        return result;
    }

    @Override
    public NodeDto getById(Long id) {
        Node node = nodes.getById(id);
        NodeDto nodeDto = new NodeDto();
        nodeDto.id = node.getId();
        nodeDto.shortName = node.getShortName();
        nodeDto.longName = node.getLongName();
        nodeDto.typeId = node.getType().getId();
        nodeDto.description = node.getDescription();
        if (node.getParent() != null) {
            nodeDto.parentId = node.getParent().getId();
        }
        return nodeDto;
    }

    @Override
    public NodeDto getRoot() {
        Node rootNode = nodes.getRoot();
        NodeDto rootNodeDto = new NodeDto();
        rootNodeDto.id = rootNode.getId();
        rootNodeDto.shortName = rootNode.getShortName();
        rootNodeDto.longName = rootNode.getLongName();
        rootNodeDto.typeId = rootNode.getType().getId();
        rootNodeDto.description = rootNode.getDescription();
        return rootNodeDto;
    }

    @Override
    public void add(NodeDto nodeDto) throws Exception {
        Node newNode = nodes.createNode();
        newNode.setId(nodeDto.id);
        newNode.setShortName(nodeDto.shortName);
        newNode.setLongName(nodeDto.longName);
        newNode.setDescription(nodeDto.description);
        newNode.setParent(nodes.getById(nodeDto.parentId));
        newNode.setType(nodeTypes.getById(nodeDto.typeId));
        nodes.add(newNode);
    }
}
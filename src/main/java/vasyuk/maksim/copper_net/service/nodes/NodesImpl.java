package vasyuk.maksim.copper_net.service.nodes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Getter;
import vasyuk.maksim.copper_net.dao.NodesDao;
import vasyuk.maksim.copper_net.dao.nodes.dto.NodeDto;
import vasyuk.maksim.copper_net.service.common.dto.DtoConverter;
import vasyuk.maksim.copper_net.service.node_types.NodeTypes;
import vasyuk.maksim.copper_net.service.nodes.factory.NodeFactory;
import vasyuk.maksim.copper_net.service.nodes.model.Node;

@Service
public class NodesImpl implements Nodes {
    private Map<Long, Node> nodes;
    @Getter
    private Node root;
    private NodesDao nodesDao;
    private NodeTypes nodeTypes;
    @Resource(name = "&node")
    private NodeFactory nodeFactory;
    private DtoConverter<Node, NodeDto> nodeDtoConverter;
//    private DtoConverter<NodeType, NodeTypeDto> nodeTypeDtoConverter;

    @Autowired
    public NodesImpl(NodesDao nodesDao, NodeTypes nodeTypes, NodeFactory nodeFactory,
            DtoConverter<Node, NodeDto> nodeDtoConverter) throws Exception {
        this.nodesDao = nodesDao;
        this.nodeTypes = nodeTypes;
        this.nodeFactory = nodeFactory;
        this.nodes = new TreeMap<>();
        this.nodeDtoConverter = nodeDtoConverter;
        initialNodes();
        initialTree();
    }

    private void initialNodes() throws Exception {
        Map<Long, Long> children = new HashMap<>();
        for (NodeDto dto : nodesDao.getAll()) {
//            Node node = nodeFactory.getObject();
//            node.setId(nodeDto.id);
//            node.setShortName(nodeDto.shortName);
//            node.setLongName(nodeDto.longName);
//            node.setType(nodeTypes.getById(nodeDto.typeId));
//            node.setDescription(nodeDto.description);
            Node model = nodeDtoConverter.toModel(dto, nodeFactory.getObject());
            children.put(dto.id, dto.parentId);
            nodes.put(model.getId(), model);
        }
        initialParentForNodes(children);
    }

    private void initialTree() {
        for (Map.Entry<Long, Node> entry : nodes.entrySet()) {
            if (entry.getValue().getParent() == null) {
                root = entry.getValue();
            } else {
                entry.getValue().getParent().addChild(entry.getValue());
            }
        }
    }

    private void initialParentForNodes(Map<Long, Long> children) {
        for (Map.Entry<Long, Long> child : children.entrySet()) {
            if (child.getValue() != null) {
                Node childNode = nodes.get(child.getKey());
                Node parentNode = nodes.get(child.getValue());
                childNode.setParent(parentNode);
            }
        }
    }

    @Override
    public Node getById(Long id) {
        Node node = nodes.get(id);
        return node;
    }

    @Override
    public List<Node> getChildren(Node node) {
        return node.getChildren();
    }

    @Override
    public void add(Node node) {
//        NodeDto nodeDto = new NodeDto();
//        nodeDto.shortName = node.getShortName();
//        nodeDto.longName = node.getLongName();
//        nodeDto.parentId = node.getParent().getId();
//        nodeDto.typeId = node.getType().getId();
//        nodeDto.description = node.getDescription();
        node.setId(nodesDao.save(nodeDtoConverter.toDto(node, new NodeDto())).id);
        nodes.put(node.getId(), node);
        nodes.get(node.getParent().getId()).addChild(node);
    }

    @Override
    public Node createNode() throws Exception {
        return nodeFactory.getObject();
    }
}

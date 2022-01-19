package vasyuk.maksim.copper_net.service.nodes.node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Getter;
import vasyuk.maksim.copper_net.dao.NodesDao;
import vasyuk.maksim.copper_net.dto.dao.NodeDto;
import vasyuk.maksim.copper_net.service.nodes.types.NodeTypes;

@Service
public class NodesImpl implements Nodes {
    private Map<Long, Node> nodes;
    @Getter
    private Node root;
    private NodesDao nodesDao;
    private NodeTypes nodeTypes;
    @Resource(name = "&node")
    private NodeFactory nodeFactory;

    @Autowired
    public NodesImpl(NodesDao nodesDao, NodeTypes nodeTypes, NodeFactory nodeFactory) throws Exception {
        this.nodesDao = nodesDao;
        this.nodeTypes = nodeTypes;
        this.nodeFactory = nodeFactory;
        this.nodes = new TreeMap<>();
        initialNodes();
        initialTree();
    }

    private void initialNodes() throws Exception {
        Map<Long, Long> children = new HashMap<>();
        for (NodeDto nodeDto : nodesDao.getAll()) {
            Node node = nodeFactory.getObject();
            node.setId(nodeDto.id);
            node.setShortName(nodeDto.shortName);
            node.setLongName(nodeDto.longName);
            node.setType(nodeTypes.getById(nodeDto.typeId));
            node.setDescription(nodeDto.description);
            children.put(nodeDto.id, nodeDto.parentId);
            nodes.put(node.getId(), node);
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
        NodeDto nodeDto = new NodeDto();
        nodeDto.shortName = node.getShortName();
        nodeDto.longName = node.getLongName();
        nodeDto.parentId = node.getParent().getId();
        nodeDto.typeId = node.getType().getId();
        nodeDto.description = node.getDescription();
        nodesDao.save(nodeDto);
        nodes.get(node.getParent().getId()).addChild(node);
    }

    @Override
    public Node createNode() throws Exception {
        return nodeFactory.getObject();
    }
}

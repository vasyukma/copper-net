package vasyuk.maksim.copper_net.service.nodes.node;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dao.NodesDao;
import vasyuk.maksim.copper_net.dto.dao.NodeDto;
import vasyuk.maksim.copper_net.service.nodes.node.types.NodeTypes;
import vasyuk.maksim.copper_net.service.nodes.tree.NodesTree;

@Service
public class NodesImpl implements Nodes {
    private Map<Long, Node> nodes;
    private NodesTree nodesTree;
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
        this.nodesTree = null;
        initialNodes();
    }

    public void updateAllNodes() {
    }

    @Override
    public Nodes getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    private void initialNodes() throws Exception {
        Map<Long, Long> children = new HashMap<>();
        for (NodeDto nodeDto : nodesDao.getAll()) {
            Node node = nodeFactory.getObject();
            node.setId(nodeDto.id);
            node.setShortName(nodeDto.shortName);
            node.setLongName(nodeDto.longName);
            node.setType(nodeTypes.getById(nodeDto.typeId));
            children.put(nodeDto.id, nodeDto.parentId);
            nodes.put(node.getId(), node);
        }
        initialParentForNodes(children);
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
        // TODO Auto-generated method stub
        return null;
    }
}

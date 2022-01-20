package vasyuk.maksim.copper_net.service.node_types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dao.NodesDao;
import vasyuk.maksim.copper_net.dto.dao.NodeTypeDto;
import vasyuk.maksim.copper_net.service.node_types.node_type.NodeType;
import vasyuk.maksim.copper_net.service.node_types.node_type.NodeTypeFactory;
import vasyuk.maksim.copper_net.service.node_types.node_type.NodeTypes;
import vasyuk.maksim.copper_net.service.nodes.node.Node;

@Service
public class NodeTypesImpl implements NodeTypes {
    private Map<Long, NodeType> nodeTypes;
    private NodesDao nodesDao;
    @Resource(name = "&nodeType")
    private NodeTypeFactory nodeTypeFactory;

    @Autowired
    public NodeTypesImpl(NodesDao nodesDao, NodeTypeFactory nodeTypeFactory) throws Exception {
        this.nodeTypeFactory = nodeTypeFactory;
        this.nodesDao = nodesDao;
        this.nodeTypes = new HashMap<>();
        initNodeTypes();
    }

    private void initNodeTypes() throws Exception {
        for (NodeTypeDto nodeTypeDto : nodesDao.getTypes()) {
            NodeType nodeType = nodeTypeFactory.getObject();
            nodeType.setId(nodeTypeDto.id);
            nodeType.setShortName(nodeTypeDto.shortName);
            nodeType.setLongName(nodeTypeDto.longName);
            nodeType.setDescription(nodeTypeDto.description);
            nodeTypes.put(nodeType.getId(), nodeType);
        }
    }

    @Override
    public NodeType getById(Long id) {
        return nodeTypes.get(id);
    }

    @Override
    public List<NodeType> getAll() {
        List<NodeType> result = new ArrayList<>();
        for (Map.Entry<Long, NodeType> nodeType : nodeTypes.entrySet()) {
            result.add(nodeType.getValue());
        }
        return result;
    }
}

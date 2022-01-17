package vasyuk.maksim.copper_net.service.nodes.node.types;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dao.NodesDao;
import vasyuk.maksim.copper_net.dto.dao.NodeTypeDto;

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

    @Override
    public void refresh() {
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
}

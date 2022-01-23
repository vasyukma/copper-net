package vasyuk.maksim.copper_net.service.node_types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dao.NodeTypesDao;
import vasyuk.maksim.copper_net.dto.node_type.NodeTypeDtoCommon;
import vasyuk.maksim.copper_net.service.node_types.factory.NodeTypeFactory;
import vasyuk.maksim.copper_net.service.node_types.model.NodeType;

@Service
public class NodeTypesImpl implements NodeTypes {
    private Map<Long, NodeType> nodeTypes;
    private NodeTypesDao nodeTypesDao;
    @Resource(name = "&nodeType")
    private NodeTypeFactory nodeTypeFactory;

    @Autowired
    public NodeTypesImpl(NodeTypesDao nodeTypesDao, NodeTypeFactory nodeTypeFactory) throws Exception {
        this.nodeTypeFactory = nodeTypeFactory;
        this.nodeTypesDao = nodeTypesDao;
        this.nodeTypes = new HashMap<>();
        initNodeTypes();
    }

    private void initNodeTypes() throws Exception {
        for (NodeTypeDtoCommon dto : nodeTypesDao.findAll()) {
//            NodeType nodeType = nodeTypeFactory.getObject();
//            nodeType.setId(nodeTypeDto.id);
//            nodeType.setShortName(nodeTypeDto.shortName);
//            nodeType.setLongName(nodeTypeDto.longName);
//            nodeType.setDescription(nodeTypeDto.description);
//            NodeTypeDtoCommon dto = new NodeTypeDto.Common.Create(null, null, null, null)
            NodeType model = nodeTypeFactory.getObject();
            model.setId(dto.getId());
            model.setShortName(dto.getShortName());
            model.setLongName(dto.getLongName());
            model.setDescription(dto.getDescription());
//          NodeTypeDtoCommon dto = new NodeTypeDto.Common.Create(null, null, null, null)
            nodeTypes.put(model.getId(), model);
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

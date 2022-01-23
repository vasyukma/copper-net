package vasyuk.maksim.copper_net.service.node_types;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dto.node_type.NodeTypeDtoCommon;
import vasyuk.maksim.copper_net.repository.NodeTypesRepository;
import vasyuk.maksim.copper_net.repository.model.NodeType;
import vasyuk.maksim.copper_net.service.NodeTypesService;

@Service
class NodeTypesServiceImpl implements NodeTypesService {
    private NodeTypesRepository repository;
    private NodeTypeDtoServiceConverter nodeTypeDtoServiceConverter;

    @Autowired
    public NodeTypesServiceImpl(NodeTypesRepository repository,
            NodeTypeDtoServiceConverter nodeTypeDtoServiceConverter) {
        this.nodeTypeDtoServiceConverter = nodeTypeDtoServiceConverter;
        this.repository = repository;
    }

    @Override
    public List<NodeTypeDtoCommon> getAll() {
        List<NodeTypeDtoCommon> result = new ArrayList<>();
        for (NodeType nodeType : repository.findAll()) {
            result.add(nodeTypeDtoServiceConverter.toDto(nodeType));
        }
        return result;
    }

    @Override
    public NodeTypeDtoCommon getById(Long id) {
        return nodeTypeDtoServiceConverter.toDto(repository.getById(id));
    }

    @Override
    public NodeTypeDtoCommon add(NodeTypeDtoCommon item) {
        // TODO Auto-generated method stub
        return null;
    }
}

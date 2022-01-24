package vasyuk.maksim.copper_net.service.node_types;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dto.node_type.NodeTypeDto;
import vasyuk.maksim.copper_net.dto.node_type.NodeTypeMapper;
import vasyuk.maksim.copper_net.repository.NodeTypesRepository;
import vasyuk.maksim.copper_net.repository.model.NodeType;
import vasyuk.maksim.copper_net.service.NodeTypesService;

@Service
class NodeTypesServiceImpl implements NodeTypesService {
    private NodeTypesRepository repository;
    private NodeTypeMapper mapper;

    @Autowired
    public NodeTypesServiceImpl(NodeTypesRepository repository, NodeTypeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<NodeTypeDto> getAll() {
        List<NodeTypeDto> result = new ArrayList<>();
        for (NodeType model : repository.findAll()) {
            result.add(mapper.map(model));
        }
        return result;
    }

    @Override
    public NodeTypeDto get(Long id) {
        return mapper.map(repository.getById(id));
    }

    @Override
    public NodeTypeDto post(NodeTypeDto dto) {
        return mapper.map(repository.save(mapper.map(dto)));
    }

    @Override
    public NodeTypeDto put(NodeTypeDto dto) {
        NodeType model = repository.getById(dto.getId());
        model.setShortName(dto.getShortName());
        model.setLongName(dto.getLongName());
        model.setDescription(dto.getDescription());
        return mapper.map(repository.save(model));
    }
}

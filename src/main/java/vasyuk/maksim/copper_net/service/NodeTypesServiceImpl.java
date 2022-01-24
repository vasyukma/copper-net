package vasyuk.maksim.copper_net.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dto.NodeTypeDto;
import vasyuk.maksim.copper_net.mapper.NodeTypeMapper;
import vasyuk.maksim.copper_net.model.NodeType;
import vasyuk.maksim.copper_net.repository.NodeTypesRepository;

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
        return mapper.map(repository.findAll());
    }

    @Override
    public NodeTypeDto getById(Long id) {
        return mapper.map(repository.getById(id));
    }

    @Override
    public NodeTypeDto create(NodeTypeDto dto) {
        return mapper.map(repository.save(mapper.map(dto)));
    }

    @Override
    public NodeTypeDto update(NodeTypeDto dto) {
        NodeType model = repository.getById(dto.getId());
        mapper.updateModel(dto, model);
        model = repository.save(model);
        return mapper.map(model);
    }
}

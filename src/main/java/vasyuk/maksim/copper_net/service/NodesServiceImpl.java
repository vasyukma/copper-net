package vasyuk.maksim.copper_net.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dto.NodeDto;
import vasyuk.maksim.copper_net.mapper.NodeMapper;
import vasyuk.maksim.copper_net.model.Node;
import vasyuk.maksim.copper_net.repository.NodesRepository;

@Service
class NodesServiceImpl implements NodesService {
    private NodesRepository repository;
    private NodeMapper mapper;

    @Autowired
    private NodesServiceImpl(NodesRepository nodesRepository, 
            NodeMapper mapper) {
        super();
        this.repository = nodesRepository;
        this.mapper = mapper;
    }

    @Override
    public List<NodeDto> getChildren(Long parentId) {
        return mapper.map(repository.findByParentId(parentId));
    }

    @Override
    public NodeDto getById(Long id) {
        return mapper.map(repository.getById(id));
    }

    @Override
    public NodeDto getRoot() {
        return mapper.map(repository.getRoot());
    }

    @Override
    public NodeDto create(NodeDto dto) {
        return mapper.map(repository.save(mapper.map(dto)));
    }

    @Override
    public List<NodeDto> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public NodeDto update(NodeDto dto) {
        Node model = repository.getById(dto.getId());
        mapper.updateModel(dto, model);
        return mapper.map(repository.save(model));
    }
}
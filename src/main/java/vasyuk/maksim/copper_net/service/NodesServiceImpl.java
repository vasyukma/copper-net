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
    private NodesRepository nodesRepository;
    private NodeMapper mapper;

    @Autowired
    private NodesServiceImpl(NodesRepository nodesRepository, 
            NodeMapper mapper) {
        super();
        this.nodesRepository = nodesRepository;
        this.mapper = mapper;
    }

    @Override
    public List<NodeDto> getChildren(Long parentId) {
        return mapper.map(nodesRepository.findByParentId(parentId));
    }

    @Override
    public NodeDto getById(Long id) {
        return mapper.map(nodesRepository.getById(id));
    }

    @Override
    public NodeDto getRoot() {
        return mapper.map(nodesRepository.getRoot());
    }

    @Override
    public NodeDto create(NodeDto dto) {
        return mapper.map(nodesRepository.save(mapper.map(dto)));
    }

    @Override
    public List<NodeDto> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public NodeDto update(NodeDto dto) {
        Node model = nodesRepository.getById(dto.getId());
        mapper.updateModel(dto, model);
        return mapper.map(nodesRepository.save(model));
    }
}
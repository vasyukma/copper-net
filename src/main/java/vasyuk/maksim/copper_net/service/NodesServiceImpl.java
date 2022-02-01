package vasyuk.maksim.copper_net.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dto.ForUpdateNodeDto;
import vasyuk.maksim.copper_net.dto.NodeDto;
import vasyuk.maksim.copper_net.mapper.ForUpdateNodeMapper;
import vasyuk.maksim.copper_net.mapper.NodeMapper;
import vasyuk.maksim.copper_net.model.Node;
import vasyuk.maksim.copper_net.repository.NodesRepository;

@Service
class NodesServiceImpl implements NodesService {
    private NodesRepository repository;
    private NodeMapper nodeMapper;
    private ForUpdateNodeMapper forUpdateNodeMapper;

    @Autowired
    public NodesServiceImpl(NodesRepository repository, NodeMapper nodeMapper, ForUpdateNodeMapper nodeWithTypeMapper) {
        super();
        this.repository = repository;
        this.nodeMapper = nodeMapper;
        this.forUpdateNodeMapper = nodeWithTypeMapper;
    }

    @Override
    public List<NodeDto> getChildren(Long parentId) {
        List<Node> list = repository.findByParentId(parentId);
        return forUpdateNodeMapper.map(list);
    }

    @Override
    public NodeDto getById(Long id) {
        return nodeMapper.map(repository.getById(id));
    }

    @Override
    public NodeDto getRoot() {
        Node model = repository.getRoot();
        NodeDto dto = nodeMapper.map(model);
        return dto;
    }

    @Override
    public NodeDto create(ForUpdateNodeDto dto) {
        return nodeMapper.map(repository.save(forUpdateNodeMapper.map(dto)));
    }

    @Override
    public List<NodeDto> getAll() {
        return null;
    }

    @Override
    public NodeDto update(ForUpdateNodeDto dto) {
        Node model = repository.getById(dto.getId());
        forUpdateNodeMapper.updateModel(dto, model);
        return nodeMapper.map(repository.save(model));
    }

    @Override
    public Long getParentsCount(Long nodeId) {
        Integer count = 0;
        Long rootId = repository.getRoot().getId();
        Node currentNode = repository.getById(nodeId);
        while (rootId != currentNode.getId()) {
            count++;
            currentNode = repository.getById(currentNode.getParent().getId());
        }
        return count.longValue();
    }
}
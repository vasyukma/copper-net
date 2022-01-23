package vasyuk.maksim.copper_net.service.nodes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dto.node.NodeDto;
import vasyuk.maksim.copper_net.dto.node.NodeDtoRoot;
import vasyuk.maksim.copper_net.repository.NodesRepository;
import vasyuk.maksim.copper_net.repository.model.Node;
import vasyuk.maksim.copper_net.service.NodesService;

@Service
class NodesServiceImpl implements NodesService {
    private NodesRepository repository;
    private CommonDtoConverter commonDtoConverter;
    private RootDtoConverter rootDtoConverter;

    @Autowired
    private NodesServiceImpl(NodesRepository repository, CommonDtoConverter dtoConverter,
            RootDtoConverter rootDtoConverter) {
        super();
        this.repository = repository;
        this.commonDtoConverter = dtoConverter;
        this.rootDtoConverter = rootDtoConverter;
    }

    @Override
    public List<NodeDto> getChildren(Long parentId) {
        List<NodeDto> result = new ArrayList<>();
        for (Node model : repository.findByParentId(parentId)) {
            result.add(commonDtoConverter.toDto(model));
        }
        return result;
    }

    @Override
    public NodeDto get(Long id) {
        return commonDtoConverter.toDto(repository.getById(id));
    }

    @Override
    public NodeDtoRoot getRoot() {
        return rootDtoConverter.toDto(repository.getRoot());
    }

    @Override
    public NodeDto post(NodeDto nodeDto) {
        return null;
    }

    @Override
    public List<NodeDto> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public NodeDto put(NodeDto dto) {
        // TODO Auto-generated method stub
        return null;
    }
}
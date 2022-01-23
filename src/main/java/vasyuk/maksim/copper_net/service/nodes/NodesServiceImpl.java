package vasyuk.maksim.copper_net.service.nodes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dto.node.NodeDtoCommon;
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
    public List<NodeDtoCommon> getChildren(Long parentId) {
        List<NodeDtoCommon> result = new ArrayList<>();
        for (Node model : repository.findByParentId(parentId)) {
            result.add(commonDtoConverter.toDto(model));
        }
        return result;
    }

    @Override
    public NodeDtoCommon getById(Long id) {
        return commonDtoConverter.toDto(repository.getById(id));
    }

    @Override
    public NodeDtoRoot getRoot() {
        return rootDtoConverter.toDto(repository.getRoot());
    }

    @Override
    public NodeDtoCommon add(NodeDtoCommon nodeDto) throws Exception {
        return null;
    }

    @Override
    public List<NodeDtoCommon> getAll() {
        // TODO Auto-generated method stub
        return null;
    }
}
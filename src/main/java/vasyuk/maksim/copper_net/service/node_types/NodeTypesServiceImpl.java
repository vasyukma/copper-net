package vasyuk.maksim.copper_net.service.node_types;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dto.node_type.NodeTypeDtoDep;
import vasyuk.maksim.copper_net.dto.node_type.NodeTypeMapper;
import vasyuk.maksim.copper_net.repository.NodeTypesRepository;
import vasyuk.maksim.copper_net.repository.model.NodeType;
import vasyuk.maksim.copper_net.service.NodeTypesService;

@Service
class NodeTypesServiceImpl implements NodeTypesService {
    private NodeTypesRepository repository;
    private NodeTypeDtoConverterImpl dtoConverter;
    
    @Autowired
    private NodeTypeMapper mapper;

    @Autowired
    public NodeTypesServiceImpl(NodeTypesRepository repository, NodeTypeDtoConverterImpl nodeTypeDtoServiceConverter) {
        this.dtoConverter = nodeTypeDtoServiceConverter;
        this.repository = repository;
    }

    @Override
    public List<NodeTypeDtoDep> getAll() {
        List<NodeTypeDtoDep> result = new ArrayList<>();
        for (NodeType nodeType : repository.findAll()) {
            result.add(dtoConverter.toDto(nodeType));
        }
        return result;
    }

    @Override
    public NodeTypeDtoDep get(Long id) {
        return dtoConverter.toDto(repository.getById(id));
    }

    @Override
    public NodeTypeDtoDep post(NodeTypeDtoDep dto) {
        return dtoConverter.toDto(repository.save(dtoConverter.toModel(dto)));
    }
//    @Override
//    public NodeTypeDtoCommon add(NodeTypeDtoCommon dto) {
//        return dtoConverter.toDto(repository.save(dtoConverter.toModel(dto)));
//    }

    @Override
    public NodeTypeDtoDep put(NodeTypeDtoDep dto) {
        // TODO Auto-generated method stub
        NodeType model = repository.getById(dto.getId());
        model.setShortName(dto.getShortName());
        model.setLongName(dto.getLongName());
        model.setDescription(dto.getDescription());
//        repository.save(model);
        return dtoConverter.toDto(repository.save(model));
    }
}

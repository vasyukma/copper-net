package vasyuk.maksim.copper_net.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dao.model.Node;
import vasyuk.maksim.copper_net.dao.repository.NodeRepository;
import vasyuk.maksim.copper_net.dao.repository.NodeTypeRepository;
import vasyuk.maksim.copper_net.dto.dao.NodeDto;
import vasyuk.maksim.copper_net.dto.dao.NodeTypeDto;

@Service
public class NodesDaoImpl implements NodesDao {
    @Autowired
    private NodeRepository nodeRepository;
    @Autowired
    private NodeTypeRepository nodeTypeRepository;

    @Override
    public List<NodeDto> getAll() {
        List<NodeDto> result = new ArrayList<>();
        for (Node node : nodeRepository.findAll()) {
            NodeDto nodeDto = new NodeDto();
            nodeDto.id = node.getId();
            nodeDto.shortName = node.getShortName();
            nodeDto.longName = node.getLongName();
            nodeDto.description = node.getDescription();
            nodeDto.typeId = node.getType().getId();
            if (node.getParent() != null) {
                nodeDto.parentId = node.getParent().getId();
            }
            result.add(nodeDto);
        }
        return result;
    }

    @Override
    public List<NodeTypeDto> getTypes() {
        List<NodeTypeDto> result = new ArrayList<>();
        nodeTypeRepository.findAll().stream().forEach(nodeType -> {
            NodeTypeDto nodeTypeDto = new NodeTypeDto();
            nodeTypeDto.id = nodeType.getId();
            nodeTypeDto.shortName = nodeType.getShortName();
            nodeTypeDto.description = nodeType.getDescription();
            result.add(nodeTypeDto);
        });
        return result;
    }

    @Override
    public NodeDto getById(Long id) {
        Node node = nodeRepository.getById(id);
        NodeDto nodeDto = new NodeDto();
        nodeDto.id = node.getId();
        nodeDto.shortName = node.getShortName();
        nodeDto.longName = node.getLongName();
        nodeDto.description = node.getDescription();
        return nodeDto;
    }
}

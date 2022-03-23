package vasyuk.maksim.copper_net.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.dto.CableListItemDto;
import vasyuk.maksim.copper_net.mapper.LinkMapper;
import vasyuk.maksim.copper_net.model.Link;
import vasyuk.maksim.copper_net.model.Node;
import vasyuk.maksim.copper_net.model.NodeType;
import vasyuk.maksim.copper_net.model.Tail;
import vasyuk.maksim.copper_net.repository.LinksRepository;
import vasyuk.maksim.copper_net.repository.NodeTypesRepository;
import vasyuk.maksim.copper_net.repository.TailsRepository;
import vasyuk.maksim.copper_net.service.storage_location_utils.StorageLocationUtils;

@Service
public class CableListServiceImpl implements CableListService {
    private LinksRepository linksRepository;
    private LinkMapper linkMapper;
    private TailsRepository tailsRepository;
    private NodeTypesRepository nodeTypesRepository;
    private StorageLocationUtils storageLocationUtils;

    @Autowired
    public CableListServiceImpl(LinksRepository linksRepository, LinkMapper linkMapper, TailsRepository tailsRepository,
            NodeTypesRepository nodeTypesRepository, StorageLocationUtils storageLocationUtils) {
        super();
        this.linksRepository = linksRepository;
        this.linkMapper = linkMapper;
        this.tailsRepository = tailsRepository;
        this.nodeTypesRepository = nodeTypesRepository;
        this.storageLocationUtils = storageLocationUtils;
    }

    @Override
    public List<CableListItemDto> getCableList() {
        NodeType rmNodeType = nodeTypesRepository.getById(5L);
//        NodeType tcNodeType = nodeTypesRepository.getById(6L);
        NodeType ppNodeType = nodeTypesRepository.getById(9L);
        List<NodeType> nodeTypesToFind = new ArrayList<>();
        nodeTypesToFind.add(rmNodeType);
//        nodeTypesToFind.add(tcNodeType);
        nodeTypesToFind.add(ppNodeType);
        List<Link> allLinks = linksRepository.findAll(Sort.by("name"));
        List<CableListItemDto> result = new ArrayList<>();
        for (Link link : allLinks) {
            Node room = null;
            Node socket = null;
            Node telecommunicationsCloset = null;
            Node patchPanel = null;
            Node port = null;
            for (Tail tail : tailsRepository.findByLinkId(link.getId())) {
                Node tailStorageLocation = tail.getNode();
                Node firstFindedParentStorageLocation = storageLocationUtils.findFirstParentByType(tailStorageLocation,
                        nodeTypesToFind);
                if (firstFindedParentStorageLocation.getType().equals(rmNodeType)) {
                    room = firstFindedParentStorageLocation;
                    socket = tailStorageLocation;
                }
//                if (firstFindedParentStorageLocation.getType().equals(tcNodeType)) {
                if (firstFindedParentStorageLocation.getType().equals(ppNodeType)) {
                    patchPanel = firstFindedParentStorageLocation;
                    telecommunicationsCloset = patchPanel.getParent();
                    port = tailStorageLocation;
                }
            }
            if ((room != null) && (patchPanel != null)) {
                result.add(new CableListItemDto(linkMapper.map(link), room.getShortName(), socket.getShortName(),
                        telecommunicationsCloset.getShortName(), patchPanel.getShortName(), port.getShortName()));
            }
        }
        return result;
    }
}

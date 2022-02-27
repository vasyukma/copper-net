package vasyuk.maksim.copper_net.service.storage_location_utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.model.Node;
import vasyuk.maksim.copper_net.model.NodeType;
import vasyuk.maksim.copper_net.repository.NodesRepository;

@Service
public class StorageLocationUtilsImpl implements StorageLocationUtils {
    private NodesRepository repository;

    @Autowired
    public StorageLocationUtilsImpl(NodesRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public Node findFirstParentByType(Node storageLocation, List<NodeType> typesToFind) {
//        for (Node storageLocation : storageLocationsPath) {
        for (Node currentStorageLocation : getPath(storageLocation)) {
            if (typesToFind.contains(currentStorageLocation.getType())) {
                return currentStorageLocation;
            }
        }
        return repository.getRoot();
    }

    @Override
    public List<Node> getPath(Node storageLocation) {
//        Deque<Node> modelDeque = new ArrayDeque<>();
        List<Node> result = new ArrayList<>();
        Long rootStorageLocationId = repository.getRoot().getId();
        Node currentStorageLocation = repository.getById(storageLocation.getId());
//        modelDeque.add(currentNode);
        result.add(currentStorageLocation);
        while (rootStorageLocationId != currentStorageLocation.getId()) {
            currentStorageLocation = repository.getById(currentStorageLocation.getParent().getId());
//            modelDeque.add(currentNode);
            result.add(currentStorageLocation);
        }
//        List<Node> result = new ArrayList<>(modelDeque);
//        return modelDeque;
        return result;
    }
}

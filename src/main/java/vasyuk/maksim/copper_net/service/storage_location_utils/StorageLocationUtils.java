package vasyuk.maksim.copper_net.service.storage_location_utils;

import java.util.List;

import vasyuk.maksim.copper_net.model.Node;
import vasyuk.maksim.copper_net.model.NodeType;

public interface StorageLocationUtils {
    Node findFirstParentByType(Node currentStorageLocation, List<NodeType> typesToFind);

    List<Node> getPath(Node storageLocation);
}

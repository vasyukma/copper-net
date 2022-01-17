package vasyuk.maksim.copper_net.service.nodes.node;

import vasyuk.maksim.copper_net.service.nodes.tree.NodesTree;

public interface Nodes {
    Nodes getAll();
//    StorageLocations getBranchStorageLocations(StorageLocation);

    NodesTree getTree();
}

package vasyuk.maksim.copper_net.service.nodes.tree;

import java.util.Map;

import vasyuk.maksim.copper_net.service.nodes.node.Node;

public interface Branch {
    void setNode(Node node);

    Node getNode();
    
    Map<Long, Branch> getBranches();
}

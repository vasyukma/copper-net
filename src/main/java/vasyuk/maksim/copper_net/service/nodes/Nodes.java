package vasyuk.maksim.copper_net.service.nodes;

import java.util.List;

import vasyuk.maksim.copper_net.service.nodes.model.Node;

public interface Nodes {
    Node getById(Long id);

    Node getRoot();

    List<Node> getChildren(Node node);

    void add(Node node);

    Node createNode() throws Exception;
}

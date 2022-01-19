package vasyuk.maksim.copper_net.service.nodes.node;

import java.util.List;

public interface Nodes {
    Node getById(Long id);

    Node getRoot();

    List<Node> getChildren(Node node);

    void add(Node node);

    Node createNode() throws Exception;
}

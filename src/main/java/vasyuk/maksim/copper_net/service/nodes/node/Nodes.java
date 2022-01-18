package vasyuk.maksim.copper_net.service.nodes.node;

import java.util.List;

public interface Nodes {
    List<Node> getAll();

    Node getById(Long id);
}

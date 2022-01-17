package vasyuk.maksim.copper_net.service.nodes.node;

import vasyuk.maksim.copper_net.service.nodes.node.types.NodeType;

public interface Node {
    void setId(Long id);

    Long getId();

    void setShortName(String shortName);

    String getShortName();
    
    void setLongName(String longName);
    
    String getLongName();

    void setType(NodeType nodeType);

    NodeType getType();

    void setParent(Node parent);

    Node getParent();
}

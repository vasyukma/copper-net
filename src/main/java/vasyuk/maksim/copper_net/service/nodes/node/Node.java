package vasyuk.maksim.copper_net.service.nodes.node;

import java.util.List;

import vasyuk.maksim.copper_net.service.node_types.node_type.NodeType;

public interface Node {
    void setId(Long id);

    Long getId();

    void setShortName(String shortName);

    String getShortName();

    void setLongName(String longName);

    String getLongName();
    
    void setDescription(String description);
    
    String getDescription();

    void setType(NodeType nodeType);

    NodeType getType();

    void setParent(Node parent);

    Node getParent();

    List<Node> getChildren();

    void addChild(Node node);
}

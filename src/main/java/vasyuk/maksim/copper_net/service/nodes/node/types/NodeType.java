package vasyuk.maksim.copper_net.service.nodes.node.types;

public interface NodeType {
    void setId(Long id);

    Long getId();

    void setShortName(String name);

    String getShortName();

    void setLongName(String longName);

    String getLongName();

    void setDescription(String description);

    String getDescription();
}

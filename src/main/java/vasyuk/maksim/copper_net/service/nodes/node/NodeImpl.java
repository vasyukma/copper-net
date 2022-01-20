package vasyuk.maksim.copper_net.service.nodes.node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import lombok.Data;
import vasyuk.maksim.copper_net.service.node_types.node_type.NodeType;

@Data
public class NodeImpl implements Node {
    private Long id;
    private String shortName;
    private String longName;
    private String description;
    private Node parent;
    private NodeType type;
    private Map<Long, Node> children;

    public NodeImpl() {
        this.children = new TreeMap<>();
    }

    @Override
    public List<Node> getChildren() {
        List<Node> result = new ArrayList<>();
        for (Map.Entry<Long, Node> child : children.entrySet()) {
            result.add(child.getValue());
        }
        return result;
    }

    @Override
    public void addChild(Node node) {
        children.put(node.getId(), node);
        new String();
    }
}

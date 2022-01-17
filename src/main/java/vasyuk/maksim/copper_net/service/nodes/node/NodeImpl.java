package vasyuk.maksim.copper_net.service.nodes.node;

import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.NoArgsConstructor;
import vasyuk.maksim.copper_net.service.nodes.node.types.NodeType;


@Service
@NoArgsConstructor
@Data
public class NodeImpl implements Node {
    private Long id;
    private String shortName;
    private String longName;
    private Node parent;
    private NodeType type;
}

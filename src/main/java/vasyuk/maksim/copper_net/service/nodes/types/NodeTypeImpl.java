package vasyuk.maksim.copper_net.service.nodes.types;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NodeTypeImpl implements NodeType {
    private Long id;
    private String shortName;
    private String longName;
    private String description;
}

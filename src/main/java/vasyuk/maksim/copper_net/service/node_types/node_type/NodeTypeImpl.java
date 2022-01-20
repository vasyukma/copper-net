package vasyuk.maksim.copper_net.service.node_types.node_type;

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

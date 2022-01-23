package vasyuk.maksim.copper_net.dto.node_type;

import lombok.Value;

@Value
public class NodeTypeDto implements NodeTypeDtoDep {
    Long id;
    String shortName;
    String longName;
    String description;
}

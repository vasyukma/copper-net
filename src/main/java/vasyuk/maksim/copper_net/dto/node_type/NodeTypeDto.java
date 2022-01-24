package vasyuk.maksim.copper_net.dto.node_type;

import lombok.Value;

@Value
public class NodeTypeDto implements NodeTypeDtoDep {
    private Long id;
    private String shortName;
    private String longName;
    private String description;
}

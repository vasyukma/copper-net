package vasyuk.maksim.copper_net.dto;

import lombok.Value;

@Value
public class NodeDto {
    private Long id;
    private String shortName;
    private String longName;
    private String description;
    private NodeTypeDto type;
    private Long parentId;
}
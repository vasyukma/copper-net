package vasyuk.maksim.copper_net.dto;

import lombok.Value;

@Value
public class TailDto {
    private Long id;
    private Long nodeId;
    private NodeDto node;
    private Long linkId;
    private LinkDto link;
    private String description;
    private String path;
}

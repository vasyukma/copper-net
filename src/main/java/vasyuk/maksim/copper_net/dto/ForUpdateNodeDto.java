package vasyuk.maksim.copper_net.dto;

import lombok.Value;

@Value
public class ForUpdateNodeDto {
    private Long id;
    private String shortName;
    private String longName;
    private String description;
    private Long typeId;
    private Long parentId;
}
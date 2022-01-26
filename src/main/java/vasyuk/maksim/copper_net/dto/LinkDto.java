package vasyuk.maksim.copper_net.dto;

import lombok.Value;

@Value
public class LinkDto {
    private Long id;
    private String shortName;
    private String longName;
    private String description;
}

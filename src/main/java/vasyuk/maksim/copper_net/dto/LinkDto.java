package vasyuk.maksim.copper_net.dto;

import lombok.Value;

@Value
public class LinkDto {
    private Long id;
    private String name;
    private String cableBrand;
    private Integer cabinetLength;
    private Integer metalStructursLength;
    private Integer cableChannelLength;
    private Integer reserveLength;
    private Integer parts;
    private Integer length;
    private String description;
}

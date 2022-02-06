package vasyuk.maksim.copper_net.dto;

import lombok.Value;

@Value
public class RoomCableListItemDto {
    private Long id;
    private String roomNumber;
    private String name;
    private String shortName;
    private String longName;
    private String cableBrand;
    private Integer cabinetLength;
    private Integer metalStructursLength;
    private Integer cabelChannelLength;
    private Integer reservLength;
    private Integer parts;
    private Integer Length;
    private String description;
}

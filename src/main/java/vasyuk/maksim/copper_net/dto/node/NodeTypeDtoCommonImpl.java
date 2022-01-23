package vasyuk.maksim.copper_net.dto.node;

import lombok.Value;

@Value
public class NodeTypeDtoCommonImpl implements NodeDto {
    Long id;
    String shortName;
    String longName;
    String description;
    Long typeId;
    Long parentId;
}

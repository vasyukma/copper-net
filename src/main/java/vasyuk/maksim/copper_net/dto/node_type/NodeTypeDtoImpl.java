package vasyuk.maksim.copper_net.dto.node_type;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Value;

@Value
public class NodeTypeDtoImpl implements NodeTypeDtoDep {
    Long id;
    String shortName;
    String longName;
    String description;
}

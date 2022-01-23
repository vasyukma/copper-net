package vasyuk.maksim.copper_net.dto.node_type;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = NodeTypeDtoImpl.class)
public interface NodeTypeDtoDep extends Id, ShortName, LongName, Description {
}

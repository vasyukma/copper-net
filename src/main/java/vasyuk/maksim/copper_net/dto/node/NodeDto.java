package vasyuk.maksim.copper_net.dto.node;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = NodeDtoEnum.Common.New.class)
public interface NodeDto extends Id, ShortName, LongName, Description, TypeId, ParentId {
}

package vasyuk.maksim.copper_net.mapper;

import org.mapstruct.Mapper;

import vasyuk.maksim.copper_net.dto.TextNodePathDto;

@Mapper
public interface TextNodePathMapper {
    TextNodePathDto map(String textNodePath);
}

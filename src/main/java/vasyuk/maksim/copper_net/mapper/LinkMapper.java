package vasyuk.maksim.copper_net.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import vasyuk.maksim.copper_net.dto.LinkDto;
import vasyuk.maksim.copper_net.model.Link;

@Mapper
public interface LinkMapper {
    Link map(LinkDto dto);

    LinkDto map(Link entity);

    List<LinkDto> map(List<Link> models);

    void updateModel(LinkDto dto, @MappingTarget Link model);

}

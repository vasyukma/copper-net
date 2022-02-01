package vasyuk.maksim.copper_net.service;

import java.util.List;

import vasyuk.maksim.copper_net.dto.LinkDto;
import vasyuk.maksim.copper_net.dto.TailDto;

public interface LinksService extends Service<LinkDto, LinkDto> {
    List<TailDto> getChildren(Long linkId);
}

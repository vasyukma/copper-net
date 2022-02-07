package vasyuk.maksim.copper_net.service;

import java.util.List;

import vasyuk.maksim.copper_net.dto.TailDto;

public interface TailsService extends Service<TailDto, TailDto> {

    List<TailDto> getTailsByNodeId(Long nodeId);
}

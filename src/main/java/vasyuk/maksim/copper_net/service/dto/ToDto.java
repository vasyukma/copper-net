package vasyuk.maksim.copper_net.service.dto;

public interface ToDto<SERVICE, DTO> {
    DTO convert(SERVICE item, DTO dto);
}

package vasyuk.maksim.copper_net.service.common.dto;

public interface DtoConvert<MODEL, DTO> {
    DTO toDto(MODEL model, DTO dto);
    MODEL toModel(DTO dto, MODEL model);
}

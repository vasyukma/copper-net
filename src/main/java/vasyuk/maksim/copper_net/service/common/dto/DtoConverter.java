package vasyuk.maksim.copper_net.service.common.dto;

public interface DtoConverter<MODEL, DTO> {
    DTO toDto(MODEL model, DTO dto);
    MODEL toModel(DTO dto, MODEL model);
}

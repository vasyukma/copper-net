package vasyuk.maksim.copper_net.dto;

public interface DtoConverter<MODEL, DTO> {
    DTO toDto(MODEL model);

    MODEL toModel(DTO dto);
}

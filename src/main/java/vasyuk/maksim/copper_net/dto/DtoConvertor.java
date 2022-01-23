package vasyuk.maksim.copper_net.dto;

public interface DtoConvertor<MODEL, DTO> {
    DTO toDto(MODEL model);

    MODEL toModel(DTO dto);
}

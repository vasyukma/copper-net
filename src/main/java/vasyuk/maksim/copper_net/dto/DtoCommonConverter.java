package vasyuk.maksim.copper_net.dto;

public interface DtoCommonConverter<MODEL, DTO_COMMON> {
    DTO_COMMON toDto(MODEL model);

    MODEL toModel(DTO_COMMON dto);
}

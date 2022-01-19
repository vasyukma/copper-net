package vasyuk.maksim.copper_net.dto.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NodeTypeDto {
    private Long id;
    private String shortName;
    private String description;
}

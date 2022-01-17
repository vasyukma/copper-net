package vasyuk.maksim.copper_net.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NodeDto {
    private Long id;
    private String name;
    private NodeDto parent;
    private NodeTypeDto type;
    private String description;
}

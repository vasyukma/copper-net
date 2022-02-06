package vasyuk.maksim.copper_net.dto;

import java.util.List;

import lombok.Value;
import vasyuk.maksim.copper_net.model.Node;

@Value
public class NodePathDto {
    private String text;
    private List<NodeDto> nodes;
}

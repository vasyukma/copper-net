package vasyuk.maksim.copper_net.dao.node_types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NodeTypeSuper<T implements > {
    private NodeTypesRepository nodeTypesRepository;
}

package vasyuk.maksim.copper_net.service.nodes.tree;

import java.util.Map;
import java.util.TreeMap;

import lombok.Getter;
import lombok.Setter;
import vasyuk.maksim.copper_net.service.nodes.node.Node;

public class BranchImpl implements Branch {
    @Getter
    @Setter
    private Node node;
    @Getter
    private Map<Long, Branch> branches;

    public BranchImpl() {
        this.branches = new TreeMap<>();
    }
}

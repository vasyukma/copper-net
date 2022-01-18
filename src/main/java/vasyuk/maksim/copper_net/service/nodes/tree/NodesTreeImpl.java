package vasyuk.maksim.copper_net.service.nodes.tree;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;
import vasyuk.maksim.copper_net.service.nodes.node.Node;
import vasyuk.maksim.copper_net.service.nodes.node.Nodes;

@Service
public class NodesTreeImpl implements NodesTree {

    private Map<Long, Node> nodesTree;
    private Nodes nodes;

    @Autowired
    public NodesTreeImpl(Nodes nodes) {
        nodesTree = new TreeMap<>();
        this.nodes = nodes;
        initialTree();
    }

    @Override
    public NodesTree getNodesTree() {
        // TODO Auto-generated method stub
        return null;
    }

    private void initialTree() {
        
//        Map<Long, Map<Long, Map>>
        
    }
    
    private void generateBranch(Node node) {
        if (node.getParent() == null) {
//            return node;
        }
    }

    
    class Branch {
        private Map<Long, Node> childrenNodes;
//        private 
    }
}

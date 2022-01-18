package vasyuk.maksim.copper_net.service.nodes.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.service.nodes.node.Node;
import vasyuk.maksim.copper_net.service.nodes.node.Nodes;

@Service
public class NodesTreeImpl implements NodesTree {
    private Map<Long, Branch> nodesTree;
    private Nodes nodes;
    @Resource(name = "&branch")
    private BranchFactory branchFactory;

    @Autowired
    public NodesTreeImpl(Nodes nodes, BranchFactory branchFactory) throws Exception {
        nodesTree = new TreeMap<>();
        this.nodes = nodes;
        this.branchFactory = branchFactory;
        initialTree();
    }

    @Override
    public NodesTree getNodesTree() {
        // TODO Auto-generated method stub
        return null;
    }

    private void initialTree() throws Exception {
        Map<Long, Node> tmp = new HashMap<>();
        for (Node node : nodes.getAll()) {
//            tmp.put(node.getId(), node);
//            Queue<Long> path = new LinkedList<>();
            recurse(node);
            
            
        }
        
        while (tmp.size() != 0) {
//            Node currentNode = tmp.remove(tmp)
        }
//        for(Node node : nodes.getAll()) {
//            
//        }
    }

    private void recurse(Node node) throws Exception  {
        
        if (node.getParent() == null) {
            if (nodesTree.containsKey(node.getId())) {
                return;
            } else {
                Branch newBranch = branchFactory.getObject();
                newBranch.setNode(node);
                nodesTree.put(node.getId(), newBranch);
                return;
            }
        } else {
            
        }
        
        if (node.getParent() == null) {
            return;
        } else {
//            path.add(null)
//            recurse(path, node);
        }
    }

    private void generateBranch(Node node) {
        if (node.getParent() == null) {
//            return node;
        }
    }
}

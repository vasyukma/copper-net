package vasyuk.maksim.copper_net.service.nodes.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.service.nodes.node.Node;
import vasyuk.maksim.copper_net.service.nodes.node.Nodes;

@Service
public class NodesTreeImpl implements Tree {
    private Map<Long, Branch> tree;
    private Nodes nodes;
    @Resource(name = "&branch")
    private BranchFactory branchFactory;

    @Autowired
    public NodesTreeImpl(Nodes nodes, BranchFactory branchFactory) throws Exception {
        tree = new TreeMap<>();
        this.nodes = nodes;
        this.branchFactory = branchFactory;
        initialTree();
    }

    @Override
    public Tree getTree() {
        // TODO Auto-generated method stub
        return null;
    }

    private void initialTree() throws Exception {
        Map<Long, Node> tmp = new HashMap<>();
        for (Node node : nodes.getAll()) {
//            tmp.put(node.getId(), node);
//            Queue<Long> path = new LinkedList<>();
            Stack<Node> pathToRoot = new Stack<>();

//            Branch newBranch = branchFactory.getObject();
//            newBranch.setNode(node);

            generatePathToRoot(pathToRoot, node);
            
            Branch currentBranch = getNewBranch(nodes.getById(pathToRoot.pop().getId()));
            Branch prevBranch;
            
            if (tree.containsKey(currentBranch.getNode().getId())) {
                prevBranch = currentBranch;
            } else {
                tree.put(currentBranch.getNode().getId(), currentBranch);
                prevBranch = currentBranch;
            }
            
                
            Branch parentBranch;
            while (pathToRoot.size() != 0) {
                Node currentNode = pathToRoot.pop();
                parentBranch = currentBranch;
                if (parentBranch.getBranches().containsKey(currentNode.getId())) {
                    continue;
                } else {
                currentBranch = getNewBranch(currentNode);
                parentBranch.getBranches().put(currentBranch.getNode().getId(), currentBranch);
                
                }
            }

//            recurse(node, pathToRoot);

        }

    }

    private void generatePathToRoot(Stack<Node> pathToRoot, Node node) {
        if (node.getParent() == null) {
            pathToRoot.push(node);
            return;
        } else {
            pathToRoot.push(node);
            generatePathToRoot(pathToRoot, node.getParent());
        }
    }

    private Branch getNewBranch(Node node) throws Exception {
        Branch newBranch = branchFactory.getObject();
        newBranch.setNode(node);
        return newBranch;
    }
}

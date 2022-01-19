package vasyuk.maksim.copper_net.service.nodes.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasyuk.maksim.copper_net.service.nodes.node.Node;
import vasyuk.maksim.copper_net.service.nodes.node.Nodes;

@Service
public class TreeImpl implements Tree {
    private Nodes nodes;
    private Node root;

    
    public TreeImpl(Nodes nodes) {
        this.nodes = nodes;
        initialTree();
    }

    @Override
    public List<Node> getTree(Node node) {
        List<Node> result = new ArrayList<>();
        for (Node currentNode : nodes.getById(node.getId()).getChildren()) {
            result.add(currentNode);
        }
        return result;
    }

    private void initialTree() {
//        for (Node node : nodes.getAll()) {
//            if (node.getParent() == null) {
//                root = node;
//            } else {
//                node.getParent().addChild(node);
//            }
//        }
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
}

package vasyuk.maksim.copper_net.service.nodes.factory;

import org.springframework.beans.factory.FactoryBean;

import vasyuk.maksim.copper_net.service.nodes.model.Node;
import vasyuk.maksim.copper_net.service.nodes.model.NodeImpl;

public class NodeFactory implements FactoryBean<Node> {
    @Override
    public Node getObject() throws Exception {
        return new NodeImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return Node.class;
    }
}

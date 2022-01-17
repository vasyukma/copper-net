package vasyuk.maksim.copper_net.service.nodes.node;

import org.springframework.beans.factory.FactoryBean;

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

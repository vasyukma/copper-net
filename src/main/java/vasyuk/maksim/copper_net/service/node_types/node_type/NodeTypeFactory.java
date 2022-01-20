package vasyuk.maksim.copper_net.service.node_types.node_type;

import org.springframework.beans.factory.FactoryBean;

public class NodeTypeFactory implements FactoryBean<NodeType> {

    @Override
    public NodeType getObject() throws Exception {
        return new NodeTypeImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return NodeType.class;
    }
}
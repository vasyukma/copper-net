package vasyuk.maksim.copper_net.service.node_types.factory;

import org.springframework.beans.factory.FactoryBean;

import vasyuk.maksim.copper_net.service.node_types.model.NodeType;
import vasyuk.maksim.copper_net.service.node_types.model.NodeTypeImpl;

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

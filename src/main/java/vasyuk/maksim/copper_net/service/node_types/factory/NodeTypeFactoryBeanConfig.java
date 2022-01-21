package vasyuk.maksim.copper_net.service.node_types.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import vasyuk.maksim.copper_net.service.node_types.model.NodeType;

@Configuration
public class NodeTypeFactoryBeanConfig {
    @Bean(name = "nodeType")
    public NodeTypeFactory nodeTypeFactory() {
        NodeTypeFactory nodeTypeFactory = new NodeTypeFactory();
        return nodeTypeFactory;
    }

    @Bean
    public NodeType nodeType() throws Exception {
        return nodeTypeFactory().getObject();
    }
}

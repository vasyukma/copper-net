package vasyuk.maksim.copper_net.service.nodes.node.types;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

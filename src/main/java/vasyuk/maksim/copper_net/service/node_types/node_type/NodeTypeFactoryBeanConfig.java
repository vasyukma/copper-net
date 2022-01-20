package vasyuk.maksim.copper_net.service.node_types.node_type;

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

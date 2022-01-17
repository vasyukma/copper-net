package vasyuk.maksim.copper_net.service.nodes.node;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NodeFactoryBeanConfig {
    @Bean(name = "node")
    public NodeFactory nodeFactory() {
        NodeFactory nodeFactory = new NodeFactory();
        return nodeFactory;
    }

    @Bean
    public Node node() throws Exception {
        return nodeFactory().getObject();
    }
}

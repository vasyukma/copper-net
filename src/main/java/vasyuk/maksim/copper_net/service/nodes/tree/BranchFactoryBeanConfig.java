package vasyuk.maksim.copper_net.service.nodes.tree;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BranchFactoryBeanConfig {
    @Bean(name = "branch")
    public BranchFactory branchFactory() {
        BranchFactory factory = new BranchFactory();
        return factory;
    }

    @Bean
    public Branch branch() throws Exception {
        return branchFactory().getObject();
    }
}

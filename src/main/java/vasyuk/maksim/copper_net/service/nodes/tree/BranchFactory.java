package vasyuk.maksim.copper_net.service.nodes.tree;

import org.springframework.beans.factory.FactoryBean;

public class BranchFactory implements FactoryBean<Branch> {

    @Override
    public Branch getObject() throws Exception {
        return new BranchImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return Branch.class;
    }
    
}

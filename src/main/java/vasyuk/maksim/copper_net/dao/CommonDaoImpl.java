package vasyuk.maksim.copper_net.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lombok.AllArgsConstructor;
import vasyuk.maksim.copper_net.dao.node_types.NodeTypeSuper;
import vasyuk.maksim.copper_net.dao.node_types.NodeTypesRepository;
import vasyuk.maksim.copper_net.dto.node_type.NodeTypeDtoCommon;

public class CommonDaoImpl<REPOSITORY extends NodeTypeSuper> {
    private REPOSITORY repository;
    
    public CommonDaoImpl(REPOSITORY repository) {
        this.repository = repository;
    }
    
    public NodeTypeDtoCommon findById(Long id) {
        return convertToDtoCommon(repository.getById(id));
    }
}

package vasyuk.maksim.copper_net.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vasyuk.maksim.copper_net.model.Node;

public interface NodesRepository extends JpaRepository<Node, Long> {
    List<Node> findByParentId(Long parentId);
    
    @Query(value = "from Node where parent_id = id")
    Node getRoot();
    
}

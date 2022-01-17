package vasyuk.maksim.copper_net.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vasyuk.maksim.copper_net.dao.model.Node;

public interface NodeRepository extends JpaRepository<Node, Long> {
}

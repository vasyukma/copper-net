package vasyuk.maksim.copper_net.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vasyuk.maksim.copper_net.repository.model.NodeType;

public interface NodeTypesRepository extends JpaRepository<NodeType, Long> {
}

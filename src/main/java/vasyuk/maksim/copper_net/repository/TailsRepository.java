package vasyuk.maksim.copper_net.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vasyuk.maksim.copper_net.model.Tail;

public interface TailsRepository extends JpaRepository<Tail, Long> {
    List<Tail> findByLinkId(Long linkId);
}

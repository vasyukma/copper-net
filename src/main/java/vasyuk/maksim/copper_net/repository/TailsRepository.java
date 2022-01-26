package vasyuk.maksim.copper_net.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vasyuk.maksim.copper_net.model.Tail;

public interface TailsRepository extends JpaRepository<Tail, Long> {
}

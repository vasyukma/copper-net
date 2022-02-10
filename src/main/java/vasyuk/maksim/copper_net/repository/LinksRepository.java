package vasyuk.maksim.copper_net.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vasyuk.maksim.copper_net.model.Link;

public interface LinksRepository extends JpaRepository<Link, Long> {
    List<Link> findByOrderByNameAsc();
    List<Link> findByNameLikeOrderByNameAsc(String filter);
}

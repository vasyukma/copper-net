package vasyuk.maksim.copper_net.service;

import java.util.List;

import vasyuk.maksim.copper_net.model.Link;
import vasyuk.maksim.copper_net.repository.LinksRepository;
import vasyuk.maksim.copper_net.repository.TailsRepository;

public class CableListImpl implements CableList {
    
    private LinksRepository linksRepository;
    private TailsRepository teailsRepository;
    
    void getCableList() {
        List<Link> allLinks = linksRepository.findAll();
        for (Link link : allLinks) {
            
        }
    }
}

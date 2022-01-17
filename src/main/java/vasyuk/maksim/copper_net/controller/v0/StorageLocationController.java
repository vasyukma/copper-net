package vasyuk.maksim.copper_net.controller.v0;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vasyuk.maksim.copper_net.dao.model.Node;
import vasyuk.maksim.copper_net.dao.repository.NodeRepository;

@RestController
public class StorageLocationController {
    
    @Autowired
    NodeRepository storageLocationRepository;
    
    @GetMapping("storage_location")
    public ResponseEntity<List<Node>> getStorageLocation() {
        
        
//        List<StorageLocation> list = storageLocationRepository.findAll();
        return new ResponseEntity<>(storageLocationRepository.findAll(), HttpStatus.OK);
    }
}

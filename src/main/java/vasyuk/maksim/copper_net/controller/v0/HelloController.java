package vasyuk.maksim.copper_net.controller.v0;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vasyuk.maksim.copper_net.service.nodes.node.types.NodeTypes;

@RestController
public class HelloController {
//    
//    @Autowired
//    private NodesDao nodesDao;
    @Autowired
    private NodeTypes nodeTypes; 
    
    @GetMapping("/")
    public ResponseEntity<String> sayHello() {
//        TestDto testDto = new TestDto();
//        testDto.setTest(principal.getName());
//        testDto.setPhrase("New phrase");
        
//        List<NodeType> list = storageLocationTypeRepository.findAll();
        
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }
}


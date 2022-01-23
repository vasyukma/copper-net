package vasyuk.maksim.copper_net.controller.v0;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vasyuk.maksim.copper_net.dto.node.NodeDtoCommon;
import vasyuk.maksim.copper_net.service.NodesService;

@RestController
@RequestMapping("nodes")
public class NodesController {
    @Autowired
    private NodesService nodesService;
    
    @GetMapping("root")
    public ResponseEntity<NodeDtoCommon> getRootNode() {
        return new ResponseEntity<>(nodesService.getRoot(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<NodeDtoCommon> getNode(@PathVariable Long id) {
        return new ResponseEntity<>(nodesService.getById(id), HttpStatus.OK);
    }

    @GetMapping("{id}/children")
    public ResponseEntity<List<NodeDtoCommon>> getChildren(@PathVariable Long id) {
        return new ResponseEntity<>(nodesService.getChildren(id), HttpStatus.OK);
    }
    
    @PostMapping
    public @ResponseBody ResponseEntity<String> post(@RequestBody NodeDtoCommon nodeDto) throws Exception {
        nodesService.add(nodeDto);
        return new ResponseEntity<String>("POST Response", HttpStatus.OK);
    }
}

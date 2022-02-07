package vasyuk.maksim.copper_net.controller.v0;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vasyuk.maksim.copper_net.dto.ForUpdateNodeDto;
import vasyuk.maksim.copper_net.dto.NodeDto;
import vasyuk.maksim.copper_net.dto.NodePathDto;
import vasyuk.maksim.copper_net.dto.TailDto;
import vasyuk.maksim.copper_net.service.NodesService;
import vasyuk.maksim.copper_net.service.TailsService;

@RestController
@RequestMapping("api/v0/nodes")
public class NodesController {
    private NodesService nodesService;
    private TailsService tailsService;

    @Autowired
    public NodesController(NodesService nodesService, TailsService tailsService) {
        super();
        this.nodesService = nodesService;
        this.tailsService = tailsService;
    }

    @GetMapping("root")
    public ResponseEntity<NodeDto> getRootNode() {
        return new ResponseEntity<>(nodesService.getRoot(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<NodeDto> getNode(@PathVariable Long id) {
        return new ResponseEntity<>(nodesService.getById(id), HttpStatus.OK);
    }

    @GetMapping("{id}/children")
    public ResponseEntity<List<NodeDto>> getChildren(@PathVariable Long id) {
        return new ResponseEntity<>(nodesService.getChildren(id), HttpStatus.OK);
    }

    @GetMapping("{id}/tails")
    public ResponseEntity<List<TailDto>> getTails(@PathVariable Long id) {
        return new ResponseEntity<>(tailsService.getTailsByNodeId(id), HttpStatus.OK);
    }

    @GetMapping("{id}/path")
    public ResponseEntity<NodePathDto> getNodePath(@PathVariable Long id) {
        return new ResponseEntity<>(nodesService.getPath(id), HttpStatus.OK);
    }

//    @GetMapping("{id}/text-path")
//    public ResponseEntity<TextNodePathDto> getTextNodePath(@PathVariable Long id) {
//        return new ResponseEntity<>(service.getTextPath(id), HttpStatus.OK);
//    }
//    
    @GetMapping("{id}/parents-count")
    public ResponseEntity<Long> getParentsCount(@PathVariable Long id) {
        return new ResponseEntity<>(nodesService.getParentsCount(id), HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody ResponseEntity<NodeDto> post(@RequestBody ForUpdateNodeDto dto) throws Exception {
        return new ResponseEntity<>(nodesService.create(dto), HttpStatus.OK);
    }

    @PutMapping
    public @ResponseBody ResponseEntity<NodeDto> put(@RequestBody ForUpdateNodeDto dto) throws Exception {
        return new ResponseEntity<>(nodesService.update(dto), HttpStatus.OK);
    }
}

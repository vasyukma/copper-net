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

import vasyuk.maksim.copper_net.dto.NodeDto;
import vasyuk.maksim.copper_net.service.NodesService;

@RestController
@RequestMapping("api/v0/nodes")
public class NodesController {
    private NodesService nodesService;

    @Autowired
    protected NodesController(NodesService nodesService) {
        super();
        this.nodesService = nodesService;
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

    @PostMapping
    public @ResponseBody ResponseEntity<NodeDto> post(@RequestBody NodeDto dto) throws Exception {
        return new ResponseEntity<>(nodesService.create(dto), HttpStatus.OK);
    }

    @PutMapping
    public @ResponseBody ResponseEntity<NodeDto> put(@RequestBody NodeDto dto) throws Exception {
        return new ResponseEntity<>(nodesService.update(dto), HttpStatus.OK);
    }
}

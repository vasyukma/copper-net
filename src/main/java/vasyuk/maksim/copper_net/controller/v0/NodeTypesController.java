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

import vasyuk.maksim.copper_net.dto.node_type.NodeTypeDtoDep;
import vasyuk.maksim.copper_net.service.NodeTypesService;

@RestController
@RequestMapping("api/v0/node-types")
public class NodeTypesController {
    private NodeTypesService service;

    @Autowired
    public NodeTypesController(NodeTypesService nodeTypesService) {
        this.service = nodeTypesService;
    }

    @GetMapping
    private ResponseEntity<List<NodeTypeDtoDep>> getAll() {
        return new ResponseEntity<List<NodeTypeDtoDep>>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public @ResponseBody ResponseEntity<String> get(@PathVariable Long id) {
        return new ResponseEntity<String>(String.join(id.toString(), " get"), HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody ResponseEntity<NodeTypeDtoDep> post(@RequestBody NodeTypeDtoDep dto) {
        return new ResponseEntity<NodeTypeDtoDep>(service.post(dto), HttpStatus.OK);
    }

    @PutMapping
    public @ResponseBody ResponseEntity<NodeTypeDtoDep> put(@RequestBody NodeTypeDtoDep dto) {
        return new ResponseEntity<NodeTypeDtoDep>(service.put(dto), HttpStatus.OK);
    }
}

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

import vasyuk.maksim.copper_net.dto.NodeTypeDto;
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
    private ResponseEntity<List<NodeTypeDto>> getAll() {
        return new ResponseEntity<List<NodeTypeDto>>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public @ResponseBody ResponseEntity<NodeTypeDto> get(@PathVariable Long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody ResponseEntity<NodeTypeDto> post(@RequestBody NodeTypeDto dto) {
        return new ResponseEntity<NodeTypeDto>(service.create(dto), HttpStatus.OK);
    }

    @PutMapping
    public @ResponseBody ResponseEntity<NodeTypeDto> put(@RequestBody NodeTypeDto dto) {
        return new ResponseEntity<NodeTypeDto>(service.update(dto), HttpStatus.OK);
    }
}

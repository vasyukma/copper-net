package vasyuk.maksim.copper_net.controller.v0;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import vasyuk.maksim.copper_net.model.NodeType;
import vasyuk.maksim.copper_net.repository.NodeTypesRepository;
import vasyuk.maksim.copper_net.service.NodeTypesService;

@RestController
@RequestMapping("api/v0/node-types")
public class NodeTypesController {
    private NodeTypesService service;
    private NodeTypesRepository repository;

    @Autowired
    public NodeTypesController(NodeTypesService service, NodeTypesRepository repository) {
        super();
        this.service = service;
        this.repository = repository;
    }

    @GetMapping("depricate")
    private ResponseEntity<List<NodeTypeDto>> getAll() {
        return new ResponseEntity<List<NodeTypeDto>>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    private Page<NodeType> findAll(Pageable pageable) {
        return repository.findAll(pageable);
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

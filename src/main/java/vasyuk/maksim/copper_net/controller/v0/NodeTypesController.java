package vasyuk.maksim.copper_net.controller.v0;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vasyuk.maksim.copper_net.dto.service.NodeTypeDto;
import vasyuk.maksim.copper_net.service.NodeTypesService;

@RestController
@RequestMapping("node-types")
public class NodeTypesController {

    private NodeTypesService<NodeTypeDto> nodeTypesService;

    @Autowired
    public NodeTypesController(NodeTypesService<NodeTypeDto> nodeTypesService) {
        super();
        this.nodeTypesService = nodeTypesService;
    }

    @GetMapping
    private ResponseEntity<List<NodeTypeDto>> getAll() {
        return new ResponseEntity<List<NodeTypeDto>>(nodeTypesService.getAll(), HttpStatus.OK);
    }
}

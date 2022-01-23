package vasyuk.maksim.copper_net.controller.v0;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vasyuk.maksim.copper_net.dto.node_type.NodeTypeDtoCommon;
import vasyuk.maksim.copper_net.service.NodeTypesService;

@RestController
@RequestMapping("node-types")
public class NodeTypesController {
    private NodeTypesService nodeTypesService;

    @Autowired
    public NodeTypesController(NodeTypesService nodeTypesService) {
        this.nodeTypesService = nodeTypesService;
    }

    @GetMapping
    private ResponseEntity<List<NodeTypeDtoCommon>> getAll() {
        return new ResponseEntity<List<NodeTypeDtoCommon>>(nodeTypesService.getAll(), HttpStatus.OK);
    }
}

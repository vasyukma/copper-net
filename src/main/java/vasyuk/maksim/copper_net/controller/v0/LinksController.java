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

import vasyuk.maksim.copper_net.dto.LinkDto;
import vasyuk.maksim.copper_net.service.LinksService;

@RestController
@RequestMapping("api/v0/links")
public class LinksController {
    private LinksService service;

    @Autowired
    public LinksController(LinksService service) {
        super();
        this.service = service;
    }
    
    @GetMapping
    private ResponseEntity<List<LinkDto>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public @ResponseBody ResponseEntity<LinkDto> get(@PathVariable Long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody ResponseEntity<LinkDto> post(@RequestBody LinkDto dto) {
        return new ResponseEntity<LinkDto>(service.create(dto), HttpStatus.OK);
    }

    @PutMapping
    public @ResponseBody ResponseEntity<LinkDto> put(@RequestBody LinkDto dto) {
        return new ResponseEntity<LinkDto>(service.update(dto), HttpStatus.OK);
    }

}

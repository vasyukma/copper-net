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

import vasyuk.maksim.copper_net.dto.TailDto;
import vasyuk.maksim.copper_net.service.TailsService;

@RestController
@RequestMapping("api/v0/tails")
public class TailsContoller {

    private TailsService service;

    @Autowired
    public TailsContoller(TailsService service) {
        super();
        this.service = service;
    }

    @GetMapping
    private ResponseEntity<List<TailDto>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public @ResponseBody ResponseEntity<TailDto> get(@PathVariable Long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody ResponseEntity<TailDto> post(@RequestBody TailDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.OK);
    }

    @PutMapping
    public @ResponseBody ResponseEntity<TailDto> put(@RequestBody TailDto dto) {
        return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
    }

}

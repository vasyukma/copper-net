package vasyuk.maksim.copper_net.controller.v0;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vasyuk.maksim.copper_net.model.CrossType;
import vasyuk.maksim.copper_net.repository.CrossTypesRepository;

@RestController
@RequestMapping("api/v0/cross-types")
public class CrossTypesController {
    private CrossTypesRepository repository;

    @Autowired
    public CrossTypesController(CrossTypesRepository repository) {
        super();
        this.repository = repository;
    }

    @GetMapping
    @ResponseBody
    public Page<CrossType> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @PostMapping
    @ResponseBody
    public CrossType post(@Valid @RequestBody CrossType crossType) {
        return repository.save(crossType);
    }
}

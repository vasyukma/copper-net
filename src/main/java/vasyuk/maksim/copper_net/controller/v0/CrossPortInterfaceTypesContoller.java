package vasyuk.maksim.copper_net.controller.v0;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vasyuk.maksim.copper_net.dto.CrossPortInterfaceTypeDto;
import vasyuk.maksim.copper_net.service.CrossPortInterfaceTypesService;

@RestController
@RequestMapping("api/v0/cross-port-interface-types")
public class CrossPortInterfaceTypesContoller {
    private CrossPortInterfaceTypesService service;

    @Autowired
    public CrossPortInterfaceTypesContoller(CrossPortInterfaceTypesService service) {
        super();
        this.service = service;
    }

    @GetMapping
    private Page<CrossPortInterfaceTypeDto> getAll() {
        return service.getAllPage();
    }
}

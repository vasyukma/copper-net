package vasyuk.maksim.copper_net.controller.v0;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vasyuk.maksim.copper_net.dto.CableListItemDto;
import vasyuk.maksim.copper_net.service.CableListService;

@RestController
@RequestMapping("api/v0/cable-list")
public class CableListController {
    private CableListService service;

    @Autowired
    public CableListController(CableListService service) {
        super();
        this.service = service;
    }
    
    @GetMapping
    @ResponseBody
    public List<CableListItemDto> getAll() {
        return service.getCableList(); 
    }
    
}

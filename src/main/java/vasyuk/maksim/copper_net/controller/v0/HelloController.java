package vasyuk.maksim.copper_net.controller.v0;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public ResponseEntity<String> sayHello() {
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }
}

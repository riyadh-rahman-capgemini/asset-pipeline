package to.coin.assetpipeline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import to.coin.assetpipeline.service.UserService;

import java.util.Map;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/users/{username}")
    public ResponseEntity<Map<String, Object>> getByUsernameAndPassword(@PathVariable String username, @RequestBody Map<String, String> auth) {
        return userService.get(username, auth);
    }

    @PostMapping("/api/users")
    public ResponseEntity<Map<String, Object>> createOne(@RequestBody Map<String, Object> customer) {
        return userService.save(customer);
    }
}

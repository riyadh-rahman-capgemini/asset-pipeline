package to.coin.assetpipeline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import to.coin.assetpipeline.model.Filter;
import to.coin.assetpipeline.service.FilterService;

import java.util.List;

@CrossOrigin
@RestController
public class FilterController {

    @Autowired
    private FilterService filterService;

    @GetMapping("/api/filters/{userId}")
    public ResponseEntity<List<Filter>> findAllByUserId(Long userId) {
        return filterService.findAllByUserId(userId);
    }

    @PostMapping("/api/filters")
    public ResponseEntity<Filter> createOne(@RequestBody Filter filter) {
        return filterService.createOne(filter);
    }

    @DeleteMapping("/api/filters/{id}")
    public ResponseEntity<HttpStatus> deleteOne(@PathVariable Long id) {
        return filterService.deleteOne(id);
    }
}

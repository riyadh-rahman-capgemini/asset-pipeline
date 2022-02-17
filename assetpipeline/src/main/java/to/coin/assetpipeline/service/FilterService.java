package to.coin.assetpipeline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import to.coin.assetpipeline.model.Filter;
import to.coin.assetpipeline.repository.FilterRepository;

import java.util.List;

@Service
public class FilterService {

    @Autowired
    private FilterRepository filterRepository;

    public ResponseEntity<List<Filter>> findAllByUserId(Long id) {
        return ResponseEntity.ok(filterRepository.findAllByUserId(id));
    }

    public ResponseEntity<Filter> createOne(Filter filter) {
        return ResponseEntity.ok(filterRepository.saveAndFlush(filter));
    }

    public ResponseEntity<HttpStatus> deleteOne(Long id) {
        filterRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

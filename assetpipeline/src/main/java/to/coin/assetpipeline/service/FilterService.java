package to.coin.assetpipeline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import to.coin.assetpipeline.model.Filter;
import to.coin.assetpipeline.repository.FilterRepository;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;

@Service
public class FilterService {

    @Autowired
    private FilterRepository filterRepository;

    public ResponseEntity<List<Filter>> findAllByUserId(Long id) {
        return ResponseEntity.ok(filterRepository.findAllByUserId(id));
    }

    public ResponseEntity<Filter> createOne(Filter filter) {
        System.out.println(filter);
        try {
            return ResponseEntity.ok(filterRepository.saveAndFlush(filter));
        } catch (ConstraintViolationException e) {
            System.out.println(e);
            return ResponseEntity.badRequest().build();
        }

    }

    public ResponseEntity<HttpStatus> deleteOne(Long id) {
        try {
            filterRepository.deleteById(id);

            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.noContent().build();
        }
    }
}

package to.coin.assetpipeline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import to.coin.assetpipeline.model.Filter;
import to.coin.assetpipeline.model.User;
import to.coin.assetpipeline.repository.FilterRepository;
import to.coin.assetpipeline.repository.UserRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.net.URI;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ResponseEntity<Map<String, Object>> get(String username, Map<String, String> auth) {
        User user = userRepository.findByUsername(username);
        Map<String, Object> response = new HashMap<>();

        if (user == null || !passwordEncoder.matches(auth.getOrDefault("password", ""), user.getPassword())) {
            response.put("messages", "Incorrect username or password");
            return ResponseEntity.status(403).body(response);
        }

        response.put("user", user);

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<Map<String, Object>> save(Map<String, Object> userMap) {
        User user = new User();

        user.setFirstName((String) userMap.getOrDefault("first_name", null));
        user.setLastName((String) userMap.getOrDefault("last_name", null));
        user.setEmail((String) userMap.getOrDefault("email", null));
        user.setUsername((String) userMap.getOrDefault("username", null));

        String password = (String) userMap.getOrDefault("password", null);
        user.setPassword(passwordEncoder.encode(password));
        user.setCreatedAt(Instant.now());

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if (!violations.isEmpty()) {
            Map<String, Object> response = new HashMap<>();
            response.put("messages", Arrays.toString(violations.stream().map(ConstraintViolation::getMessage).toArray()));
            return ResponseEntity.badRequest().body(response);
        }

        System.out.println(userRepository.save(user));

        return ResponseEntity.created(URI.create("")).build();
    }

}

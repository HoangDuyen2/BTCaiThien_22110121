package iot.star.btcaithien_22110121.Controller;

import iot.star.btcaithien_22110121.Entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("")
@EnableMethodSecurity
public class UserController {
    final private List<User> users = List.of(User.builder().userId("001").userName("Nguyễn Văn A").email("nva@gmail.com").build(), User.builder().userId("002").userName("Nguyễn Văn B").email("nvb@gmail.com").build());

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {

        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/user/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = this.users;
        return ResponseEntity.ok(users);
    }

    @GetMapping("/user/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
        List<User> users = this.users.stream().filter(user -> user.getUserId().equals(id)).toList();
        return ResponseEntity.ok(users.get(0));
    }
}

package hr.java.covid_tracker.web;

import hr.java.covid_tracker.login.LoginDTO;
import hr.java.covid_tracker.login.LoginService;
import hr.java.covid_tracker.security.SecurityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

    private final LoginService loginService;

    public UserController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("{korisnikoIme}/{lozinka}")
    public LoginDTO getUser(@PathVariable final String korisnikoIme, @PathVariable final String lozinka){
        return loginService.findUser(korisnikoIme, lozinka)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ne postoji korisnik sa tim podacima")
                );
    }

    @GetMapping("/current-user")
    public ResponseEntity<LoginDTO> getCurrentUser() {
        return SecurityUtils.getCurrentUserUsername()
                .map(
                        username -> loginService.findByKorisnickoIme(username)
                                .map(ResponseEntity::ok)
                                .orElseGet(
                                        () -> ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build()
                                )
                )
                .orElseGet(
                        () -> ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build()
                );
    }


}

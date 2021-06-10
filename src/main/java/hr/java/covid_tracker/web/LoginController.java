package hr.java.covid_tracker.web;

import hr.java.covid_tracker.login.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("login")
@CrossOrigin(origins = "http://localhost:8080")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginServiceImpl loginService) {
        this.loginService = loginService;
    }

    /*
    @GetMapping
    public List<LoginDTO> getAllUsers(){
        return loginService.findAll();
    }*/


    @GetMapping("{korisnikoIme}/{lozinka}")
    public LoginDTO getUser(@PathVariable final String korisnikoIme, @PathVariable final String lozinka){
        return loginService.findUser(korisnikoIme, lozinka)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ne postoji korisnik sa tim podacima")
                );
    }


}

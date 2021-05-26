package hr.java.covid_tracker.controller;

import hr.java.covid_tracker.model.LoginDTO;
import hr.java.covid_tracker.service.LoginService;
import hr.java.covid_tracker.service.LoginServiceImpl;
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

    @GetMapping
    public List<LoginDTO> getAllUsers(){
        return loginService.findAll();
    }

    @GetMapping("{username}")
    public LoginDTO getUserByUsername(@PathVariable final String username){
        return loginService.findByUsername(username)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ne postoji korisnik za taj username")
                );
    }

}

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
    private final LoginJpaRepository loginJpaRepository;

    public LoginController(LoginServiceImpl loginService, LoginJpaRepository loginJpaRepository) {
        this.loginService = loginService;
        this.loginJpaRepository = loginJpaRepository;
    }

    @GetMapping("/ALL")
    public List<LoginDTO> getAllUsersService(){
        return loginService.findAll();
    }

    @GetMapping
    public List<Login> getAllUsers(){
        return loginJpaRepository.findAll();
    }

    @GetMapping("USER:{username}")
    public LoginDTO getUserByUsernameService(@PathVariable final String username){
        return loginService.findByUsername(username)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ne postoji korisnik za taj username")
                );
    }

    @GetMapping("/:{username}")
    public List<Login> getUserByUsername(@PathVariable final String username){
        return loginJpaRepository.findAllByKorisnickoIme(username);
    }

    @GetMapping("/{username},{password}")
    public List<Login> getUserByUsernameAndPassword(@PathVariable final String username, @PathVariable final String password){
        return loginJpaRepository.findByKorisnickoImeAndLozinka(username, password);
    }


}

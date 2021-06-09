package hr.java.covid_tracker.login;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoginServiceImpl implements LoginService{

    private final LoginRepository loginRepository;
    private final LoginJpaRepository loginJpaRepository;

    public LoginServiceImpl(LoginRepository loginRepository, LoginJpaRepository loginJpaRepository) {
        this.loginRepository = loginRepository;
        this.loginJpaRepository = loginJpaRepository;
    }

    @Override
    public List<LoginDTO> findAll() {
        return loginJpaRepository.findAll().stream().map(LoginDTO::new).collect(Collectors.toList());
    }

    @Override
    public Optional<LoginDTO> findUser(String korisnickoIme, String lozinka) {
        return loginJpaRepository.findByKorisnickoImeAndLozinka(korisnickoIme, lozinka).map(LoginDTO::new);
    }


}

package hr.java.covid_tracker.service;

import hr.java.covid_tracker.model.LoginDTO;
import hr.java.covid_tracker.repository.LoginRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoginServiceImpl implements LoginService{

    private final LoginRepository loginRepository;

    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public List<LoginDTO> findAll() {
        return loginRepository.findAll().stream().map(LoginDTO::new).collect(Collectors.toList());
    }

    @Override
    public Optional<LoginDTO> findByUsername(String username) {
        return loginRepository.findByUsername(username).map(LoginDTO::new);
    }


}

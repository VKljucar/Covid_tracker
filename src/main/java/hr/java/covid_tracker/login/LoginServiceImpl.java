package hr.java.covid_tracker.login;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
class LoginServiceImpl implements LoginService{

    private final LoginJpaRepository loginJpaRepository;

    public LoginServiceImpl(LoginJpaRepository loginJpaRepository) {
        this.loginJpaRepository = loginJpaRepository;
    }

    @Override
    public List<Login> findAll() {
        return loginJpaRepository.findAll().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<LoginDTO> findUser(String korisnickoIme, String lozinka) {
        return loginJpaRepository.findByKorisnickoImeAndLozinka(korisnickoIme, lozinka).map(LoginDTO::new);
    }

    @Override
    public Optional<LoginDTO> findByKorisnickoIme(String korisnickoIme) {
        return loginJpaRepository.findByKorisnickoIme(korisnickoIme).map(this::mapUserToDTO);
    }

    private LoginDTO mapUserToDTO(final Login user){
        LoginDTO userDTO = new LoginDTO();

        userDTO.setId(user.getId());
        userDTO.setUsername(user.getKorisnickoIme());
        userDTO.setIme(user.getIme());
        userDTO.setPrezime(user.getPrezime());
        userDTO.setAuthorities(user.getAuthorities().stream().map(Authority::getName).collect(Collectors.toSet()));

        return userDTO;
    }

}

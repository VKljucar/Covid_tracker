package hr.java.covid_tracker.login;

import java.util.List;
import java.util.Optional;

public interface LoginService {

    List<LoginDTO> findAll();

    Optional<LoginDTO> findByUsername(String username);

}

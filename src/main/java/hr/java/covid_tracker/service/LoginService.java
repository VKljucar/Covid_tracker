package hr.java.covid_tracker.service;

import hr.java.covid_tracker.model.LoginDTO;

import java.util.List;
import java.util.Optional;

public interface LoginService {

    List<LoginDTO> findAll();

    Optional<LoginDTO> findByUsername(String username);

}

package hr.java.covid_tracker.repository;

import hr.java.covid_tracker.model.Login;

import java.util.Optional;
import java.util.Set;

public interface LoginRepository {

    Set<Login> findAll();

    Optional<Login> findByUsername(String username);

}

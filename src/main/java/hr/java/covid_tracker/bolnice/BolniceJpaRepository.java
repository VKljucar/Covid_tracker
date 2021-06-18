package hr.java.covid_tracker.bolnice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BolniceJpaRepository extends JpaRepository<Bolnice, Integer> {

    List<Bolnice>  findAll();

}

package hr.java.covid_tracker.cijepljeni;

import java.util.Optional;
import java.util.Set;

public interface CijepljeniRepository {

    Set<Cijepljeni> findAll();

    Optional<Cijepljeni> findByParameters(String ime, String prezime, int cijepivoID);

    Optional<Cijepljeni> save(Cijepljeni cijepljeni);

    Optional<Cijepljeni> update(int id, Cijepljeni updateCijepljeni);

    void deleteById(int id);

}

package hr.java.covid_tracker.novozarazeni;

import java.util.Optional;
import java.util.Set;

public interface NovozarazeniRepository {

    Set<Novozarazeni> findAll();

    Optional<Novozarazeni> findByParameters(String ime, String prezime, String hospitaliziran);

    Optional<Novozarazeni> save(Novozarazeni novozarazeni);

    Optional<Novozarazeni> update(int id, Novozarazeni updateNovozarazeni);

    void deleteById(int id);

}

package hr.java.covid_tracker.novozarazeni;

import java.util.List;
import java.util.Optional;

public interface NovozarazeniService {

    List<NovozarazeniDTO> findAll();

    Optional<NovozarazeniDTO> findByParameters(String ime, String prezime, String hospitaliziran);

    Optional<NovozarazeniDTO> save(NovozarazeniCommand novozarazeniCommand);

}

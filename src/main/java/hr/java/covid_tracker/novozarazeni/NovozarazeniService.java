package hr.java.covid_tracker.novozarazeni;

import java.util.List;
import java.util.Optional;

public interface NovozarazeniService {

    List<NovozarazeniDTO> findAll();

    List<NovozarazeniDTO> findByFilter(String ime, String prezime, String hospitaliziran);

    NovozarazeniDTO save(NovozarazeniCommand novozarazeniCommand);

    void update(int id, NovozarazeniCommand novozarazeniCommand);

    void deleteById(int id);

}

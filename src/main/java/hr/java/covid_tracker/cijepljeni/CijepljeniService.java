package hr.java.covid_tracker.cijepljeni;

import hr.java.covid_tracker.novozarazeni.NovozarazeniCommand;
import hr.java.covid_tracker.novozarazeni.NovozarazeniDTO;

import java.util.List;
import java.util.Optional;

public interface CijepljeniService {

    List<CijepljeniDTO> findAll();

    Optional<CijepljeniDTO> findByParameters(String ime, String prezime, int CijepivoID);

    CijepljeniDTO save(CijepljeniCommand cijepljeniCommand);

    void update(int id, CijepljeniCommand cijepljeniCommand);

    void deleteById(int id);

    Integer countAll();

    Integer findCijepljeniForDay();

    Integer countCijepljeniByDate(String datum);

}

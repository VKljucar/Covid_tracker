package hr.java.covid_tracker.cijepljeni;

import hr.java.covid_tracker.novozarazeni.NovozarazeniDTO;

import java.util.List;
import java.util.Optional;

public interface CijepljeniService {

    List<CijepljeniDTO> findAll();

    Optional<CijepljeniDTO> findByParameters(String ime, String prezime, int CijepivoID);

    Optional<CijepljeniDTO> save(CijepljeniCommand cijepljeniCommand);

    Optional<CijepljeniDTO> update(int id);

    void deleteById(int id);

}

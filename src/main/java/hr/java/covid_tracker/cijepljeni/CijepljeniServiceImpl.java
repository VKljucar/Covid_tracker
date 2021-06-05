package hr.java.covid_tracker.cijepljeni;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CijepljeniServiceImpl implements CijepljeniService {

    private final CijepljeniRepository cijepljeniRepository;

    public CijepljeniServiceImpl(CijepljeniRepository cijepljeniRepository){
        this.cijepljeniRepository = cijepljeniRepository;
    }

    @Override
    public List<CijepljeniDTO> findAll() {
        return cijepljeniRepository.findAll().stream().map(CijepljeniDTO::new).collect(Collectors.toList());
    }



    @Override
    public Optional<CijepljeniDTO> findByParameters(String ime, String prezime, int CijepivoID) {
        return cijepljeniRepository.findByParameters(ime, prezime, CijepivoID).map(CijepljeniDTO::new);
    }

    @Override
    public Optional<CijepljeniDTO> save(CijepljeniCommand cijepljeniCommand) {
        return cijepljeniRepository
                .save(new Cijepljeni(cijepljeniCommand))
                .map(CijepljeniDTO::new);
    }

    @Override
    public Optional<CijepljeniDTO> update(int id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(int id) {

    }
}

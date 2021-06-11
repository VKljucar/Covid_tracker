package hr.java.covid_tracker.cijepljeni;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CijepljeniServiceImpl implements CijepljeniService {

    private final CijepljeniJpaRepository cijepljeniJpaRepository;

    public CijepljeniServiceImpl(CijepljeniJpaRepository cijepljeniJpaRepository){
        this.cijepljeniJpaRepository = cijepljeniJpaRepository;
    }

    @Override
    public List<CijepljeniDTO> findAll() {
        return cijepljeniJpaRepository.findAll().stream().map(CijepljeniDTO::new).collect(Collectors.toList());
    }

    @Override
    public Optional<CijepljeniDTO> findByParameters(String ime, String prezime, int cijepivo_id) {
        return cijepljeniJpaRepository.findAllByParameters(ime, prezime, cijepivo_id).map(CijepljeniDTO::new);
    }

    @Override
    public CijepljeniDTO save(CijepljeniCommand cijepljeniCommand){
        return mapToCijepljeniDTO(cijepljeniJpaRepository.save(mapToCijepljeni(cijepljeniCommand)));
    }

    @Override
    public void update(int id, final CijepljeniCommand cijepljeniCommand) {
        Cijepljeni cijepljeni = cijepljeniJpaRepository.findByCijepivoID(id);
        cijepljeni.updateCijepljeni(cijepljeniCommand);
        cijepljeniJpaRepository.save(cijepljeni);
    }

    @Override
    public void deleteById(int id) {
        cijepljeniJpaRepository.deleteById(id);

    }

    private Cijepljeni mapToCijepljeni(final CijepljeniCommand cijepljeniCommand){
        return new Cijepljeni(cijepljeniCommand);
    }

    private CijepljeniDTO mapToCijepljeniDTO(final Cijepljeni cijepljeni){
        return new CijepljeniDTO(cijepljeni);
    }


}

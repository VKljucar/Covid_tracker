package hr.java.covid_tracker.novozarazeni;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NovozarazeniServiceImpl implements NovozarazeniService{

    private final NovozarazeniJpaRepository novozarazeniJpaRepository;

    public NovozarazeniServiceImpl(NovozarazeniJpaRepository novozarazeniJpaRepository){
        this.novozarazeniJpaRepository = novozarazeniJpaRepository;
    }

    @Override
    public List<NovozarazeniDTO> findAll() {
        return novozarazeniJpaRepository.findAll().stream().map(NovozarazeniDTO::new).collect(Collectors.toList());
    }

    @Override
    public Optional<NovozarazeniDTO> findByParameters(String ime, String prezime, String hospitaliziran) {
        return novozarazeniJpaRepository.findAllByParameters(ime,prezime,hospitaliziran).map(NovozarazeniDTO::new);
    }

    @Override
    public NovozarazeniDTO save(NovozarazeniCommand novozarazeniCommand) {
        return mapNovozarazeniToDTO(novozarazeniJpaRepository.save(mapToNovozarazeni(novozarazeniCommand)));
    }

    @Override
    public void update(int id, final NovozarazeniCommand novozarazeniCommand) {
        Novozarazeni novozarazeni = novozarazeniJpaRepository.findByOboljeliId(id);
        novozarazeni.updateNovozarazeni(novozarazeniCommand);
        novozarazeniJpaRepository.save(novozarazeni);
    }

    @Override
    public void deleteById(int id) {
        novozarazeniJpaRepository.deleteByOboljeliId(id);
    }

    private Novozarazeni mapToNovozarazeni(final NovozarazeniCommand novozarazeniCommand){
        return new Novozarazeni(novozarazeniCommand);
    }

    private NovozarazeniDTO mapNovozarazeniToDTO(final Novozarazeni novozarazeni){
        return new NovozarazeniDTO(novozarazeni);
    }
}

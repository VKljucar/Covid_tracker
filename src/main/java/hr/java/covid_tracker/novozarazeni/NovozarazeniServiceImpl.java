package hr.java.covid_tracker.novozarazeni;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NovozarazeniServiceImpl implements NovozarazeniService{

    private final NovozarazeniRepository novozarazeniRepository;

    public NovozarazeniServiceImpl(NovozarazeniRepository novozarazeniRepository){
        this.novozarazeniRepository = novozarazeniRepository;
    }

    @Override
    public List<NovozarazeniDTO> findAll() {
        return novozarazeniRepository.findAll().stream().map(NovozarazeniDTO::new).collect(Collectors.toList());
    }

    @Override
    public Optional<NovozarazeniDTO> findByParameters(String ime, String prezime, String hospitaliziran) {
        return novozarazeniRepository.findByParameters(ime,prezime,hospitaliziran).map(NovozarazeniDTO::new);
    }

    @Override
    public Optional<NovozarazeniDTO> save(NovozarazeniCommand novozarazeniCommand) {
        return novozarazeniRepository
                .save(new Novozarazeni(novozarazeniCommand))
                .map(NovozarazeniDTO::new);
    }

    @Override
    public Optional<NovozarazeniDTO> update(final int id, final NovozarazeniCommand novozarazeniCommand) {
        return novozarazeniRepository.update(id, mapToNovozarazeni(novozarazeniCommand)).map(this::mapNovozarazeniToDTO);
    }

    @Override
    public void deleteById(int id) {
        novozarazeniRepository.deleteById(id);
    }

    private Novozarazeni mapToNovozarazeni(final NovozarazeniCommand novozarazeniCommand){
        return new Novozarazeni(novozarazeniCommand.getOsobaId(),novozarazeniCommand.getIme(),novozarazeniCommand.getPrezime(),novozarazeniCommand.getDatRodenja(),novozarazeniCommand.getAdresa(),novozarazeniCommand.getTelefon(),novozarazeniCommand.getEmail(),novozarazeniCommand.getHospitaliziran(),novozarazeniCommand.getLokacija());
    }

    private NovozarazeniDTO mapNovozarazeniToDTO(final Novozarazeni novozarazeni){
        return new NovozarazeniDTO(novozarazeni);
    }
}

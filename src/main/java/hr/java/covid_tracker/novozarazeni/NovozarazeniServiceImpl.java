package hr.java.covid_tracker.novozarazeni;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class NovozarazeniServiceImpl implements NovozarazeniService{

    private final NovozarazeniJpaRepository novozarazeniJpaRepository;

    public NovozarazeniServiceImpl(NovozarazeniJpaRepository novozarazeniJpaRepository){
        this.novozarazeniJpaRepository = novozarazeniJpaRepository;
    }

    @Override
    public List<NovozarazeniDTO> findAll() {
        return novozarazeniJpaRepository.findAll().stream().map(this::mapNovozarazeniToDTO).collect(Collectors.toList());
    }

    @Override
    public List<NovozarazeniDTO> findByFilter(String ime, String prezime, String hospitaliziran) {
        return novozarazeniJpaRepository.findAllByParameters(ime,prezime,hospitaliziran).stream().collect(Collectors.toList());
    }

    @Override
    public Integer countAll(){
        return novozarazeniJpaRepository.countAll();
    }

    @Override
    public Integer findNovozarazeniForDay(){
        return novozarazeniJpaRepository.findNovozarazeniForDay();
    }

    @Override
    public Integer countAllHosp(){
        return novozarazeniJpaRepository.countAllHosp();
    }

    @Override
    public Integer findHospitaliziraniForDay(){
        return novozarazeniJpaRepository.findHospitaliziraniForDay();
    }

    @Override
    public Integer countNovozarazeniByDate(String datum) {
        return novozarazeniJpaRepository.countNovozarazeniByDate(datum);
    }

    public List<Integer> novozarazeniByDate(){
        DateTimeFormatter format = DateTimeFormatter
                .ofPattern("yyyy-MM-dd");

        DateTimeFormatter nazivDan = DateTimeFormatter
                .ofPattern("EEEE");

        LocalDateTime now = LocalDateTime.now();

//        Map<String, Integer> mapaDatuma = new LinkedHashMap<>();
//
//        for (int i = 7; i >= 0; i--){
//            mapaDatuma.put((now.minusDays(i).format(nazivDan)),countNovozarazeniByDate(now.minusDays(i).format(format)));
//        }
//        return mapaDatuma;

        List<Integer> datumi = new ArrayList<>();

        for (int i = 7; i >= 0; i--){
            datumi.add(countNovozarazeniByDate(now.minusDays(i).format(format)));
        }
        return datumi;
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

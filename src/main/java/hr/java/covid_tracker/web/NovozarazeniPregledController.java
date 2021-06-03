package hr.java.covid_tracker.web;

import hr.java.covid_tracker.novozarazeni.Novozarazeni;
import hr.java.covid_tracker.novozarazeni.NovozarazeniDTO;
import hr.java.covid_tracker.novozarazeni.NovozarazeniJpaRepository;
import hr.java.covid_tracker.novozarazeni.NovozarazeniService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("novozarazeni-pregled")
@CrossOrigin(origins = "http://localhost:8080")
public class NovozarazeniPregledController {

    private final NovozarazeniService novozarazeniService;
    private final NovozarazeniJpaRepository novozarazeniJpaRepository;

    public NovozarazeniPregledController(NovozarazeniService novozarazeniService, NovozarazeniJpaRepository novozarazeniJpaRepository) {
        this.novozarazeniService = novozarazeniService;
        this.novozarazeniJpaRepository = novozarazeniJpaRepository;
    }

//    @GetMapping
//    public List<NovozarazeniDTO> getAllNovozarazeni() {
//        return novozarazeniService.findAll();
//    }
//
//    @GetMapping("{ime,prezime,hospitaliziran}")
//    public NovozarazeniDTO getByParameters(@PathVariable final String ime, @PathVariable final String prezime, @PathVariable final String hospitaliziran) {
//        return novozarazeniService.findByParameters(ime, prezime, hospitaliziran)
//                .orElseThrow(
//                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nije pronađena ni jedna osoba")
//                );
//    }

    @GetMapping
    public List<Novozarazeni> getAllNovozarazeni() {
        return novozarazeniJpaRepository.findAll();
    }

    @GetMapping("/{ime},{prezime},{hospitaliziran}")
    public List<Novozarazeni> getUserByUsername(@PathVariable String ime, @PathVariable String prezime, @PathVariable String hospitaliziran) {
        return novozarazeniJpaRepository.findAllByParameters(ime, prezime, hospitaliziran);
    }

}

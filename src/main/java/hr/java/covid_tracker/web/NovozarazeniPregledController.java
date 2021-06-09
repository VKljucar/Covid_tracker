package hr.java.covid_tracker.web;

import hr.java.covid_tracker.novozarazeni.NovozarazeniDTO;
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

    public NovozarazeniPregledController(NovozarazeniService novozarazeniService) {
        this.novozarazeniService = novozarazeniService;
    }

    @GetMapping
    public List<NovozarazeniDTO> getAll() {
        return novozarazeniService.findAll();
    }

    @GetMapping("{ime}/{prezime}/{hospitaliziran}")
    public NovozarazeniDTO getByParameters(@PathVariable final String ime, @PathVariable final String prezime, @PathVariable final String hospitaliziran) {
        return novozarazeniService.findByParameters(ime, prezime, hospitaliziran)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nije pronađena ni jedna osoba")
                );
    }

}

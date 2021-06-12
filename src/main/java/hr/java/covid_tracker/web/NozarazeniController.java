package hr.java.covid_tracker.web;

import hr.java.covid_tracker.novozarazeni.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("novozarazeni")
@CrossOrigin(origins = "http://localhost:8080")
public class NozarazeniController {

    private final NovozarazeniService novozarazeniService;

    public NozarazeniController(NovozarazeniService novozarazeniService) {
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public NovozarazeniDTO save(@Valid @RequestBody final NovozarazeniCommand novozarazeniCommand) {
        return novozarazeniService.save(novozarazeniCommand);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @Valid @RequestBody final NovozarazeniCommand updateNovozarazeniCommand) {
        novozarazeniService.update(id, updateNovozarazeniCommand);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{oboljeli_id}")
    public void delete(@PathVariable final int oboljeli_id) {
        novozarazeniService.deleteById(oboljeli_id);
    }

}

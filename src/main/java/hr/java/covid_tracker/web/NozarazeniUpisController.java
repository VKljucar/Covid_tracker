package hr.java.covid_tracker.web;

import hr.java.covid_tracker.novozarazeni.NovozarazeniCommand;
import hr.java.covid_tracker.novozarazeni.NovozarazeniDTO;
import hr.java.covid_tracker.novozarazeni.NovozarazeniService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("novozarazeni-upis")
@CrossOrigin(origins = "http://localhost:8080")
public class NozarazeniUpisController {

    private final NovozarazeniService novozarazeniService;

    public NozarazeniUpisController(NovozarazeniService novozarazeniService) {
        this.novozarazeniService = novozarazeniService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public NovozarazeniDTO save(@Valid @RequestBody final NovozarazeniCommand novozarazeniCommand) {
        return novozarazeniService.save(novozarazeniCommand)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.CONFLICT, "Postoji osoba sa istim podacima")
                );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        novozarazeniService.deleteById(id);
    }

}

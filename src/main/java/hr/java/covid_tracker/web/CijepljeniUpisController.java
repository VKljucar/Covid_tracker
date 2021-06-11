package hr.java.covid_tracker.web;

import hr.java.covid_tracker.cijepljeni.CijepljeniCommand;
import hr.java.covid_tracker.cijepljeni.CijepljeniDTO;
import hr.java.covid_tracker.cijepljeni.CijepljeniJpaRepository;
import hr.java.covid_tracker.cijepljeni.CijepljeniService;
import hr.java.covid_tracker.novozarazeni.NovozarazeniCommand;
import hr.java.covid_tracker.novozarazeni.NovozarazeniDTO;
import hr.java.covid_tracker.novozarazeni.NovozarazeniJpaRepository;
import hr.java.covid_tracker.novozarazeni.NovozarazeniService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("cijepljeni-upis")
@CrossOrigin(origins = "http://localhost:8080")
public class CijepljeniUpisController {

    private final CijepljeniService cijepljeniService;
    private final CijepljeniJpaRepository cijepljeniJpaRepository;

    public CijepljeniUpisController(CijepljeniService cijepljeniService, CijepljeniJpaRepository cijepljeniJpaRepository) {
        this.cijepljeniService = cijepljeniService;
        this.cijepljeniJpaRepository = cijepljeniJpaRepository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CijepljeniDTO save(@Valid @RequestBody final CijepljeniCommand cijepljeniCommand) {
        return cijepljeniService.save(cijepljeniCommand);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable final int id){
        cijepljeniJpaRepository.deleteById(id);
    }

}

package hr.java.covid_tracker.web;

import hr.java.covid_tracker.novozarazeni.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("novozarazeni-upis")
@CrossOrigin(origins = "http://localhost:8080")
public class NozarazeniUpisController {

    private final NovozarazeniService novozarazeniService;
    private final NovozarazeniJpaRepository novozarazeniJpaRepository;

    public NozarazeniUpisController(NovozarazeniService novozarazeniService, NovozarazeniJpaRepository novozarazeniJpaRepository) {
        this.novozarazeniService = novozarazeniService;
        this.novozarazeniJpaRepository = novozarazeniJpaRepository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public NovozarazeniDTO save(@Valid @RequestBody final NovozarazeniCommand novozarazeniCommand) {
        return novozarazeniService.save(novozarazeniCommand)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.CONFLICT, "Postoji osoba sa istim podacima")
                );
    }

    @PutMapping("/{id}")
    public ResponseEntity<NovozarazeniDTO> update(@PathVariable int id, @Valid @RequestBody final NovozarazeniCommand updateNovozarazeniCommand){
        return novozarazeniService.update(id, updateNovozarazeniCommand)
                .map(ResponseEntity::ok)
                .orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{oboljeli_id}")
    public void delete(@PathVariable final int oboljeli_id){
        novozarazeniJpaRepository.deleteByOboljeliId(oboljeli_id);
    }

}

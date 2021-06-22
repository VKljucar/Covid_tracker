package hr.java.covid_tracker.web;

import hr.java.covid_tracker.novozarazeni.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("novozarazeni")
@CrossOrigin(origins = "http://localhost:8080")
public class NozarazeniController {

    private final NovozarazeniService novozarazeniService;

    public NozarazeniController(NovozarazeniServiceImpl novozarazeniService) {
        this.novozarazeniService = novozarazeniService;
    }

    @GetMapping
    public List<NovozarazeniDTO> getAll() {
        return novozarazeniService.findAll();
    }

    @GetMapping("/param")
    @ResponseBody
    public List<NovozarazeniDTO> getByParameters(@RequestParam(required = false, name = "ime") final String ime,
                                                 @RequestParam(required = false, name = "prezime") final String prezime,
                                                 @RequestParam(required = false, name = "hospitaliziran") final String hospitaliziran) {
        return novozarazeniService.findByFilter(ime, prezime, hospitaliziran);
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

package hr.java.covid_tracker.web;

import hr.java.covid_tracker.cijepljeni.Cijepljeni;
import hr.java.covid_tracker.cijepljeni.CijepljeniJpaRepository;
import hr.java.covid_tracker.cijepljeni.CijepljeniService;
import hr.java.covid_tracker.novozarazeni.Novozarazeni;
import hr.java.covid_tracker.novozarazeni.NovozarazeniJpaRepository;
import hr.java.covid_tracker.novozarazeni.NovozarazeniService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cijepljeni-pregled")
@CrossOrigin(origins = "http://localhost:8080")
public class CijepljeniPregledController {

    private final CijepljeniService cijepljeniService;
    private final CijepljeniJpaRepository cijepljeniJpaRepository;

    public CijepljeniPregledController(CijepljeniService cijepljeniService, CijepljeniJpaRepository cijepljeniJpaRepository) {
        this.cijepljeniService = cijepljeniService;
        this.cijepljeniJpaRepository= cijepljeniJpaRepository;
    }


    @GetMapping
    public List<Cijepljeni> getAllCijepljeni() {
        return cijepljeniJpaRepository.findAll();
    }

//    @GetMapping("/{ime},{prezime},{cijepivo_id}")
//    public List<Cijepljeni> getUserByUsername(@PathVariable String ime, @PathVariable String prezime, @PathVariable int cijepivo_id) {
//        return cijepljeniJpaRepository.findAllByParameters(ime, prezime, cijepivo_id);
//    }
    @GetMapping("/{ime}")
    public List<Cijepljeni> getByParam(@PathVariable String ime){

        return cijepljeniJpaRepository.findAllByIme(ime);

    }

}

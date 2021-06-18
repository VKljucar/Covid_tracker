package hr.java.covid_tracker.web;

import hr.java.covid_tracker.bolnice.BolniceDTO;
import hr.java.covid_tracker.bolnice.BolniceService;
import hr.java.covid_tracker.bolnice.BolniceServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("bolnice")
@CrossOrigin(origins = "http://localhost:8080")
public class BolniceController {

    private final BolniceService bolniceService;

    public BolniceController(BolniceServiceImpl bolniceService) {
        this.bolniceService = bolniceService;
    }

    @GetMapping
    public List<BolniceDTO> getAll(){
        return bolniceService.findAll();
    }

}

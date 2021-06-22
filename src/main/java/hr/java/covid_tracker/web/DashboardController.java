package hr.java.covid_tracker.web;

import hr.java.covid_tracker.cijepljeni.CijepljeniService;
import hr.java.covid_tracker.cijepljeni.CijepljeniServiceImpl;
import hr.java.covid_tracker.novozarazeni.NovozarazeniService;
import hr.java.covid_tracker.novozarazeni.NovozarazeniServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("dashboard")
@CrossOrigin(origins = "http://localhost:8080")
public class DashboardController {


    private final NovozarazeniService novozarazeniService;
    private final CijepljeniService cijepljeniService;
    private final NovozarazeniServiceImpl novozarazeniServiceImpl;

    public DashboardController(NovozarazeniServiceImpl novozarazeniService, CijepljeniServiceImpl cijepljeniService, NovozarazeniServiceImpl novozarazeniServiceImpl) {
        this.novozarazeniService = novozarazeniService;
        this.cijepljeniService = cijepljeniService;
        this.novozarazeniServiceImpl = novozarazeniServiceImpl;
    }

    @GetMapping("/allNovi")
    public Integer getAllNovozarazeni() {
        return novozarazeniService.countAll();
    }

    @GetMapping("/novi")
    public Integer getNovozarazeniForDay() {
        return novozarazeniService.findNovozarazeniForDay();
    }

    @GetMapping("/allHosp")
    public Integer getAllHospitalizirani() {
        return novozarazeniService.countAllHosp();
    }

    @GetMapping("/hosp")
    public Integer getHospitaliziraniForDay() {
        return novozarazeniService.findHospitaliziraniForDay();
    }

    @GetMapping("/allCijep")
    public Integer getAllCijepljeni() {
        return cijepljeniService.countAll();
    }

    @GetMapping("/cijep")
    public Integer getCijepljeniForDay() {
        return cijepljeniService.findCijepljeniForDay();
    }

    @GetMapping("/graf1")
    public List<Integer> getNovozarazeniByDate(){
        return novozarazeniServiceImpl.novozarazeniByDate();
    }


}
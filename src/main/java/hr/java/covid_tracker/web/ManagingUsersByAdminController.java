package hr.java.covid_tracker.web;

import hr.java.covid_tracker.managingUsersByAdmin.ManagingUsersByAdminDTO;
import hr.java.covid_tracker.managingUsersByAdmin.ManagingUsersByAdminService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("managingUsersByAdmin")
@CrossOrigin(origins = "http://localhost:8080")
public class ManagingUsersByAdminController {

    private final ManagingUsersByAdminService managingUsersByAdminService;

    public ManagingUsersByAdminController(ManagingUsersByAdminService managingUsersByAdminService) {
        this.managingUsersByAdminService = managingUsersByAdminService;
    }

    @GetMapping
    public List<ManagingUsersByAdminDTO> getAllUsers(){
        return managingUsersByAdminService.findAll();
    }

        @ResponseStatus(HttpStatus.NO_CONTENT)
        @DeleteMapping("{researchName}")
        public void delete(@PathVariable final String id){
            managingUsersByAdminService.deleteByResearchName(id);
        }

    }

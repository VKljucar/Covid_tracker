package hr.java.covid_tracker.managingUsersByAdmin;

import java.util.List;
import java.util.Optional;

public interface ManagingUsersByAdminService {

    List<ManagingUsersByAdminDTO> findAll();

    Optional<ManagingUsersByAdminDTO> save(ManagingUsersByAdminCommand managingUsersByAdminCommand);

    void deleteByResearchName(String researchName);


}

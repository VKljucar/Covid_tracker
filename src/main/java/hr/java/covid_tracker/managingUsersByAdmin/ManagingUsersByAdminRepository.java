package hr.java.covid_tracker.managingUsersByAdmin;

import java.util.Optional;
import java.util.Set;

interface ManagingUsersByAdminRepository {

    Set<ManagingUsersByAdmin> findAll();

    Optional<ManagingUsersByAdmin> findByResearchName(String researchName);

    Optional<ManagingUsersByAdmin> save(ManagingUsersByAdmin managingUsersByAdmin);

    void deleteByResearchName(String researchName);

}

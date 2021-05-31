package hr.java.covid_tracker.managingUsersByAdmin;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ManagingUsersByAdminServiceImpl implements ManagingUsersByAdminService {

    private final ManagingUsersByAdminRepository managingUsersByAdminRepository;

    public ManagingUsersByAdminServiceImpl(ManagingUsersByAdminRepository managingUsersByAdminRepository) {
        this.managingUsersByAdminRepository = managingUsersByAdminRepository;
    }

    @Override
    public List<ManagingUsersByAdminDTO> findAll() {
        return managingUsersByAdminRepository.findAll().stream().map(ManagingUsersByAdminDTO::new).collect(Collectors.toList());
    }

    @Override
    public Optional<ManagingUsersByAdminDTO> save(ManagingUsersByAdminCommand managingUsersByAdminCommand) {
        return managingUsersByAdminRepository
                .save(new ManagingUsersByAdmin(managingUsersByAdminCommand))
                .map(ManagingUsersByAdminDTO::new);
    }

    @Override
    public void deleteByResearchName(String researchName) {

        managingUsersByAdminRepository.deleteByResearchName(researchName);

    }
}

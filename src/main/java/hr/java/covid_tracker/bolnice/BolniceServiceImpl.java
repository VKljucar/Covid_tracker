package hr.java.covid_tracker.bolnice;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BolniceServiceImpl implements BolniceService{

    private final BolniceJpaRepository bolniceJpaRepository;

    public BolniceServiceImpl(BolniceJpaRepository bolniceJpaRepository) {
        this.bolniceJpaRepository = bolniceJpaRepository;
    }

    @Override
    public List<BolniceDTO> findAll(){
        return bolniceJpaRepository.findAll().stream().map(this::mapBolniceToDTO).collect(Collectors.toList());
    }

    private BolniceDTO mapBolniceToDTO(final Bolnice bolnice){
        return new BolniceDTO(bolnice);
    }

}

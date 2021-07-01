package hr.java.covid_tracker;

import hr.java.covid_tracker.bolnice.Bolnice;
import hr.java.covid_tracker.bolnice.BolniceJpaRepository;
import hr.java.covid_tracker.bolnice.BolniceService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BolniceServiceTest {

    @Autowired
    private BolniceService service;

    @Mock
    private BolniceJpaRepository repository;

    @Test
    public void findAll() {
        when(repository.findAll()).thenReturn(
                Stream.of(new Bolnice(1, "Bolnica1"),
                            new Bolnice(2, "Bolnice2"),
                            new Bolnice(3, "Bolnice3"),
                            new Bolnice(4, "Bolnice4"),
                            new Bolnice(5, "Bolnice5"),
                            new Bolnice(6, "Bolnice6")).collect(Collectors.toList()));
        assertEquals(6, service.findAll().size());
    }

}

package hr.java.covid_tracker;

import hr.java.covid_tracker.novozarazeni.Novozarazeni;
import hr.java.covid_tracker.novozarazeni.NovozarazeniDTO;
import hr.java.covid_tracker.novozarazeni.NovozarazeniJpaRepository;
import hr.java.covid_tracker.novozarazeni.NovozarazeniService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class NovozarazeniServiceTest {

    @Autowired
    private NovozarazeniService service;

    @MockBean
    private NovozarazeniJpaRepository repository;

    @Test
    public void findAll() {

        when(repository.findAll()).thenReturn(
                Stream.of(new Novozarazeni(1, 2, "ime", "prezime", "12.02.1992.", "adresa", "12312312321", "test@test.com", "D", 2),
                        new Novozarazeni(2, 3, "ime2", "prezime2", "12.02.1993.", "adresa2", "12312312341", "test2@test.com", "N", 1)).collect(Collectors.toList()));

        assertEquals(2, service.findAll().size());
    }

    @Test
    public void findAllByParameters() {

        when(repository.findAllByParameters("test1", "test1", "D")).thenReturn(
                Stream.of(new NovozarazeniDTO(new Novozarazeni(1, 2, "test1", "test1", "12.02.1992.", "adresa", "12312312321", "test@test.com", "D", 2)),
                        new NovozarazeniDTO(new Novozarazeni(2, 3, "ime2", "prezime2", "12.02.1993.", "adresa2", "12312312341", "test2@test.com", "N", 1))).collect(Collectors.toList()));

        assertNotNull(service.findByFilter("test1", "test1", "D"));
        assertEquals(2, service.findByFilter("test1", "test1", "D").size());
    }

    @Test
    public void countAll() {
        when(repository.countAll()).thenReturn(2);
        assertEquals(2, service.countAll());
    }

    @Test
    public void findNovozarazeniForDay() {
        when(repository.findNovozarazeniForDay()).thenReturn(2);
        assertEquals(2, service.findNovozarazeniForDay());
    }

    @Test
    public void countAllHosp() {
        when(repository.countAllHosp()).thenReturn(2);
        assertEquals(2, service.countAllHosp());
    }

    @Test
    public void findHospitaliziraniForDay() {
        when(repository.findHospitaliziraniForDay()).thenReturn(2);
        assertEquals(2, service.findHospitaliziraniForDay());
    }

    @Test
    public void countNovozarazeniByDate() {
        when(repository.countNovozarazeniByDate("01.07.2021")).thenReturn(1);
        assertEquals(1, service.countNovozarazeniByDate("01.07.2021"));
    }

    @Test
    public void countHospitaliziraniByDate() {
        when(repository.countHospitaliziraniByDate("01.07.2021")).thenReturn(1);
        assertEquals(1, service.countHospitaliziraniByDate("01.07.2021"));
    }

    @Test
    public void deleteByOboljeliId() {
        service.deleteById(2);
        verify(repository, times(1)).deleteByOboljeliId(2);
    }

}

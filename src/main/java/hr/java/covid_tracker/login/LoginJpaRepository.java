package hr.java.covid_tracker.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoginJpaRepository extends JpaRepository<Login, Integer> {

    List<Login> findAll();

    @Query("SELECT p.ime, p.prezime, p.korisnickoIme, p.uloga FROM Login p WHERE UPPER(p.korisnickoIme) = UPPER(:korisnickoIme)")
    List<String> findAllByKorisnickoIme(@Param("korisnickoIme") String korisnickoIme);

//    List<Login> findAllByKorisnickoIme(String korisnickoIme);

}

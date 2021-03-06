package hr.java.covid_tracker.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoginJpaRepository extends JpaRepository<Login, Integer> {

    List<Login> findAll();

    @Query("SELECT p FROM Login p WHERE UPPER(p.korisnickoIme) = UPPER(:korisnickoIme)")
    List<Login> findAllByKorisnickoIme(@Param("korisnickoIme") String korisnickoIme);

    Optional<Login> findByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka);

    Optional<Login> findByKorisnickoIme(String korisnickoIme);
}

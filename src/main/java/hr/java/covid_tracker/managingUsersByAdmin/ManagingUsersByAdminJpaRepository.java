package hr.java.covid_tracker.managingUsersByAdmin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ManagingUsersByAdminJpaRepository extends JpaRepository<ManagingUsersByAdmin, Integer> {


        List<ManagingUsersByAdmin> findAll();

        @Query("SELECT p FROM Login p WHERE UPPER(p.korisnickoIme) = UPPER(:korisnickoIme)")
        List<ManagingUsersByAdmin> findAllByKorisnickoIme(@Param("korisnickoIme") String korisnickoIme);


    }


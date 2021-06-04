package hr.java.covid_tracker.cijepljeni;

import hr.java.covid_tracker.novozarazeni.Novozarazeni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CijepljeniJpaRepository extends JpaRepository<Cijepljeni, Integer> {

    List<Cijepljeni> findAll();

    @Query("SELECT p FROM Cijepljeni p " +
            "WHERE (:ime IS NULL OR UPPER(p.ime) LIKE CONCAT('%',UPPER(:ime),'%')) AND (:prezime IS NULL OR UPPER(p.prezime) LIKE CONCAT('%',UPPER(:prezime),'%')) " +
            "AND (:hospitaliziran IS NULL OR UPPER(p.hospitaliziran) LIKE CONCAT('%',UPPER(:hospitaliziran),'%'))")
    List<Cijepljeni> findAllByParameters(@Param("ime") String ime, @Param("prezime") String prezime, @Param("cijepivo_id") int cijepivo_id);

    @Transactional
    @Modifying
    void deleteById(int id);

}

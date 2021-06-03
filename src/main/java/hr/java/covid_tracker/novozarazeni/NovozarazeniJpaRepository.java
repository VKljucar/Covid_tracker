package hr.java.covid_tracker.novozarazeni;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NovozarazeniJpaRepository extends JpaRepository<Novozarazeni, Integer> {

    List<Novozarazeni> findAll();

//    @Query("SELECT p.osobaId, p.ime, p.prezime, p.datRodenja, p.adresa, p.email, p.prezime, p.hospitaliziran, p.lokacija " +
//            "FROM Novozarazeni p " +
//            "WHERE (:ime IS NULL OR UPPER(p.ime) LIKE CONCAT('%',UPPER(:ime),'%')) AND (:prezime IS NULL OR UPPER(p.prezime) LIKE CONCAT('%',UPPER(:prezime),'%')) " +
//            "AND (:hospitaliziran IS NULL OR UPPER(p.hospitaliziran) LIKE CONCAT('%',UPPER(:hospitaliziran),'%'))")
//    List<Novozarazeni> findAllByParameters(@Param("ime") String ime, @Param("prezime") String prezime, @Param("hospitaliziran") String hospitaliziran);

    @Query("SELECT p FROM Novozarazeni p " +
            "WHERE (:ime IS NULL OR UPPER(p.ime) LIKE CONCAT('%',UPPER(:ime),'%')) AND (:prezime IS NULL OR UPPER(p.prezime) LIKE CONCAT('%',UPPER(:prezime),'%')) " +
            "AND (:hospitaliziran IS NULL OR UPPER(p.hospitaliziran) LIKE CONCAT('%',UPPER(:hospitaliziran),'%'))")
    List<Novozarazeni> findAllByParameters(@Param("ime") String ime, @Param("prezime") String prezime, @Param("hospitaliziran") String hospitaliziran);

}

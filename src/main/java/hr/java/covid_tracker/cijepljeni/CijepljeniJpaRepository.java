package hr.java.covid_tracker.cijepljeni;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CijepljeniJpaRepository extends JpaRepository<Cijepljeni, Integer> {

    List<Cijepljeni> findAll();

//    @Query("SELECT p FROM Cijepljeni p " +
//            "WHERE (:ime IS NULL OR UPPER(p.ime) LIKE CONCAT('%',UPPER(:ime),'%')) AND (:prezime IS NULL OR UPPER(p.prezime) LIKE CONCAT('%',UPPER(:prezime),'%')) " +
//            "AND (:cijepivo_id IS NULL OR UPPER(p.cijepivo_id) LIKE CONCAT('%',UPPER(:cijepivo_id),'%'))")
//    List<Cijepljeni> findAllByParameters(@Param("ime") String ime, @Param("prezime") String prezime, @Param("cijepivo_id") int cijepivo_id);

    List<Cijepljeni> findAllByIme(String ime);

    @Transactional
    @Modifying
    void deleteById(int id);

    Cijepljeni findByCijepljeni(int id);

    Optional<Cijepljeni> findAllByParameters(@Param("ime") String ime, @Param("prezime") String prezime, @Param("cijepivo_id") int cijepivo_id);


}

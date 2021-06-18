package hr.java.covid_tracker.cijepljeni;

import org.springframework.context.annotation.Primary;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Primary
@Repository
public class JdbcCijepljeniRepository implements CijepljeniRepository {

    private static final String TABLE_NAME = "cijepljeni";
    private static final String GENERATED_KEY_COLUMN = "cijepljeni_id";

    private static final String SELECT_ALL = "SELECT * FROM cijepljeni";

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public JdbcCijepljeniRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName(TABLE_NAME)
                .usingGeneratedKeyColumns(GENERATED_KEY_COLUMN);
    }

    @Override
    public Set<Cijepljeni> findAll() {
        return Set.copyOf(jdbcTemplate.query(SELECT_ALL, this::mapRowToCijepljeni));
    }

    @Override
    public Optional<Cijepljeni> findByParameters(String ime, String prezime, int cijepivoID) {
        try {
            return Optional.ofNullable(
                    jdbcTemplate.queryForObject(SELECT_ALL + "WHERE ime = NVL2(?,?,ime) AND prezime = NVL2(?,?,prezime) AND cijepivoID = NVL2(?,?,cijepivo_id)", this::mapRowToCijepljeni, ime, prezime, cijepivoID)
            );
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Cijepljeni> save(Cijepljeni cijepljeni) {
        try {
            cijepljeni.setCijepljeniID(saveCijepljeni(cijepljeni));
            return Optional.of(cijepljeni);
        } catch (DuplicateKeyException e) {
            return Optional.empty();
        }
    }


    @Override
    public Optional<Cijepljeni> update(int id, Cijepljeni updateCijepljeni) {
        int executed = jdbcTemplate.update("UPDATE cijepljeni SET" +
                        "osoba_id = ?, " +
                        "ime = ?, " +
                        "prezime = ?, " +
                        "dat_rodenja = ?, " +
                        "adresa = ?, " +
                        "telefon = ?, " +
                        "email = ?, " +
                        "cijepivo_id = ?, " +
                        "lokacija = ?, " +
                        "WHERE oboljeli_id = ?",
                updateCijepljeni.getCijepljeniID(),
                updateCijepljeni.getOsobaID(),
                updateCijepljeni.getIme(),
                updateCijepljeni.getPrezime(),
                updateCijepljeni.getDatRodenja(),
                updateCijepljeni.getAdresa(),
                updateCijepljeni.getTelefon(),
                updateCijepljeni.getEmail(),
                updateCijepljeni.getDatumCijepljenja(),
                updateCijepljeni.getCijepivoID()
        );

        if(executed > 0){
            return Optional.of(updateCijepljeni);
        } else {
            return Optional.empty();
        }

    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update("DELETE FROM oboljeli WHERE cijepljeni_id = ?", id);
    }


    private Cijepljeni mapRowToCijepljeni(ResultSet rs, int rowNum) throws SQLException {
        return new Cijepljeni(
                rs.getInt("oboljeli_id"),
                rs.getInt("osoba_id"),
                rs.getString("ime"),
                rs.getString("prezime"),
                rs.getString("dat_rodenja"),
                rs.getString("adresa"),
                rs.getString("telefon"),
                rs.getString("email"),
                rs.getString("datumCijepljenja"),
                rs.getInt("hr/java/covid_tracker/bolnice")
        );
    }

    private int saveCijepljeni(Cijepljeni cijepljeni) {
        Map<String, Object> values = new HashMap<>();

        values.put("cijepljeni_id", cijepljeni.getCijepljeniID());
        values.put("osoba_id", cijepljeni.getOsobaID());
        values.put("ime", cijepljeni.getIme());
        values.put("prezime", cijepljeni.getPrezime());
        values.put("dat_rodenja", cijepljeni.getDatRodenja());
        values.put("adresa", cijepljeni.getAdresa());
        values.put("telefon", cijepljeni.getTelefon());
        values.put("email", cijepljeni.getEmail());
        values.put("datum_cijepljenja", cijepljeni.getDatumCijepljenja());
        values.put("cijepivo_id", cijepljeni.getCijepivoID());

        return simpleJdbcInsert.executeAndReturnKey(values).intValue();
    }
}

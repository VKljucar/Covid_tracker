package hr.java.covid_tracker.novozarazeni;

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
public class JdbcNovozarazeniRepository implements NovozarazeniRepository {

    private static final String TABLE_NAME = "oboljeli";
    private static final String GENERATED_KEY_COLUMN = "oboljeli_id";

    private static final String SELECT_ALL = "SELECT * FROM oboljeli";

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public JdbcNovozarazeniRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName(TABLE_NAME)
                .usingGeneratedKeyColumns(GENERATED_KEY_COLUMN);
    }

    @Override
    public Set<Novozarazeni> findAll() {
        return Set.copyOf(jdbcTemplate.query(SELECT_ALL, this::mapRowToNovozarazeni));
    }

    @Override
    public Optional<Novozarazeni> findByParameters(String ime, String prezime, String hospitaliziran) {
        try {
            return Optional.ofNullable(
                    jdbcTemplate.queryForObject(SELECT_ALL + "WHERE ime = NVL2(?,?,ime) AND prezime = NVL2(?,?,prezime) AND hospitalizirani = NVL2(?,?,hospitalizirani)", this::mapRowToNovozarazeni, ime, prezime, hospitaliziran)
            );
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Novozarazeni> save(Novozarazeni novozarazeni) {
        try {
            novozarazeni.setOboljeliId(saveNovozarazeni(novozarazeni));
            return Optional.of(novozarazeni);
        } catch (DuplicateKeyException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Novozarazeni> update(int id, Novozarazeni updateNovozarazeni) {
        int executed = jdbcTemplate.update("UPDATE OBOLJELI SET " +
                        "osoba_id = ?, " +
                        "ime = ?, " +
                        "prezime = ?, " +
                        "dat_rodenja = ?, " +
                        "adresa = ?, " +
                        "telefon = ?, " +
                        "email = ?, " +
                        "hospitaliziran = ?, " +
                        "lokacija = ? " +
                        "WHERE oboljeli_id = ?",
                        updateNovozarazeni.getOsobaId(),
                        updateNovozarazeni.getIme(),
                        updateNovozarazeni.getPrezime(),
                        updateNovozarazeni.getDatRodenja(),
                        updateNovozarazeni.getAdresa(),
                        updateNovozarazeni.getTelefon(),
                        updateNovozarazeni.getEmail(),
                        updateNovozarazeni.getHospitaliziran(),
                        updateNovozarazeni.getLokacija(),
                        updateNovozarazeni.getOboljeliId()
        );

        if(executed > 0){
            return Optional.of(updateNovozarazeni);
        } else {
            return Optional.empty();
        }

    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update("DELETE FROM oboljeli WHERE oboljeli_id = ?", id);
    }


    private Novozarazeni mapRowToNovozarazeni(ResultSet rs, int rowNum) throws SQLException {
        return new Novozarazeni(
                rs.getInt("osoba_id"),
                rs.getString("ime"),
                rs.getString("prezime"),
                rs.getString("dat_rodenja"),
                rs.getString("adresa"),
                rs.getString("telefon"),
                rs.getString("email"),
                rs.getString("hospitaliziran"),
                rs.getInt("lokacija")
        );
    }

    private int saveNovozarazeni(Novozarazeni novozarazeni) {
        Map<String, Object> values = new HashMap<>();

        values.put("osoba_id", novozarazeni.getOsobaId());
        values.put("ime", novozarazeni.getIme());
        values.put("prezime", novozarazeni.getPrezime());
        values.put("dat_rodenja", novozarazeni.getDatRodenja());
        values.put("adresa", novozarazeni.getAdresa());
        values.put("telefon", novozarazeni.getTelefon());
        values.put("email", novozarazeni.getEmail());
        values.put("hospitaliziran", novozarazeni.getHospitaliziran());
        values.put("lokacija", novozarazeni.getLokacija());

        return simpleJdbcInsert.executeAndReturnKey(values).intValue();
    }
}

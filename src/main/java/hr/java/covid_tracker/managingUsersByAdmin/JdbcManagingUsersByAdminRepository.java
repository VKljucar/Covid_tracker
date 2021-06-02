package hr.java.covid_tracker.managingUsersByAdmin;


import hr.java.covid_tracker.login.Type;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DuplicateKeyException;
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
public class JdbcManagingUsersByAdminRepository implements ManagingUsersByAdminRepository {

    private static final String TABLE_NAME = "korisnici";
    private static final String GENERATED_KEY_COLUMN = "id";
    private static final String SELECT_ALL = "SELECT * FROM korisnici";

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public JdbcManagingUsersByAdminRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName(TABLE_NAME)
                .usingGeneratedKeyColumns(GENERATED_KEY_COLUMN);
    }

    @Override
    public Set<ManagingUsersByAdmin> findAll() {
        return Set.copyOf(jdbcTemplate.query(SELECT_ALL, this::mapRowToManagingUsersByAdmin));
    }

    @Override
    public Optional<ManagingUsersByAdmin> findByResearchName(String researchName) {
        return Optional.empty();
    }

    @Override
    public Optional<ManagingUsersByAdmin> save(ManagingUsersByAdmin managingUsersByAdmin) {
        try {
            managingUsersByAdmin.setId(saveManagingUsersByAdminDetails(managingUsersByAdmin));
            return Optional.of(managingUsersByAdmin);
        } catch (DuplicateKeyException e) {
            return Optional.empty();
        }
    }

    @Override
    public void deleteByResearchName(String username) {
        jdbcTemplate.update("DELETE FROM korisnici WHERE korisnicko_ime = ?", username); //promjeni username
    }

    private ManagingUsersByAdmin mapRowToManagingUsersByAdmin(ResultSet rs, int rowNum) throws SQLException { //promjeni prema tablici
        return new ManagingUsersByAdmin(
                rs.getInt("ID"),
                rs.getString("IME"),
                rs.getString("PREZIME"),
                rs.getString("KORISNICKO_IME"),
                rs.getString("LOZINKA"),
                Type.valueOf(rs.getString("ULOGA"))
        );
    }

    private int saveManagingUsersByAdminDetails(ManagingUsersByAdmin managingUsersByAdmin) {

        Map<String, Object> values = new HashMap<>();

        values.put("id", managingUsersByAdmin.getId());
        values.put("ime", managingUsersByAdmin.getFirstname());
        values.put("prezime", managingUsersByAdmin.getLastname());
        values.put("korisnicko_ime", managingUsersByAdmin.getUsername());
        values.put("lozinka", managingUsersByAdmin.getPassword());
        values.put("uloga", managingUsersByAdmin.getRole());

        return simpleJdbcInsert.executeAndReturnKey(values).intValue();

    }


}

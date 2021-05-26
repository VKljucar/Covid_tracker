package hr.java.covid_tracker.repository;

import hr.java.covid_tracker.model.Login;
import hr.java.covid_tracker.model.Type;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Set;

@Primary
@Repository
public class JdbcLoginRepository implements LoginRepository {

    private static final String TABLE_NAME = "korisnici";
    private static final String GENERATED_KEY_COLUMN = "id";

    private static final String SELECT_ALL = "SELECT * FROM korisnici";

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public JdbcLoginRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName(TABLE_NAME)
                .usingGeneratedKeyColumns(GENERATED_KEY_COLUMN);
    }

    @Override
    public Set<Login> findAll() {
        return Set.copyOf(jdbcTemplate.query(SELECT_ALL, this::mapRowToLogin));
    }

    @Override
    public Optional<Login> findByUsername(String username) {
        try {
            return Optional.ofNullable(
                    jdbcTemplate.queryForObject(SELECT_ALL + " WHERE korisnicko_ime = ?", this::mapRowToLogin, username)
            );
        } catch (EmptyResultDataAccessException ex) {
            return Optional.empty();
        }
    }

    private Login mapRowToLogin(ResultSet rs, int rownum) throws SQLException {
        return new Login(
                rs.getLong("ID"),
                rs.getString("IME"),
                rs.getString("PREZIME"),
                rs.getString("KORISNICKO_IME"),
                rs.getString("LOZINKA"),
                Type.valueOf(rs.getString("ULOGA"))
        );
    }

}

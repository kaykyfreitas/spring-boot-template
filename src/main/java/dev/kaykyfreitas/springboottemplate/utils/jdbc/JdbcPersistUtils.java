package dev.kaykyfreitas.springboottemplate.utils.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class JdbcPersistUtils {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final JdbcTemplate jdbcTemplate;

    public <T> Long persist(final T object, final String query) {
        var params = new BeanPropertySqlParameterSource(object);
        var keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(query, params, keyHolder);
        return retrieveId(keyHolder);
    }

    private Long retrieveId(GeneratedKeyHolder keyHolder) {
        var map = keyHolder.getKeys();
        assert map != null;
        var object = map.get("GENERATED_KEYS");
        return Objects.nonNull(object) ? Objects.requireNonNull(keyHolder.getKey()).longValue() : null;
    }

    public Long persist(BeanPropertySqlParameterSource params, String query) {
        var keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(query, params, keyHolder);
        return retrieveId(keyHolder);
    }

    public void persist(String query) {
        jdbcTemplate.update(query);
    }

    public <T> void persistList(List<T> objects, String query) {
        objects.forEach(object -> persist(object, query));
    }

    public <T> void persistList(List<T> objects, String query, BeanPropertySqlParameterSource params) {
        objects.forEach(object -> persist(params, query));
    }

    public Long update(Object object, String query) {
        var id = persist(object, query);
        return Objects.isNull(id) ? null : id;
    }

    public void batchExecute(String query, BatchPreparedStatementSetter statement) {
        jdbcTemplate.batchUpdate(query, statement);
    }

    public int[] batchExecute(String query, SqlParameterSource[] batch) {
        return namedParameterJdbcTemplate.batchUpdate(query, batch);
    }

}

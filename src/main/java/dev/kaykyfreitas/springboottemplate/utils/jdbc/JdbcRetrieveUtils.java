package dev.kaykyfreitas.springboottemplate.utils.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JdbcRetrieveUtils {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final JdbcTemplate jdbcTemplate;

    public <T> Optional<T> retrieve(String query, SqlParameterSource params, Class<T> type) {
        return Optional.ofNullable(namedParameterJdbcTemplate.queryForObject(query, params, type));
    }

    public <T> Optional<T> retrieve(String query, Class<T> type) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(query, type));
    }

    public <T> Optional<T> retrieve(String query, Object[] args, Class<T> type) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(query, args, type));
    }

    public <T> List<T> retrieveList(String query, SqlParameterSource params, RowMapper<T> rowMapper) {
        return namedParameterJdbcTemplate.query(query, params, rowMapper);
    }

    public <T> List<T> retrieveList(String query, RowMapper<T> rowMapper) {
        return namedParameterJdbcTemplate.query(query, rowMapper);
    }

    public <T> List<T> retrieveList(String query, final SqlParameterSource params, Class<T> type) {
        return namedParameterJdbcTemplate.queryForList(query, params, type);
    }

}
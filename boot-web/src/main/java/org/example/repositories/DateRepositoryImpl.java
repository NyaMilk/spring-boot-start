package org.example.repositories;

import org.example.model.DateResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DateRepositoryImpl implements DateRepository {
    protected final JdbcTemplate jdbc;

    public DateRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final RowMapper<DateResponse> dateResponseRowMapper = (resultSet, rowNum) -> new DateResponse(resultSet.getString("name"), resultSet.getTimestamp("createdat"));

    @Override
    public List<DateResponse> findAll() {
        return jdbc.query("SELECT * FROM Users ORDER BY createdAt", dateResponseRowMapper);
    }
}

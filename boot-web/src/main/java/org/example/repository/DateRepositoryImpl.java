package org.example.repository;

import org.example.model.DateResponse;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DateRepositoryImpl implements DateRepository {
    protected final JdbcTemplate jdbc;
    private final RowMap rowMap;

    public DateRepositoryImpl(JdbcTemplate jdbc, RowMap rowMap) {
        this.jdbc = jdbc;
        this.rowMap = rowMap;
    }

    private final RowMapper<DateResponse> dateResponseRowMapper = (resultSet, rowNum) -> new DateResponse(resultSet.getString("name"), resultSet.getTimestamp("createdat"));

    @Override
    public List<DateResponse> findAll() {
        return jdbc.query("SELECT * FROM Users ORDER BY createdAt", dateResponseRowMapper);
    }

    @Override
    public String findData() {
        List<JSONObject> jsonObject = jdbc.query("SELECT * FROM Users ORDER BY createdAt", rowMap);
        System.out.println(jsonObject);
        return "ok";
    }
}

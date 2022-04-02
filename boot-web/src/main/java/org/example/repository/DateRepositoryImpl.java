package org.example.repository;

import org.example.model.DateResponse;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Repository;

import java.sql.Blob;
import java.sql.ResultSetMetaData;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Repository
public class DateRepositoryImpl implements DateRepository {
    protected final JdbcTemplate jdbc;
    private final RowMap rowMap;

    public DateRepositoryImpl(JdbcTemplate jdbc, RowMap rowMap) {
        this.jdbc = jdbc;
        this.rowMap = rowMap;
    }

    private final RowMapper<DateResponse> dateResponseRowMapper = (resultSet, rowNum) ->
    {
        Blob blob = resultSet.getBlob("xml");
        System.out.println("rowMapper " + blob);
        Object result = blob.getBytes(1, (int) blob.length());
        System.out.println("rowMapper " + result);
        byte[] bytes = blob.getBytes(1, (int) blob.length());
        System.out.println("rowMapper byte " + Arrays.toString(bytes));
        return new DateResponse(resultSet.getString("name"), resultSet.getTimestamp("createdat"), result);
    };

    private final RowMapper<DateResponse> dateResponseRowMapperMeta = (resultSet, rowNum) ->
    {
        ResultSetMetaData meta = resultSet.getMetaData();
        Object value = null;
        try {
            value = JdbcUtils.getResultSetValue(resultSet, 4, Class.forName(meta.getColumnClassName(4)));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new DateResponse(resultSet.getString("name"), resultSet.getTimestamp("createdat"), value);
    };

    @Override
    public List<DateResponse> findAll() {
//        return jdbc.query("SELECT * FROM Users ORDER BY createdAt", dateResponseRowMapper);
        return jdbc.query("SELECT * FROM Users ORDER BY createdAt", dateResponseRowMapperMeta);
    }

    @Override
    public List<JSONObject> findData(String tableName) {
        TableNames tableNames = TableNames.valueOf(tableName.toUpperCase(Locale.ROOT));
        List<JSONObject> jsonObject = jdbc.query(tableNames.getValue(), rowMap);
        System.out.println(jsonObject);
        return jsonObject;
    }
}

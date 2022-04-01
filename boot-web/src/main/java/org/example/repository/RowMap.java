package org.example.repository;

import org.json.JSONObject;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
public class RowMap implements RowMapper<JSONObject> {

    @Override
    public JSONObject mapRow(ResultSet rs, int rowNum) throws SQLException {
        ResultSetMetaData meta = rs.getMetaData();
        Map<String, Object> map = new HashMap<>();

        for (int i = 1; i <= meta.getColumnCount(); i++) {
            try {
                String column = JdbcUtils.lookupColumnName(meta, i);
                Object value = JdbcUtils.getResultSetValue(rs, i, Class.forName(meta.getColumnClassName(i)));
                map.put(column, value);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return new JSONObject(map);
    }
}

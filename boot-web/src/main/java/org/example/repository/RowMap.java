package org.example.repository;

import org.json.JSONObject;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class RowMap implements RowMapper<JSONObject> {

    @Override
    public JSONObject mapRow(ResultSet rs, int rowNum) throws SQLException {
        ResultSetMetaData meta = rs.getMetaData();
        Map<String, Object> map = new HashMap<>();

        for (int i = 1; i <= meta.getColumnCount(); i++) {
            try {
                System.out.println("1 requiredType :: " + Class.forName(meta.getColumnClassName(i)));
                System.out.println("2 :: " + meta.getColumnClassName(i));
                String column = JdbcUtils.lookupColumnName(meta, i);
                Object result = rs.getObject(column);
                System.out.println("3 :: " + result + " && class :: " + result.getClass().getName());
                System.out.println("4 :: " + column);
                if (Blob.class == Class.forName(meta.getColumnClassName(i))) {
                    System.out.println("5 :: blob");
                } else if (Clob.class == Class.forName(meta.getColumnClassName(i))) {
                    System.out.println("5 :: clob");
                } else if (Byte.TYPE == Class.forName(meta.getColumnClassName(i)) && Byte.class == Class.forName(meta.getColumnClassName(i))) {
                    System.out.println("5 :: Byte");
                } else if (Class.forName(meta.getColumnClassName(i)) == byte[].class) {
                    System.out.println("5 :: byte[]");
                } else if(result instanceof Blob) {
                    System.out.println("5 :: instanceof Blob");
                }
                System.out.println("6 typeName :: " + meta.getColumnTypeName(i));

                Object value;
                if (meta.getColumnTypeName(i).equals("BLOB")) {
//                Object value = JdbcUtils.getResultSetValue(rs, i, Class.forName(meta.getColumnClassName(i)));
                    Blob blob = (Blob) JdbcUtils.getResultSetValue(rs, i, Blob.class);
                    value = Objects.requireNonNull(blob).getBytes(1, (int) blob.length());
                    value = Base64.getEncoder().encodeToString((byte[]) value);
                } else {
                    value = JdbcUtils.getResultSetValue(rs, i);
                }

                map.put(column, value);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return new JSONObject(map);
    }
}

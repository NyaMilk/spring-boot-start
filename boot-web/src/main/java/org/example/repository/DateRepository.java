package org.example.repository;

import org.example.model.DateResponse;
import org.json.JSONObject;

import java.util.List;

public interface DateRepository {
    List<DateResponse> findAll();

    List<JSONObject> findData(String tableName);
}

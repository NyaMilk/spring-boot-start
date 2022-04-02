package org.example.service;

import org.example.model.DateResponse;
import org.json.JSONObject;

import java.util.List;

public interface DateService {
    List<DateResponse> getAllDates();

    List<JSONObject> getAllData(String tableName);
}

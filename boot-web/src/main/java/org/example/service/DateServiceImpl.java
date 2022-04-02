package org.example.service;

import org.example.model.DateResponse;
import org.example.repository.DateRepository;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DateServiceImpl implements DateService {
    private final DateRepository dateRepository;

    public DateServiceImpl(DateRepository dateRepository) {
        this.dateRepository = dateRepository;
    }

    @Override
    public List<DateResponse> getAllDates() {
        return dateRepository.findAll();
    }

    @Override
    public List<JSONObject> getAllData(String tableName) {
        return dateRepository.findData(tableName);
    }
}

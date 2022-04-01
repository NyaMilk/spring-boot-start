package org.example.service;

import org.example.model.DateResponse;

import java.util.List;

public interface DateService {
    List<DateResponse> getAllDates();

    String getAllData();
}

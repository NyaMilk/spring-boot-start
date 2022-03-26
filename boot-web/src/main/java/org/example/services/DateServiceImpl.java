package org.example.services;

import org.example.model.DateResponse;
import org.example.repositories.DateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DateServiceImpl implements DateService {
    @Autowired
    private DateRepository dateRepository;

    @Override
    public List<DateResponse> getAllDates() {
        return dateRepository.findAll();
    }
}

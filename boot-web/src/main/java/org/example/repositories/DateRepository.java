package org.example.repositories;

import org.example.model.DateResponse;

import java.util.List;

public interface DateRepository {
    List<DateResponse> findAll();
}

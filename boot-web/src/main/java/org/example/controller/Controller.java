package org.example.controller;

import org.example.model.DateResponse;
import org.example.services.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    private DateService dateService;

    @GetMapping("/dates")
    public ResponseEntity<?> getDates() {
        List<DateResponse> dateResponseList = dateService.getAllDates();

//        if (dateResponseList.isEmpty()) {
//            return ResponseEntity.ok().body(dateResponseList);
//        }

        return ResponseEntity.badRequest().body("Empty response");
    }
}

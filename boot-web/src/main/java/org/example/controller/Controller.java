package org.example.controller;

import org.example.model.DateResponse;
import org.example.service.DateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private final DateService dateService;

    public Controller(DateService dateService) {
        this.dateService = dateService;
    }

    @GetMapping("/dates")
    public ResponseEntity<?> getDates() {
        List<DateResponse> dateResponseList = dateService.getAllDates();

//        if (dateResponseList.isEmpty()) {
//            return ResponseEntity.ok().body(dateResponseList);
//        }

        return ResponseEntity.badRequest().body("Empty response");
    }

    @GetMapping("/allData")
    public void getAllData() {
        String st = dateService.getAllData();
        System.out.println(st);
    }
}

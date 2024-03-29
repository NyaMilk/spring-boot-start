package org.example.controller;

import org.example.model.DatasResponse;
import org.example.model.DateResponse;
import org.example.repository.TableNames;
import org.example.service.DateService;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import lombok.extern.slf4j.Slf4j;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class Controller {
    private final DateService dateService;

    public Controller(DateService dateService) {
        this.dateService = dateService;
    }

    @GetMapping("/dates")
    public ResponseEntity<?> getDates() {
        List<DateResponse> dateResponseList = dateService.getAllDates();

        if (dateResponseList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(dateResponseList);
    }

    @GetMapping("/allData")
//    public ResponseEntity<List<JSONObject>> getAllData() {
    public ResponseEntity<String> getAllData(@RequestParam String tableName) {
        List<JSONObject> jsonObject = dateService.getAllData(tableName);
        System.out.println("allData " + jsonObject);
        return ResponseEntity.ok().body(jsonObject.toString());
    }

    @GetMapping("/allDataJson")
    public ResponseEntity<?> getAllDataJson(@RequestParam String tableName, HttpServletRequest request) {
        TableNames tableNameValue = TableNames.valueOf(tableName.toUpperCase(Locale.ROOT));
        List<JSONObject> jsonObject = dateService.getAllData(tableNameValue.name());
        log.info("Received getDatesByTable for table '{}' from {}", tableName, request.getRemoteHost());

//        String encodedString = Base64.getEncoder().encodeToString(jsonObject.toString().getBytes(StandardCharsets.UTF_8));
//        DatasResponse datasResponse = new DatasResponse(jsonObject.get(0).getLong("id"), new Date(), encodedString);
        DatasResponse datasResponse = new DatasResponse(jsonObject.get(0).getLong("id"), new Date(), jsonObject.toString());
        System.out.println("getAllDataJson " + jsonObject);
        return ResponseEntity.ok().body(datasResponse);
    }
}

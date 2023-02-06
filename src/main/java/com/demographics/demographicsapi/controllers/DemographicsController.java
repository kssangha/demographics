package com.demographics.demographicsapi.controllers;

import com.demographics.demographicsapi.models.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.demographics.demographicsapi.services.DemographicsService;

import java.math.BigDecimal;

@RestController
public class DemographicsController {

    @Autowired
    DemographicsService demographicsService;

    public DemographicsController(DemographicsService demographicsService){
        this.demographicsService = demographicsService;
    }

    @GetMapping("/v2/demographics")
    @ResponseBody
    public ResponseEntity<Object> getDemographics(@NonNull @RequestParam String lat, @NonNull @RequestParam String lng, @NonNull @RequestParam String key){
        BigDecimal latBigDecimal = new BigDecimal(lat);
        BigDecimal lngBigDecimal = new BigDecimal(lng);


        Data responseData = demographicsService.getDemographicsData(latBigDecimal.longValue(), lngBigDecimal.longValue());
        if (authenticateKey(key)) {
            return ResponseEntity.ok(responseData);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Key Does Not Match");
        }
    }


    // A check like this can be done on the longitude and latitude values to ensure the location is within the range
    private boolean authenticateKey (String key){
        String lock = "verticalCity";

        if (key.equals(lock)){
            return true;
        }
        else {
            return false;
        }
    }
}

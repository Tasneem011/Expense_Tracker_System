package com.example.expensetracker.Controller;

import com.example.expensetracker.dto.GraphDto;
import com.example.expensetracker.dto.StatusDto;
import com.example.expensetracker.stats.service.StatusService;
import com.example.expensetracker.stats.service.StatusServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/stats")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StatsController {

    private final StatusService statusService;
    @GetMapping("/chart")
    public ResponseEntity<?> getAllChartDetails(){
        
        return ResponseEntity.ok(statusService.getCharDate());
    }
    @GetMapping

    public ResponseEntity<?> getStatus(){
        return ResponseEntity.ok(statusService.getStatus());
    }


}



package com.example.expensetracker.stats.service;

import com.example.expensetracker.dto.GraphDto;
import com.example.expensetracker.dto.StatusDto;

public interface StatusService {
    GraphDto getCharDate();
    StatusDto getStatus();
}

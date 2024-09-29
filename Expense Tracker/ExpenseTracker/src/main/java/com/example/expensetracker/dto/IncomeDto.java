package com.example.expensetracker.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
@Data
@RequiredArgsConstructor
public class IncomeDto {
    private long id;
    private String title;
    private String description;
    private double amount;
    private Date date;
    private String category;
    private String type;


}

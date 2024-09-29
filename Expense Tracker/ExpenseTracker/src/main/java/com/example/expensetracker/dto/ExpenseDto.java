package com.example.expensetracker.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseDto {
    private Long id;
    private String title;
    private String description;
    private String category;
    private LocalDate expenseDate;
    private Integer amount;
}

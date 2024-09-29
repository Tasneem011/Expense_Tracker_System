package com.example.expensetracker.dto;

import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.entity.Income;
import lombok.Data;

@Data
public class StatusDto {
    private Double income;
    private Double expense;
    private Income latestincome;
    private Expense latestexpense;
private Double balance;
private Double minIncome;
private Double maxIncome;
private Double minExpense;
private Double maxExpense;
}

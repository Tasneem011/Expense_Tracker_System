package com.example.expensetracker.dto;

import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.entity.Income;
import lombok.Data;

import java.util.List;

@Data
public class GraphDto {
    public List<Expense> expenses;
    public List<Income> incomes;
}

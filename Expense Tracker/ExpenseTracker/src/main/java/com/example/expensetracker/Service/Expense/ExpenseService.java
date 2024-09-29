package com.example.expensetracker.Service.Expense;

import com.example.expensetracker.dto.ExpenseDto;
import com.example.expensetracker.entity.Expense;

import java.util.List;

public interface ExpenseService {
    Expense postExpense(ExpenseDto expenseDto);
List<Expense> getALlExpenses();
Expense getExpenseById(Long ExpenseId);
Expense updateExpense( Long ExpenseId ,ExpenseDto expenseDto);
void deleteExpense(Long ExpenseId);
}

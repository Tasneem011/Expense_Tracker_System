package com.example.expensetracker.Service.Expense;

import com.example.expensetracker.dto.ExpenseDto;
import com.example.expensetracker.dto.IncomeDto;
import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.entity.Income;

import java.util.List;

public interface IncomeService {
    Income postIncome(IncomeDto incomeDto);
    List<Income> getAllIncomes();
    Income updateIncome(Long IncomeId , IncomeDto incomeDto);
    Income getIncomeById(Long IncomeId);
    void deleteIncome(Long IncomeId);

}

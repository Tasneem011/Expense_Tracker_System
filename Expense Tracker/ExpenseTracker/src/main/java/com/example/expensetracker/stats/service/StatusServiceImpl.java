package com.example.expensetracker.stats.service;

import com.example.expensetracker.Repository.ExpenseRepository;
import com.example.expensetracker.Repository.IncomeRepository;
import com.example.expensetracker.dto.GraphDto;
import com.example.expensetracker.dto.StatusDto;
import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.entity.Income;
import com.example.expensetracker.stats.service.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService {
    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;
@Override
    public GraphDto getCharDate() {
        LocalDate endDate = LocalDate.now(); // Today's date
        LocalDate startDate = endDate.minusDays(27); // Start date is yesterday

        GraphDto graphDto = new GraphDto();

        // Fetching expenses and incomes between startDate and endDate
        graphDto.setExpenses(expenseRepository.findByDateBetween(startDate, endDate));
        graphDto.setIncomes(incomeRepository.findByDateBetween(startDate, endDate));

        return graphDto;
    }

    public StatusDto getStatus() {
    Double totalIncome = incomeRepository.sumAllAmounts();
    Double totalExpense = expenseRepository.sumAllAmounts();
        Optional<Income> incomeOptional = incomeRepository.findFirstByOrderByDateDesc();
        Optional<Expense> expenseOptional = expenseRepository.findFirstByOrderByDateDesc();


    StatusDto statusDto = new StatusDto();
    statusDto.setIncome(totalIncome);
    statusDto.setExpense(totalExpense);
    statusDto.setBalance(totalIncome - totalExpense);
    incomeOptional.ifPresent(statusDto::setLatestincome);
    expenseOptional.ifPresent(statusDto::setLatestexpense);
        List<Income> incomeList = incomeRepository.findAll();
        List<Expense> expenseList = expenseRepository.findAll();
        OptionalDouble minIncome = incomeList.stream().mapToDouble(Income::getAmount).min();
        OptionalDouble maxIncome = incomeList.stream().mapToDouble(Income::getAmount).max();
        OptionalDouble minExpense = expenseList.stream().mapToDouble(Expense::getAmount).min();
        OptionalDouble maxExpense = expenseList.stream().mapToDouble(Expense::getAmount).max();
        statusDto.setMaxExpense(maxExpense.isPresent() ? maxExpense.getAsDouble() : null);
        statusDto.setMinExpense(minExpense.isPresent() ? minExpense.getAsDouble() : null);
        statusDto.setMaxIncome(maxIncome.isPresent() ? maxIncome.getAsDouble() : null);
        statusDto.setMinIncome(minIncome.isPresent() ? minIncome.getAsDouble() : null);
    return statusDto;
    }
}

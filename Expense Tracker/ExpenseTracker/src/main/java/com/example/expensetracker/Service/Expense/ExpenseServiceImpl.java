package com.example.expensetracker.Service.Expense;

import com.example.expensetracker.Repository.ExpenseRepository;
import com.example.expensetracker.dto.ExpenseDto;
import com.example.expensetracker.entity.Expense;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
private ExpenseRepository expenseRepository;

    @Override
    public Expense postExpense(ExpenseDto expenseDto) {
        Expense expense = new Expense();
        expense.setTitle(expenseDto.getTitle());
        expense.setAmount(expenseDto.getAmount());
        expense.setCategory(expenseDto.getCategory());
        expense.setDate(expenseDto.getExpenseDate());
      expense.setDescription(expenseDto.getDescription());
      expenseRepository.save(expense);

        Expense savedExpense = expenseRepository.save(expense);

        // Return the saved Expense
        return savedExpense;
    }

    @Override
    public List<Expense> getALlExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense getExpenseById(Long ExpenseId) {

    Optional<Expense> expense = expenseRepository.findById(ExpenseId);
       if (expense.isPresent()){
           return expense.get();
       }
       else {
           throw new EntityNotFoundException("Expense not found with id: " + ExpenseId);

       }
    }

    @Override
    public Expense updateExpense(Long ExpenseId, ExpenseDto expenseDto) {
        Optional<Expense> expense = expenseRepository.findById(ExpenseId);
        if (expense.isPresent()){
            return saveorupdateExpense(expense.get(),expenseDto);
        }
        else {
            throw new EntityNotFoundException("Expense not found with id: " + ExpenseId);
        }

    }

    @Override
    public void deleteExpense(Long ExpenseId) {
        Optional<Expense> expense = expenseRepository.findById(ExpenseId);
        if (expense.isPresent()){
            expenseRepository.deleteById(ExpenseId);
        }
        else {
            throw new EntityNotFoundException("Expense not found with id: " + ExpenseId);
        }
    }


    private Expense saveorupdateExpense(Expense expense , ExpenseDto expenseDto)  {
        expense.setTitle(expenseDto.getTitle());
        expense.setDate(expenseDto.getExpenseDate());
        expense.setAmount(expenseDto.getAmount());
        expense.setCategory(expenseDto.getCategory());
        expense.setDescription(expenseDto.getDescription());
        return expenseRepository.save(expense);
    }


}

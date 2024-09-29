package com.example.expensetracker.Service.Expense;

import com.example.expensetracker.Repository.IncomeRepository;
import com.example.expensetracker.dto.IncomeDto;
import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.entity.Income;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {
    private final IncomeRepository incomeRepository;


    public Income postIncome(IncomeDto incomeDto) {
        return saveorUpdateIncome(new Income(), incomeDto);

    }

    @Override
    public List<Income> getAllIncomes() {
        return incomeRepository.findAll().stream().sorted(Comparator.comparing(Income::getDate).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Income updateIncome(Long IncomeId, IncomeDto incomeDto) {
        Optional<Income> income = incomeRepository.findById(IncomeId);
        if (income.isPresent()){
            return saveorUpdateIncome(income.get(), incomeDto);
        }
        else {
            throw new EntityNotFoundException("Income not found with id: " + IncomeId);
        }

    }

    @Override
    public Income getIncomeById(Long IncomeId) {
        Optional<Income> income= incomeRepository.findById(IncomeId);
        if (income.isPresent()){
            return income.get();
        }
        else {
            throw new EntityNotFoundException("Income not found with id: " + IncomeId);

        }
    }


    @Override
    public void deleteIncome(Long IncomeId) {
        Optional<Income> income = incomeRepository.findById(IncomeId);
        if (income.isPresent()) {
            incomeRepository.delete(income.get());
        } else {
            throw new EntityNotFoundException("Income not found with id: " + IncomeId);
        }
    }



    private Income saveorUpdateIncome(Income income , IncomeDto incomeDto) {

income.setTitle(incomeDto.getTitle());
income.setDescription(incomeDto.getDescription());
income.setAmount(incomeDto.getAmount());
income.setDate(incomeDto.getDate());
income.setCategory(incomeDto.getCategory());
income.setDescription(incomeDto.getDescription());
income.setType(incomeDto.getType());
return incomeRepository.save(income);
    }
}

package com.example.expensetracker.entity;

import com.example.expensetracker.dto.IncomeDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private double amount;
    private Date date;
    private String category;
    private String type;
public IncomeDto getIncomeDto() {
    IncomeDto incomeDto = new IncomeDto();
    incomeDto.setId(id);
    incomeDto.setTitle(title);
    incomeDto.setDescription(description);
    incomeDto.setAmount(amount);
    incomeDto.setDate(date);
    incomeDto.setCategory(category);
    incomeDto.setType(type);
    return incomeDto;

}

}

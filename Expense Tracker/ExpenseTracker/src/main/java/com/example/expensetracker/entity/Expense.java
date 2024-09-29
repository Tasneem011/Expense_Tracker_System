package com.example.expensetracker.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

private String title;
private String description;
private String category;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "d-M-yyyy")
    @NotNull(message = "Date cannot be null")
private  LocalDate date;
private Integer amount;
}

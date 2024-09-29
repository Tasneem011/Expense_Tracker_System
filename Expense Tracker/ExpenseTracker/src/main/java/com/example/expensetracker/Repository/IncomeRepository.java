package com.example.expensetracker.Repository;

import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
    @Query("SELECT i FROM Income i WHERE i.date BETWEEN :startDate AND :endDate")
    List<Income> findByDateBetween(LocalDate startDate, LocalDate endDate);
    @Query("SELECT SUM(i.amount) FROM Income i")
    Double sumAllAmounts();
    Optional<Income> findFirstByOrderByDateDesc();
}

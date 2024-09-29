package com.example.expensetracker.Controller;

import com.example.expensetracker.Service.Expense.ExpenseService;
import com.example.expensetracker.Service.Expense.ExpenseServiceImpl;
import com.example.expensetracker.dto.ExpenseDto;
import com.example.expensetracker.entity.Expense;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping

    public ResponseEntity<?> postExpense(@RequestBody ExpenseDto expenseDto) {
        Expense createdExpense = expenseService.postExpense(expenseDto);
        if (createdExpense != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdExpense);

        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }


    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllExpenses() {
        return ResponseEntity.ok(expenseService.getALlExpenses());
    }



        @GetMapping("/{ExpenseId}")
        public ResponseEntity<?> getExpenseById(@PathVariable("ExpenseId") Long ExpenseId) {
            try {
                return ResponseEntity.ok(expenseService.getExpenseById(ExpenseId));
            } catch (EntityNotFoundException e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
            }
        }
        @PutMapping("/{id}")

        public ResponseEntity<?> updateExpense(@PathVariable Long id ,@RequestBody ExpenseDto expenseDto) {
            try {
                return ResponseEntity.ok(expenseService.updateExpense(id, expenseDto));

            } catch (EntityNotFoundException e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
            }

        }
        @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable Long id ) {
        try {
            expenseService.deleteExpense(id);
            return ResponseEntity.ok(null);

        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }

    }

        }



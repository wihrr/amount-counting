package by.vihrova.amountcounting.controller;

import by.vihrova.amountcounting.dto.EmployeeDto;
import by.vihrova.amountcounting.service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * Rest Controller for counting salary of every team member
 */
@RestController
@RequestMapping("api/salary")
@RequiredArgsConstructor
@Validated
public class SalaryController {
    private final SalaryService salaryService;

    /**
     * Method to get team members with allocated amount according to hours worked
     */
    @GetMapping("/period/{period}")
    public List<EmployeeDto> countSalary(@PathVariable("period") @Pattern(regexp = "^(\\d{4})-(0[1-9]|1[0-2])$") String period,
                                         @RequestParam double totalAmount,
                                         @RequestParam("mitarbeiterId") List<Long> employeesIds) {
        return salaryService.allocate(period, totalAmount, employeesIds);
    }
}

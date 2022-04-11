package by.vihrova.amountcounting.service;


import by.vihrova.amountcounting.dto.EmployeeDto;

import java.util.List;

/**
 * Service to work with worklogs
 */
public interface SalaryService {
    /**
     * Method to allocate total amount inside the team
     */
    List<EmployeeDto> allocate(String period, double totalAmount, List<Long> team);
}

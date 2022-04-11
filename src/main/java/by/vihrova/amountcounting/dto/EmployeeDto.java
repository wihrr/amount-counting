package by.vihrova.amountcounting.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Transfer object which stores employee's salary
 */
@Data
@AllArgsConstructor
public class EmployeeDto {
    @JsonProperty("mitarbeiterId")
    private long id;
    private double salary;
}

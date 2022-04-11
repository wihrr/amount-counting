package by.vihrova.amountcounting.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * Transfer object which stores employee's worklog-entry
 */
@Data
public class WorkLogDto {
    @JsonProperty("mitarbeiterId")
    private long employeeId;

    @DateTimeFormat(pattern = "${worklog.date-format}")
    private LocalDateTime begin;

    @JsonProperty("ende")
    @DateTimeFormat(pattern = "${worklog.date-format}")
    private LocalDateTime end;

    @JsonProperty("dauer")
    private int duration;
}

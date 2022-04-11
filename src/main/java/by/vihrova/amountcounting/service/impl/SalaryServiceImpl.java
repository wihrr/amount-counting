package by.vihrova.amountcounting.service.impl;

import by.vihrova.amountcounting.clients.WorklogServiceClient;
import by.vihrova.amountcounting.dto.EmployeeDto;
import by.vihrova.amountcounting.dto.WorkLogDto;
import by.vihrova.amountcounting.service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implementation of salary service
 */
@Service
@RequiredArgsConstructor
public class SalaryServiceImpl implements SalaryService {
    private final WorklogServiceClient worklogServiceClient;

    @Override
    public List<EmployeeDto> allocate(String period, double totalAmount, List<Long> team) {
        Map<Long, Integer> workload = worklogServiceClient.getAll(period).stream()
                .filter(workLogDto -> team.contains(workLogDto.getEmployeeId()))
                .collect(Collectors.groupingBy(WorkLogDto::getEmployeeId, Collectors.summingInt(WorkLogDto::getDuration)));
        int totalWorkload = workload.values().stream().mapToInt(Integer::intValue).sum();
        return team.stream()
                .map(id -> new EmployeeDto(id, getSalary(totalAmount, workload.getOrDefault(id, 0), totalWorkload)))
                .collect(Collectors.toList());
    }

    private double getSalary(double totalAmount, int employeeWorkload, int totalWorkload) {
        if(totalWorkload == 0) {
            return  0;
        }
        return totalAmount * employeeWorkload / totalWorkload;
    }
}

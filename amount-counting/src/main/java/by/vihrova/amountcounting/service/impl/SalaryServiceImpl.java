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
        return workload.entrySet().stream()
                .map(e->new EmployeeDto(e.getKey(), totalAmount*e.getValue()/totalWorkload))
                .collect(Collectors.toList());
    }
}

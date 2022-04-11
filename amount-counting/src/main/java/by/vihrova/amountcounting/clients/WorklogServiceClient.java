package by.vihrova.amountcounting.clients;

import by.vihrova.amountcounting.dto.WorkLogDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Client for working with worklog
 */
@FeignClient(name = "worklog-service", url = "${worklog.url}")
public interface WorklogServiceClient {
    /**
     *Method to get all worklogs
     */
    @GetMapping("/period/{period}")
    List<WorkLogDto> getAll(@PathVariable("period") String period);
}

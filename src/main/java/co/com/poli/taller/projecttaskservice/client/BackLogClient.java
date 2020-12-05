package co.com.poli.taller.projecttaskservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "backlog-service")
@RequestMapping(value = "/backlog")
public interface BackLogClient {
}

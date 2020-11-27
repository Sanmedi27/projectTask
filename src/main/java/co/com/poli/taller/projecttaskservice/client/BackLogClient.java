package co.com.poli.taller.projecttaskservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient
@RequestMapping(value = "/backlog")
public interface BackLogClient {
}

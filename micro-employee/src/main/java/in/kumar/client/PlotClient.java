package in.kumar.client;

import in.kumar.external.PlotDto;
import in.kumar.external.PlotResponse;
import in.kumar.payload.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient("MICRO-PLOT")
public interface PlotClient {

    @PostMapping("/api/plots")
    public ResponseEntity<ApiResponse<PlotResponse>> savePlot(@Valid @RequestBody PlotDto plotDto);
}

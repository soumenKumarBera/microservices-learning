package in.kumar.controller;

import in.kumar.PlotDto.PlotDto;
import in.kumar.entities.Plot;
import in.kumar.payload.ApiResponse;
import in.kumar.services.PlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/plots")
public class PlotMainController {

    @Autowired
    private PlotService plotService;



    // saveAccount
    @PostMapping
    public ResponseEntity<ApiResponse<Plot>> savePlot(@Valid @RequestBody PlotDto plotDto) {

        ApiResponse<Plot> savedPlotResponse = plotService.savePlot(plotDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlotResponse);
    }


  // getAllAccounts
@GetMapping
public ResponseEntity<ApiResponse<List<Plot>>> getAllPlots() {

    ApiResponse<List<Plot>> allPlotResponse = plotService.getAllPlot();
    return ResponseEntity.ok(allPlotResponse);


}

    //getSingleEmployee
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getSinglePlot(@PathVariable String id){

        Map<String, Object> singlePlotResponse = plotService.getSingPlot(id);
        return ResponseEntity.ok(singlePlotResponse);
    }
}

package in.kumar.services;

import in.kumar.PlotDto.PlotDto;
import in.kumar.entities.Plot;
import in.kumar.payload.ApiResponse;

import java.util.List;
import java.util.Map;

public interface PlotService {

    ApiResponse<Plot> savePlot(PlotDto plotDto);

    ApiResponse<List<Plot>> getAllPlot();

//    ApiResponse<Plot> getSingPlot(String id);

    Map<String , Object> getSingPlot(String id);



}

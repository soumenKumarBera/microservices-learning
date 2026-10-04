package in.kumar.services;

import in.kumar.PlotDto.PlotDto;
import in.kumar.client.EmployeeClient;
import in.kumar.entities.Plot;
import in.kumar.exception.ResourceNotFoundException;
import in.kumar.payload.ApiResponse;
import in.kumar.repository.PlotRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class PlotServiceImple implements PlotService {

    @Autowired
    private PlotRepo plotRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmployeeClient employeeClient;

    @Override
    public ApiResponse<Plot> savePlot(PlotDto plotDto) {

        //Check employId to employee services
        employeeClient.getSingleEmployee(plotDto.getEmployeeId());

        Plot plot = modelMapper.map(plotDto, Plot.class);
        plot.setId(UUID.randomUUID().toString());
        plot.setDatetime(LocalDateTime.now().toString());
        Plot savedPlot = plotRepo.save(plot);

        return new ApiResponse<>("SUCCESS", "Plot DATA CREATED", savedPlot);
    }

    @Override
    public ApiResponse<List<Plot>> getAllPlot() {
        List<Plot> allPlots = plotRepo.findAll();
        if(allPlots.isEmpty()) {
            return new ApiResponse<List<Plot>>("SUCCESS", "PLOT DATA NOT FOUND", allPlots);
        }
            return new ApiResponse<List<Plot>>("SUCCESS", "PLOT DATA FOUND", allPlots);
    }

//    @Override
//    public ApiResponse<Plot> getSingPlot(String id) {
//        Plot singlePlot = plotRepo.findById(id).orElseThrow(
//                ()->new ResourceNotFoundException("PLOT NOT FOUND WITH ID: "+id));
//
//        return new ApiResponse<>("SUCCESS", "SINGLE PLOT DATA FOUND", singlePlot);
//    }

    @Override
    public Map<String , Object> getSingPlot(String id) {
        Plot singlePlot = plotRepo.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("PLOT NOT FOUND WITH ID: "+id));

        Map<String, Object> map = new HashMap<>();

        map.put("status", "SUCCESS");
        map.put("message", "SINGLE PLOT DATA FOUND");
        map.put("data", singlePlot);



        return  map;
    }

    @Override
    public ApiResponse<Object> plotDataDeleted(String id) {

        plotRepo.deleteByEmployeeId(id);

        return new ApiResponse<>("SUCCESS","PLOT DATA DELETED", Collections.EMPTY_MAP);
    }
}

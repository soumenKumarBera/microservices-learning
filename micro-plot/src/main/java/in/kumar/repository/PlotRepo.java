package in.kumar.repository;

import in.kumar.entities.Plot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlotRepo extends JpaRepository<Plot, String> {




}

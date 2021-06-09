package realproject.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import realproject.hrms.business.abstracts.JobPositionService;
import realproject.hrms.core.utilities.results.Result;
import realproject.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobs")
public class JobPositionsController {
	
	private JobPositionService service;
	
	
	@Autowired
	public JobPositionsController(JobPositionService service) {
		super();
		this.service = service;
		
	}
	
	@GetMapping("/getall")
	public List<JobPosition> getAll(){
		return this.service.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobPosition jobPosition){
		return this.service.add(jobPosition);
	}
	
}

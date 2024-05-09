package com.example.OnlineRecruitment.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.OnlineRecruitment.Entities.Graduate;
import com.example.OnlineRecruitment.Entities.Job;
import com.example.OnlineRecruitment.Services.JobService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("http://localhost:4200")
public class JobControllers {

	@Autowired
	private JobService jobService;
	
	@PostMapping("/jobs")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String saveJobs(@Valid @RequestBody Job job,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return bindingResult.toString();
		}
		
		jobService.createJob(job);
		return "saved";
	}
	
	@GetMapping("/alljobs")
	public List<Job> getAllJobs(){
		return jobService.getAllJobs();
	}
	// this is meant to get the jobs which is associated with the on employer
	@GetMapping("/jobs/{roleId}")
	public List<Job> getJobById(@PathVariable String roleId) {
		return jobService.getJobById(roleId);
	}
	
	@DeleteMapping("/deletejob/{id}")
	public String deleteJobById(@PathVariable Integer id) {
		jobService.deleteJob(id);
		return "deleted Job";
	}
	@PutMapping("/updatejob/{id}")
	public String updateJobId(@PathVariable Integer id,@Valid @RequestBody Job job,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return bindingResult.toString();
		}
		jobService.updateJobById(id, job);
		return "updated job";
	}
	
	@GetMapping("/listgraduatejobId/{roleId}")
	public List<Graduate> listallgraduateswithId(@PathVariable String roleId)
	{
		return jobService.listOfAllgraduateById(roleId);
	}
	
	@GetMapping("/jobsByIntegerId/{id}")
	public Job getjobsByInteger(@PathVariable Integer id) {
		return jobService.getJobsByIntegerId(id);
	}
}

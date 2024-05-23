package com.example.OnlineRecruitment.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineRecruitment.Entities.Appointment;
import com.example.OnlineRecruitment.Entities.JobSeeker;
import com.example.OnlineRecruitment.Repositories.JobSeekerRepository;
@Service
public class JobSeekerService {

	@Autowired
	private JobSeekerRepository jobSeekerRepository;

	public String createJobSeeker(JobSeeker jobSeeker) {
		String gradId = jobSeeker.getGraduate().getRoleId().getRoleId();
		String jobId = jobSeeker.getJob().getJobId().toString();

		Appointment appointment = new Appointment();
		
		String applicantId = gradId.concat(jobId);
		
		appointment.setApplicantId(applicantId);
		
		jobSeeker.setAppointment(appointment);
		
		jobSeekerRepository.save(jobSeeker);
		
		return "created";
	}

	public List<JobSeeker> getalljobseeker() {
		// TODO Auto-generated method stub
		return jobSeekerRepository.findAll();
	}

	public List<JobSeeker> getalljobseekerbyemployeeId(String employeeId) {
		// TODO Auto-generated method stub
		return jobSeekerRepository.getAllJobseekerByemployeeId(employeeId);
	}

	public List<JobSeeker> getAlljobsByStudentId(String studentId) {
		// TODO Auto-generated method stub
		return jobSeekerRepository.getAllJobSeekerByStudentId(studentId);
	}
	
	
}

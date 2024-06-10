package com.example.OnlineRecruitment.Controllers;

import java.util.HashMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.OnlineRecruitment.Classes.Email;
@RestController
@CrossOrigin("http://localhost:4200")
public class AdminController {

	HashMap<String, String> admin = new HashMap<String, String>();
	
	public AdminController() {
		// TODO Auto-generated constructor stub
		admin.put("sohankalburgi2004@gmail.com","sohan");
		admin.put("rsyadav4848@gmail.com", "rohit");
		admin.put("snasim695@gmail.com", "sadaf");
	}
	
	@PostMapping("/checkadminlogin")
	public boolean checkAdminExist(@RequestBody Email email) {
		String emailId = email.getEmail();
		
		if(admin.containsKey(emailId)) {
			if(admin.get(emailId).equals(email.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
	
}

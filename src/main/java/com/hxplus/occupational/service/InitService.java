package com.hxplus.occupational.service;

import java.util.List;

import com.hxplus.occupational.model.Company;
import com.hxplus.occupational.model.Doctor;
import com.hxplus.occupational.model.Patient;
import com.hxplus.occupational.model.Post;
import com.hxplus.occupational.model.User;

public interface InitService {

	public List<Company> initCompanies();
	public List<Post> initPosts();
	public List<User> initUsers();
	public List<Doctor> initDoctors();
	public List<Patient> initPatients();

}

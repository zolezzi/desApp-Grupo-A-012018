package edu.unq.desapp.grupo_a.backend.service;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class UserRolesInitializationService {

//	@Autowired 
//	private AcademicOfferFactoryService academicOfferFactoryService;

	@PostConstruct
	private void initialize() {
		//academicOfferFactoryService.initialize();
	}
	
}

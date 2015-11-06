package com.hxplus.occupational.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.LazyInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.Allergy;
import com.hxplus.occupational.model.Background;
import com.hxplus.occupational.model.Company;
import com.hxplus.occupational.model.Consult;
import com.hxplus.occupational.model.CostCenter;
import com.hxplus.occupational.model.Department;
import com.hxplus.occupational.model.Doctor;
import com.hxplus.occupational.model.Drug;
import com.hxplus.occupational.model.Exam;
import com.hxplus.occupational.model.File;
import com.hxplus.occupational.model.Habit;
import com.hxplus.occupational.model.Laboratory;
import com.hxplus.occupational.model.Patient;
import com.hxplus.occupational.model.Post;
import com.hxplus.occupational.model.SoapNote;
import com.hxplus.occupational.model.User;
import com.hxplus.occupational.model.Vaccine;
import com.hxplus.occupational.model.VitalSign;
import com.hxplus.occupational.repositories.AllergyRepository;
import com.hxplus.occupational.repositories.BackgroundRepository;
import com.hxplus.occupational.repositories.CompanyRepository;
import com.hxplus.occupational.repositories.ConsultRepository;
import com.hxplus.occupational.repositories.CostCenterRepository;
import com.hxplus.occupational.repositories.DepartmentRepository;
import com.hxplus.occupational.repositories.DoctorRepository;
import com.hxplus.occupational.repositories.DrugRepository;
import com.hxplus.occupational.repositories.ExamRepository;
import com.hxplus.occupational.repositories.FileRepository;
import com.hxplus.occupational.repositories.HabitRepository;
import com.hxplus.occupational.repositories.LaboratoryRepository;
import com.hxplus.occupational.repositories.PatientRepository;
import com.hxplus.occupational.repositories.PostRepository;
import com.hxplus.occupational.repositories.PrescriptionRepository;
import com.hxplus.occupational.repositories.SoapNoteRepository;
import com.hxplus.occupational.repositories.UserRepository;
import com.hxplus.occupational.repositories.VaccineRepository;
import com.hxplus.occupational.repositories.VitalSignRepository;

@Service
public class InitServiceImpl implements InitService {

	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	CostCenterRepository costCenterRepository;
	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	PostRepository postRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	DoctorRepository doctorRepository;
	@Autowired
	PatientRepository patientRepository;

	@Autowired
	BackgroundRepository backgroundRepository;
	@Autowired
	AllergyRepository allergyRepository;
	@Autowired
	VaccineRepository vaccineRepository;
	@Autowired
	HabitRepository habitRepository;
	@Autowired
	ConsultRepository consultRepository;
	@Autowired
	ExamRepository examRepository;
	@Autowired
	SoapNoteRepository soapNoteRepository;
	@Autowired
	PrescriptionRepository prescriptionRepository;
	@Autowired
	VitalSignRepository vitalSignRepository;
	
	@Autowired
	LaboratoryRepository laboratoryRepository;
	@Autowired
	DrugRepository drugRepository;
	@Autowired
	FileRepository fileRepository;

	private final String[] companyNames = { "Polar", "Coca-Cola", "P&G",
			"Palmolive", "Protinal", "SIDOR" },

			rifs = { "J65826479", "J7989513654", "J78952314", "J3215445687",
					"J789456321", "J45673915" },

			departmentNames = { "Producción", "Mantenimiento", "Obrero",
					"Informática", "Planta", "Administración" },

			phoneNumbers = { "+582431578956", "+582124563278", "+582537458963",
					"+582399517562", "+582413698547", "+582128521397",
					"+582124567913" },

			costCenterAddress = { "Caracas", "Valencia", "Maracay",
					"Barquisimeto", "Pto Ordaz", "Maracaibo" },

			vitalSignNames = { "Pulso", "Sistólica", "Diastólica",
					"Oxigenación", "Saturación de O2", "Altura", "Peso",
					"Pecho", "Cadera", "Cintura", "Brazo", "Muslo", "IMC",
					"Temperatura" },

			postNames = { "Gerente", "Asistente", "Secretario", "Obrero",
					"Doctor", "Enfermero" },

			firstnames = { "Juan", "Jose", "Alberto", "Pedro", "Carlos",
					"Julio", "Fernando", "Daniel" },

			lastnames = { "Perez", "Lopez", "Mendez", "Ramirez" },

			passwords = { "4242", "2121", "6363", "8484" },

			cities = { "Caracas", "Valencia", "Maracay", "Barquisimeto" },

			bgNames = { "Torcedura de Pie", "Cólicos", "Hígado Graso",
					"Imfalmación Ocular" },

			nombres = { "Sol", "Pescado", "Yodo", "Maquillaje", "Jabón",
					"Champú", "Polem", "Penicilina" },

			severidades = { "Leve", "Moderada", "Severa", "Aguda", "Mortal" },

			habitNames = { "Cigarrillo", "Alcohol", "Deportes", "Trasnocho" },

			habitFrecuency = { "Varias veces al día", "Diario", "Semanal",
					"Quincenal", "Mensual", "Bimensual", "Anual" },

			vaccineNames = { "Polio", "Sarampión", "Viruela", "Triple",
					"Lechina" },
			vaccinePotency = { "Primera", "Segunda", "Refuerzo" },

			descriptions = {
					"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,",
					"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto",
					"Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in l",
					"Y, viéndole don Quijote de aquella manera, con muestras de tanta tristeza, le dijo: Sábete, Sancho, que no es un hombre más que otro si no hace más que otro. Todas estas borrascas.",
					"Reina en mi espíritu una alegría admirable, muy parecida a las dulces alboradas de la primavera, de que gozo aquí con delicia. Estoy solo, y me felicito de vivir en este país, el m",
					"Una mañana, tras un sueño intranquilo, Gregorio Samsa se despertó convertido en un monstruoso insecto. Estaba echado de espaldas sobre un duro caparazón y, al alzar la cabeza, vio.",
					"Muy lejos, más allá de las montañas de palabras, alejados de los países de las vocales y las consonantes, viven los textos simulados. Viven aislados en casas de letras, en la costa" },

			objectives = {
					"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur rid",
					"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto",
					"Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in l" },
			subjectives = {
					"Muy lejos, más allá de las montañas de palabras, alejados de los países de las vocales y las consonantes, viven los textos simulados. Viven aislados en casas de letras, en la costa",
					"Y, viéndole don Quijote de aquella manera, con muestras de tanta tristeza, le dijo: Sábete, Sancho, que no es un hombre más que otro si no hace más que otro. Todas estas borrascas.",
					"Reina en mi espíritu una alegría admirable, muy parecida a las dulces alboradas de la primavera, de que gozo aquí con delicia. Estoy solo, y me felicito de vivir en este país, el m" },
			plans = {
					"Reina en mi espíritu una alegría admirable, muy parecida a las dulces alboradas de la primavera, de que gozo aquí con delicia. Estoy solo, y me felicito de vivir en este país, el m",
					"Quiere la boca exhausta vid, kiwi, piña y fugaz jamón. Fabio me exige, sin tapujos, que añada cerveza al whisky. Jovencillo emponzoñado de whisky, ¡qué figurota exhibes! La cigüeña" },
			comments = { "abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !\"§ $%& /() =?* '<> #|; ²³~ @`´ ©«» ¤¼× {} abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ !" },
			examNames = { "Orina", "Placa de Tórax", "Perfil 20", "Tomografía",
					"Plaquetas" }, 
			labNames = {"Psizer", "Elmor", "Bayer", "Roche"},
			drugNames = {"Acetaminofén", "Ibuprofeno", "Lidocaína", "Antibiótico"};

	@Override
	public List<Company> initCompanies() {
		List<Company> companies = listCompanies();

		for (Company company : companies) {
			merge(company, listCostCenters(company), listDepartments(company));
		}

		companies = save(companies);

		System.out
				.println("······································Compañías Guardadas (Con Deptos y CostCenters)······································");

		return companies;
	}

	@Override
	public List<Post> initPosts() {
		List<Post> posts = new ArrayList<>();
		List<Company> companies = companyRepository.findAll();

		for (Company company : companies) {
			// System.out.println("Company: " + company.getCompanyName());
			List<Department> departments = departmentRepository
					.findByCompany(company);
			List<CostCenter> costCenters = costCenterRepository
					.findByCompany(company);

			posts.addAll(listPost(departments, costCenters));
		}

		posts = postRepository.save(posts);
		postRepository.flush();
		System.out
				.println("······································Puestos Guardados······································");

		return posts;
	}

	@Override
	public List<User> initUsers() {
		List<User> userList = listUsers();

		userRepository.save(userList);
		userRepository.flush();
		System.out
				.println("······································Usuarios Guardados······································");
		return userList;
	}

	@Override
	public List<Doctor> initDoctors() {
		List<User> userList = userRepository.findAll();
		List<Doctor> doctorList = listDoctors(userList);
		doctorRepository.save(doctorList);
		doctorRepository.flush();
		System.out
				.println("······································Doctores Guardados······································");
		return doctorList;
	}

	@Override
	public List<Patient> initPatients() {
		ArrayList<Patient> patientList = (ArrayList<Patient>) listPatients(Long
				.valueOf(1)), patients = new ArrayList<>();

		patients.addAll(savePatients(patientList));
		System.out
				.println("······································Primera lista de pacientes Guardados······································");

		patientList = (ArrayList<Patient>) listPatients(Long.valueOf(7));
		patients.addAll(savePatients(patientList));
		System.out
				.println("······································Pacientes Guardados······································");

		return patients;
	}

	private List<Patient> savePatients(List<Patient> patients) {
		List<Patient> guardados = new ArrayList<>();

		for (Patient patient : patients) {
			try {
				guardados.add(savePatient(patient));
			} catch (IllegalStateException ise) {
				// System.out.println("\t\t\t" + ise.getLocalizedMessage());
				// System.out.println("\t\t\tError guardando paciente. Procediendo a updatearlo");
				guardados.add(updatePatient(patient));
			} catch (LazyInitializationException lie) {
				// System.out.println("\t\t\t" + lie.getLocalizedMessage());
				// System.out.println("\t\t\tError inicializando algo en el paciente. Procediendo a updatearlo");
				guardados.add(updatePatient(patient));
			}
		}

		return guardados;
	}

	@Override
	public List<Laboratory> initLaboratories() {
		List<Laboratory> laboratories = new ArrayList<Laboratory>();
		int i = 0;
		
		for(String name : labNames){
			Laboratory laboratory = new Laboratory();
			i = (int)Math.random()*phoneNumbers.length;
			laboratory.setName(name);
			laboratory.setPhoneNumber(phoneNumbers[i]);
			laboratories.add(laboratory);
		}
		
		laboratoryRepository.save(laboratories);
		laboratoryRepository.flush();
		System.out.println("······································Laboratorios Guardados······································");
		return laboratories;
	}

	@Override
	public List<Drug> initDrugs() {
		List<Drug> drugs = new ArrayList<>();
		List<Laboratory> laboratories;
		
		for(String name : drugNames){
			laboratories = laboratoryRepository.findAll();
			Drug drug = new Drug();
			drug.setName(name);
			int drugLabs = (int) Math.random()*laboratories.size();
			
			for( int i = 0; i < drugLabs; i++){
				drug.setLaboratory(laboratories.remove((int)Math.random()*laboratories.size()));
				drugRepository.saveAndFlush(drug);
			}			
		}
		
		System.out.println("······································Medicamentos Guardados······································");
		return drugs;
	}

	private Patient updatePatient(Patient patient) {
		Patient newPatient = new Patient();

		try {
			newPatient = patientRepository.saveAndFlush(patient);
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
			System.out.println("\t\t\tProblemas updateando el doctor");
		}

		return newPatient;
	}

	private Patient savePatient(Patient patient) throws IllegalStateException,
			LazyInitializationException {

		Patient newPatient = patientRepository.saveAndFlush(patient);

		// System.out.println("Guardado paciente "
		// + newPatient.getUser().getFirstName() + " "
		// + newPatient.getUser().getLastName() + "\n" + "\tid: "
		// + newPatient.getId());

		List<Background> backgrounds = patient.getBackgrounds(), newBackgrounds = new ArrayList<>();
		List<Allergy> allergies = patient.getAllergies(), newAllergies = new ArrayList<>();
		List<Habit> habits = patient.getHabits(), newHabits = new ArrayList<>();
		List<Vaccine> vaccines = patient.getVaccines(), newVaccines = new ArrayList<>();
		List<Consult> consults = patient.getConsults(), newConsults = new ArrayList<>();

		for (Background background : backgrounds) {
			background.setPatient(newPatient);
			newBackgrounds.add(backgroundRepository.saveAndFlush(background));
			// System.out
			// .println("\tGuardando un background con id: "
			// + newBackgrounds.get(newBackgrounds.size() - 1)
			// .getId());
		}

		newPatient.setBackgrounds(newBackgrounds);

		for (Allergy allergy : allergies) {
			allergy.setPatient(newPatient);
			newAllergies.add(allergyRepository.saveAndFlush(allergy));
			// System.out.println("\tGuardando una alergia con id: "
			// + newAllergies.get(newAllergies.size() - 1).getId());
		}

		newPatient.setAllergies(newAllergies);

		for (Habit habit : habits) {
			habit.setPatient(newPatient);
			newHabits.add(habitRepository.saveAndFlush(habit));
			// System.out.println("\tGuardando un habito con id: "
			// + newHabits.get(newHabits.size() - 1).getId());
		}

		newPatient.setHabits(newHabits);

		for (Vaccine vaccine : vaccines) {
			vaccine.setPatient(newPatient);
			newVaccines.add(vaccineRepository.saveAndFlush(vaccine));
			// System.out.println("\tGuardando una vacuna con id: "
			// + newVaccines.get(newVaccines.size() - 1).getId());
		}

		newPatient.setVaccines(newVaccines);
		/*
		 * int i = 0; System.out.println("Consultas tiene " + consults.size() +
		 * " Elementos");
		 */for (Consult consult : consults) {
			consult.setPatient(newPatient);
			newConsults.add(saveConsult(consult));
			/*
			 * System.out.println("Guardando la " + (++i) + "° Consulta de " +
			 * patient.getUser().getFirstName() + " " +
			 * patient.getUser().getLastName());
			 */}

		newPatient.setConsults(newConsults);

		// System.out.println("Guardado Paciente");

		return newPatient;

	}

	private List<Patient> listPatients(Long idDoctor) {

		ArrayList<Patient> patients = new ArrayList<>();
		List<User> users = userRepository.findAll();
		Doctor doctor = doctorRepository.findOne(idDoctor);
		int cota = (int) (Math.random() * 16) + 10;

		for (long i = 0; i < cota; i++) {
			patients.add(createPatient(
					users.remove((int) (Math.random() * users.size())), doctor));
		}

		return patients;
	}

	private Patient createPatient(User user, Doctor doctor) {
		Patient patient;

		// System.out.println("idUser:\t\t" + user.getId() + "\nidDoctor:\t"
		// + doctor.getId() + "\n\t\t (" + user.getId() + ", "
		// + doctor.getId() + ")");

		patient = patientRepository.findByUser(user.getId());

		if (patient == null) {
			// System.out.println("El paciente es nulo");

			patient = new Patient();
			patient.setUser(user);

			ArrayList<Doctor> patientListDoctors = new ArrayList<>();
			patientListDoctors.add(doctor);

			patient.setDoctors(patientListDoctors);
			createHistory(patient, doctor);

		} else {
			// System.out.println("El paciente NO es nulo");

			List<Doctor> patientListDoctors = doctorRepository
					.listDoctorbyPatient(patient.getId());
			patientListDoctors.add(doctor);
			patient.setDoctors(patientListDoctors);
			patient.setUser(userRepository.findByIdPatient(patient.getId()));
		}

		// System.out.println(patient.toString());

		return patient;
	}

	private Patient createHistory(Patient patient, Doctor doctor) {

		patient.setBackgrounds(listBackgrounds());

		int allergiesCant = (int) (Math.random() * 10), vaccinesCant = (int) (Math
				.random() * 20), habitCant = (int) (Math.random() * 5);

		ArrayList<Allergy> allergies = new ArrayList<>();
		ArrayList<Habit> habits = new ArrayList<>();
		ArrayList<Vaccine> vaccines = new ArrayList<>();

		for (int i = 0; i < allergiesCant; i++) {
			allergies.add(createAllergy());
		}

		for (int i = 0; i < habitCant; i++) {
			habits.add(createHabit());
		}

		for (int i = 0; i < vaccinesCant; i++) {
			vaccines.add(createVaccine());
		}

		patient.setAllergies(allergies);
		patient.setHabits(habits);
		patient.setVaccines(vaccines);
		patient.setConsults(listConsults(doctor));

		return patient;
	}

	private List<Background> listBackgrounds() {
		List<Background> backgrounds = new ArrayList<>();

		for (int i = 0; i < bgNames.length; i++) {
			backgrounds.add(createBackground(bgNames[i]));
		}

		return backgrounds;
	}

	private Background createBackground(String name) {
		Background background = new Background();

		background.setName(name);
		background
				.setDescription(descriptions[(int) (Math.random() * descriptions.length)]);

		return background;
	}

	private Allergy createAllergy() {
		Allergy allergy = new Allergy();

		allergy.setName(nombres[(int) (Math.random() * nombres.length)]);
		allergy.setSeverity(severidades[(int) (Math.random() * severidades.length)]);

		return allergy;
	}

	private Habit createHabit() {
		Habit habit = new Habit();

		habit.setName(habitNames[(int) (Math.random() * habitNames.length)]);
		habit.setFrecuency(habitFrecuency[(int) (Math.random() * habitFrecuency.length)]);

		return habit;
	}

	private Vaccine createVaccine() {
		Vaccine vaccine = new Vaccine();

		vaccine.setName(vaccineNames[(int) (Math.random() * vaccineNames.length)]);
		vaccine.setPotency(vaccinePotency[(int) (Math.random() * vaccinePotency.length)]);

		return vaccine;
	}

	private List<Doctor> listDoctors(List<User> users) {

		List<Doctor> doctors = new ArrayList<>();

		Doctor doctor = createDoctor(users.get(0));
		doctors.add(doctor);
		// doctorRepository.save(doctor);

		for (Long i = Long.valueOf(2); i <= Long.valueOf(users.size() / 4); i++) {
			doctors.add(createDoctor(users.remove((int) (Math.random()
					* users.size() - 1) + 1)));
		}

		return doctors;
	}

	private Doctor createDoctor(User user) {

		Doctor doctor = new Doctor();

		doctor.setUser(user);
		doctor.setRegNumber((Long.valueOf(String.valueOf((int) (Math.random() * 20000000)))));

		return doctor;
	}

	private List<User> listUsers() {
		List<User> users = new ArrayList<User>();
		List<Post> posts = postRepository.findAll();
		

		
				
		User ale = createUser("Alejandro", "Tarazona", "atarazona", "4242",
				posts.get((int) (Math.random() * posts.size())));
		ale.setId(Long.valueOf(1));
		ale.setSex("M");
		ale.setBirthDate(new GregorianCalendar(1989, 2, 10).getTime());
				
		users.add(ale);

		for (int i = 0; i < firstnames.length; i++) {
			for (int k = 0; k < lastnames.length; k++) {
				users.add(createUser(firstnames[i], lastnames[k],
						firstnames[i].substring(0, 2) + lastnames[k],
						passwords[k],
						posts.get((int) (Math.random() * posts.size()))));
			}
		}

		return users;
	}

	private User createUser(String firstname, String lastname, String username,
			String password, Post post) {
		User user = new User();
		List<CostCenter> costCenters = costCenterRepository.findByPost(post);
		Company company = companyRepository.findByPost(post);
		String[] sex = { "M", "F" };
		int o = (int) (Math.random() * 2);
		int year = 1970 + ((int) (Math.random() * 46)), month = (int) (Math
				.random() * 12), day = (int) (Math.random() * 30);

		user.setBirthDate(new GregorianCalendar(year, month, day).getTime());
		user.setSex(sex[o]);
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setEmail(username + "@hxplus.com");
		user.setUsername(username);
		user.setPassword(password);
		user.setPost(post);
		user.setWorks(costCenters.get((int) (Math.random() * costCenters.size())));
		user.setEmployer(company);
		user.setAddress(cities[((int) (Math.random() * cities.length))]);
		return user;
	}

	private List<Company> save(List<Company> companies) {
		List<Company> salvadas = new ArrayList<>();

		for (Company company : companies) {
			company = companyRepository.save(company);

			departmentRepository.save(company.getDepartments());
			departmentRepository.flush();

			costCenterRepository.save(company.getCostCenters());
			costCenterRepository.flush();

			company.setMainLocation(company.getCostCenters().get(0));
			companyRepository.save(company);
			companyRepository.flush();
			salvadas.add(company);
		}

		return salvadas;
	}

	private Company merge(Company company, List<CostCenter> costCenters,
			List<Department> departments) {
		company.setDepartments(departments);
		company.setCostCenters(costCenters);
		return company;
	}

	private List<CostCenter> listCostCenters(Company company) {
		List<CostCenter> costCenters = new ArrayList<>();

		for (int i = 0; i < (int) (Math.random() * (costCenterAddress.length - 1)) + 1; i++) {
			costCenters.add(createCostCenter(costCenterAddress[i],
					phoneNumbers[i], company));
		}

		return costCenters;
	}

	private CostCenter createCostCenter(String address, String phoneNumber,
			Company company) {
		CostCenter costCenter = new CostCenter();

		costCenter.setAddress(address);
		costCenter.setPhoneNumber(phoneNumber);
		costCenter.setCompany(company);

		return costCenter;
	}

	private List<Department> listDepartments(Company company) {
		List<Department> departments = new ArrayList<>();

		for (int i = 0; i < (int) (Math.random() * departmentNames.length - 1) + 1; i++) {
			departments.add(createDepartment(departmentNames[i],
					descriptions[i], company));
		}

		return departments;
	}

	private Department createDepartment(String name, String description,
			Company company) {
		Department department = new Department();

		department.setCompany(company);
		department.setName(name);
		department.setDescription(description);

		return department;
	}

	private List<Company> listCompanies() {
		List<Company> companies = new ArrayList<>();

		for (int i = 0; i < companyNames.length; i++) {
			companies.add(createCompany(companyNames[i], rifs[i],
					descriptions[i]));
		}

		return companies;
	}

	private Company createCompany(String name, String rif, String description) {
		Company company = new Company();

		company.setCompanyName(name);
		company.setDescription(description);
		company.setRif(rif);

		return company;
	}

	private List<Post> listPost(List<Department> departments,
			List<CostCenter> costCenters) {

		List<Post> posts = new ArrayList<>();
		ArrayList<String> names = new ArrayList<String>(
				Arrays.asList(postNames));

		for (Department department : departments) {
			// System.out.println("\tDepartment: " + department.getName());
			int maxPost = (int) (Math.random() * (names.size() - 1)) + 1;
			// System.out.println("\tMax Posts: " + maxPost);

			for (int i = 0; i < maxPost; i++) {
				posts.add(createPost(
						(String) names.remove((int) (Math.random() * names
								.size())), department, costCenters));
			}

			names = new ArrayList<String>(Arrays.asList(postNames));
		}

		return posts;
	}

	private Post createPost(String name, Department department,
			List<CostCenter> costCenters) {
		Post post = new Post();
		int i = (int) (Math.random() * (costCenters.size() - 1)) + 1;

		post.setName(name);
		post.setCostCenters(costCenters.subList(0, i));
		post.setDepartment(department);
		post.setDescription(descriptions[(int) (Math.random() * descriptions.length)]);
		// System.out.println("\t\tPost: " + name);

		return post;

	}

	private Consult saveConsult(Consult consult) {

		/*
		 * System.out.println("Guardando una Consulta\t" +
		 * consult.getConsultDate() + " (" + consult.getPatient().getId() +
		 * ")");
		 */
		Consult newConsult = consult;
		SoapNote soapNote = consult.getSoapNote();
		List<VitalSign> vitalSigns = new ArrayList<>();
		// List<VitalSign> vitalSigns = consult.getVitalSigns(), newVitalSigns =
		// new ArrayList<>();

		try {
			consult.setSoapNote(soapNoteRepository.saveAndFlush(soapNote));
			newConsult = consultRepository.saveAndFlush(consult);

			for (Exam exam : consult.getRequestExams()) {
				exam.setOrdered(newConsult);
				saveExam(exam);
			}
			vitalSigns = consult.getVitalSigns();
			saveVitalSigns(newConsult, vitalSigns);
		} catch (NullPointerException ex) {
			System.out.println("Error de nulidad");
			if (vitalSigns != null)
				System.out.println("Nulidad en la lista de vitalsigns");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("\t\t\tError en el guardado de la consulta");
		}

		soapNote.setConsult(newConsult);
		newConsult.setSoapNote(soapNote);

		/*
		 * for (VitalSign vitalSign : vitalSigns) {
		 * vitalSign.setConsult(newConsult);
		 * System.out.println("Guardando Vital Signs. " + vitalSign.getName() +
		 * ", " + vitalSign.getDescripion()); System.out.println("Consulta: " +
		 * vitalSign.getConsult().getId());
		 * 
		 * VitalSign newVitalSign = vitalSignRepository
		 * .saveAndFlush(vitalSign); newVitalSigns.add(newVitalSign); }
		 * 
		 * newConsult.setVitalSigns(newVitalSigns);
		 */
		return newConsult;
	}

	private void saveVitalSigns(Consult consult, List<VitalSign> vitalSigns)
			throws NullPointerException {
		// System.out.println("\t\tConsulta: " +consult.getId());
		for (VitalSign vitalSign : vitalSigns) {
			// System.out.println("\t\tVitalSign: "+
			// vitalSign.getConsult().getId() + "\t"+ vitalSign.getName() + "\t"
			// + vitalSign.getDescripion());
			vitalSign.setConsult(consult);
			vitalSign = vitalSignRepository.save(vitalSign);
			// System.out.println("\t\tId: "+ vitalSign.getId());
			vitalSignRepository.flush();
		}
	}

	private Exam saveExam(Exam exam) {
		return examRepository.saveAndFlush(exam);
	}

	private List<Exam> listExams() {
		List<Exam> exams = new ArrayList<>();
		int cota = (int) (Math.random() * 2);

		for (int i = 0; i < cota; i++) {
			exams.add(createExam(examNames[(int) (Math.random() * examNames.length)]));
		}

		return exams;
	}

	private Exam createExam(String name) {
		Exam exam = new Exam();
		exam.setType(name);
		return exam;
	}

	private List<Consult> listConsults(Doctor doctor) {

		List<Consult> consults = new ArrayList<>();
		Consult newConsult = new Consult();

		int cota = ((int) (Math.random() * 15)) + 5;

		for (int i = 0; i < cota; i++) {
			newConsult = createConsult();
			newConsult.setDoctor(doctor);
			consults.add(newConsult);
		}

		return consults;
	}

	private Consult createConsult() {

		// System.out.println("Creando una Consulta");
		Consult consult = new Consult();

		long semanaEnMilis = 604800000, diaEnMilis = 86400000, horaEnMilis = 3600000;
		Date today = new Date(), consultDate, dia, hora, semana;

		semana = new Date((long) (Math.random() * 12) * semanaEnMilis);
		dia = new Date((long) (Math.random() * 30) * diaEnMilis);
		hora = new Date((long) (Math.random() * 24) * horaEnMilis);

		consultDate = new Date(today.getTime() - semana.getTime()
				- dia.getTime() - hora.getTime());

		consult.setConsultDate(consultDate);
		// System.out.println(consultDate.toString());
		consult.setSoapNote(createSoapNote());
		consult.setVitalSigns(listVitalSigns(consult));
		consult.setRequestExams(listExams());

		// consult.setVitalSigns(listVitalSigns());

		return consult;
	}

	private SoapNote createSoapNote() {

		SoapNote soapNote = new SoapNote();
		soapNote.setObjective(objectives[(int) (Math.random() * objectives.length)]);
		soapNote.setSubjective(subjectives[(int) (Math.random() * subjectives.length)]);
		soapNote.setPlan(plans[(int) (Math.random() * plans.length)]);
		soapNote.setComments(comments[(int) (Math.random() * comments.length)]);

		return soapNote;

	}

	private List<VitalSign> listVitalSigns(Consult consult) {
		List<VitalSign> vitalSigns = new ArrayList<>();
		Set<String> vitalSignsSet = new TreeSet<>();

		vitalSignsSet.addAll(Arrays.asList(vitalSignNames));
		int cota = (int) (Math.random() * vitalSignNames.length) % 7;
		Iterator<String> it = vitalSignsSet.iterator();

		for (int i = 0; i < cota && it.hasNext(); i++) {
			VitalSign vitalSign = createVitalSign(it.next());
			vitalSign.setConsult(consult);
			vitalSigns.add(vitalSign);
			// System.out.println(vitalSignNames[i]);
		}

		return vitalSigns;
	}

	private VitalSign createVitalSign(String name) {
		VitalSign vitalSign = new VitalSign();
		vitalSign.setName(name);
		vitalSign.setDescription("NADA");
		return vitalSign;
	}
}

package com.hxplus.occupational.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.Allergy;
import com.hxplus.occupational.model.Background;
import com.hxplus.occupational.model.Company;
import com.hxplus.occupational.model.CostCenter;
import com.hxplus.occupational.model.Department;
import com.hxplus.occupational.model.Doctor;
import com.hxplus.occupational.model.Habit;
import com.hxplus.occupational.model.History;
import com.hxplus.occupational.model.Patient;
import com.hxplus.occupational.model.Post;
import com.hxplus.occupational.model.User;
import com.hxplus.occupational.model.Vaccine;
import com.hxplus.occupational.model.VitalSign;
import com.hxplus.occupational.repositories.AllergyRepository;
import com.hxplus.occupational.repositories.BackgroundRepository;
import com.hxplus.occupational.repositories.CompanyRepository;
import com.hxplus.occupational.repositories.CostCenterRepository;
import com.hxplus.occupational.repositories.DepartmentRepository;
import com.hxplus.occupational.repositories.DoctorRepository;
import com.hxplus.occupational.repositories.HabitRepository;
import com.hxplus.occupational.repositories.HistoryRepository;
import com.hxplus.occupational.repositories.PatientRepository;
import com.hxplus.occupational.repositories.PostRepository;
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
	VitalSignRepository vitalSignRepository;
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
	HistoryRepository historyRepository;
	@Autowired
	BackgroundRepository backgroundRepository;
	@Autowired
	AllergyRepository allergyRepository;
	@Autowired
	VaccineRepository vaccineRepository;
	@Autowired
	HabitRepository habitRepository;

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

			descriptions = {
					"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,",
					"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto",
					"Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in l",
					"Y, viéndole don Quijote de aquella manera, con muestras de tanta tristeza, le dijo: Sábete, Sancho, que no es un hombre más que otro si no hace más que otro. Todas estas borrascas.",
					"Reina en mi espíritu una alegría admirable, muy parecida a las dulces alboradas de la primavera, de que gozo aquí con delicia. Estoy solo, y me felicito de vivir en este país, el m",
					"Una mañana, tras un sueño intranquilo, Gregorio Samsa se despertó convertido en un monstruoso insecto. Estaba echado de espaldas sobre un duro caparazón y, al alzar la cabeza, vio.",
					"Muy lejos, más allá de las montañas de palabras, alejados de los países de las vocales y las consonantes, viven los textos simulados. Viven aislados en casas de letras, en la costa" },

			nombres = { "Sol", "Pescado", "Yodo", "Maquillaje", "Jabón",
					"Champú", "Polem", "Penicilina" },

			severidades = { "Leve", "Moderada", "Severa", "Aguda", "Mortal" },

			habitNames = { "Cigarrillo", "Alcohol", "Deportes", "Trasnocho" },
			habitFrecuency = { "Varias veces al día", "Diario", "Semanal",
					"Quincenal", "Mensual", "Bimensual", "Anual" },

			vaccineNames = { "Polio", "Sarampión", "Viruela", "Triple",
					"Lechina" }, vaccinePotency = { "Primera", "Segunda",
					"Refuerzo" };

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

	public List<VitalSign> initVitalSigns() {
		List<VitalSign> vitalSigns = listVitalSigns();
		vitalSignRepository.save(vitalSigns);
		vitalSignRepository.flush();
		return vitalSigns;
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
			guardados.add(savePatient(patient));
		}

		return guardados;
	}
	

	private Patient savePatient(Patient patient) {

		try {
			Patient patientResp = new Patient();

			Background background = backgroundRepository.save(patient
					.getHistory().getBackground());

			History history = new History();
			history.setBackground(background);
			history = historyRepository.save(history);

			List<Allergy> allergies = patient.getHistory().getAllergies(), newAllergies = new ArrayList<>();
			List<Habit> habits = patient.getHistory().getHabits(), newHabits = new ArrayList<>();
			List<Vaccine> vaccines = patient.getHistory().getVaccines(), newVaccines = new ArrayList<>();

			for (Allergy allergy : allergies) {
				allergy.setHistory(history);
				newAllergies.add(allergyRepository.saveAndFlush(allergy));
			}

			history.setAllergies(newAllergies);

			for (Habit habit : habits) {
				habit.setHistory(history);
				newHabits.add(habitRepository.saveAndFlush(habit));
			}

			history.setHabits(newHabits);

			for (Vaccine vaccine : vaccines) {
				vaccine.setHistory(history);
				newVaccines.add(vaccineRepository.saveAndFlush(vaccine));
			}

			history.setVaccines(newVaccines);

			patientResp.setUser(patient.getUser());
			patientResp.setDoctors(patient.getDoctors());
			patientResp.setHistory(history);

			patientResp = patientRepository.saveAndFlush(patientResp);

			return patientResp;

		} catch (Exception ex) {
			// System.out.println("Ocurrió una excepción pero pa'lante");
			return patientRepository.saveAndFlush(patient);
		}
	}
	

	private List<Patient> listPatients(Long idDoctor) {
		ArrayList<Patient> patients = new ArrayList<>();
		List<User> users = userRepository.findAll();
		Doctor doctor = doctorRepository.findOne(idDoctor);

		for (long i = idDoctor + 1; i < 10 + idDoctor; i++) {
			patients.add(createPatient(
					users.remove((int) (Math.random() * users.size() - 1) + 1),
					doctor));
		}

		return patients;
	}
	

	private Patient createPatient(User user, Doctor doctor) {
		Patient patient;

		// System.out.println("idUser:\t\t" + idUser + "\nidDoctor:\t" +
		// idDoctor + "\n\t\t (" + idUser + ", " + idDoctor + ")");
		patient = patientRepository.findByUser(user.getId());

		if (patient == null) {
			// System.out.println("El paciente es nulo");

			patient = new Patient();
			patient.setUser(user);
			ArrayList<Doctor> patientListDoctors = new ArrayList<>();
			patientListDoctors.add(doctor);
			patient.setDoctors(patientListDoctors);
			patient.setHistory(createHistory());

		} else {
			// System.out.println("El paciente NO es nulo");

			List<Doctor> patientListDoctors = doctorRepository
					.listDoctorbyPatient(patient.getId());
			patientListDoctors.add(doctor);
			patient.setDoctors(patientListDoctors);
		}

		// System.out.println(patient.toString());

		return patient;
	}
	

	private History createHistory() {
		History history = new History();
		history.setBackground(createBackground());

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

		history.setAllergies(allergies);
		history.setHabits(habits);
		history.setVaccines(vaccines);

		return history;
	}
	

	private Background createBackground() {
		Background background = new Background();

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
	
	private List<VitalSign> listVitalSigns(){
		List<VitalSign> vitalSigns = new ArrayList<>();
		
		for(int i = 0; i < vitalSignNames.length ; i ++){
			vitalSigns.add(createVitalSign(vitalSignNames[i]));
		}
		
		return vitalSigns;
	}
	
	private VitalSign createVitalSign(String name){
		VitalSign vitalSign = new VitalSign();
		vitalSign.setName(name);
		vitalSign.setDescripion(descriptions[(int)(Math.random()*descriptions.length)]);
		return vitalSign;
	}
}

package com.hxplus.occupational.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.Allergy;
import com.hxplus.occupational.model.Background;
import com.hxplus.occupational.model.Doctor;
import com.hxplus.occupational.model.Habit;
import com.hxplus.occupational.model.History;
import com.hxplus.occupational.model.Patient;
import com.hxplus.occupational.model.User;
import com.hxplus.occupational.model.Vaccine;
import com.hxplus.occupational.repositories.AllergyRepository;
import com.hxplus.occupational.repositories.BackgroundRepository;
import com.hxplus.occupational.repositories.DoctorRepository;
import com.hxplus.occupational.repositories.HabitRepository;
import com.hxplus.occupational.repositories.HistoryRepository;
import com.hxplus.occupational.repositories.PatientRepository;
import com.hxplus.occupational.repositories.UserRepository;
import com.hxplus.occupational.repositories.VaccineRepository;

@Service
public class InitServiceImpl implements InitService {

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

	private final String[] descriptions = {
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
			
			habitNames = { "Cigarrillo", "Alcohol", "Deportes", "Trasnocho"},
			habitFrecuency = { "Varias veces al día", "Diario", "Semanal", "Quincenal", "Mensual", "Bimensual" , "Anual"},
			
			vaccineNames = {"Polio", "Sarampión", "Viruela", "Triple", "Lechina"},
			vaccinePotency = {"Primera", "Segunda", "Refuerzo"};

	@Override
	public List<Object> init() {
		List<User> userList = listUsers();
		List<Object> objList = new ArrayList<>();

		userRepository.save(userList);
		userRepository.flush();
		objList.addAll(userList);
		System.out
				.println("······································Usuarios Guardados······································");
		List<Doctor> doctorList = listDoctors(Long.valueOf(userList.size()));
		doctorRepository.save(doctorList);
		doctorRepository.flush();
		objList.addAll(doctorList);
		System.out
				.println("······································Doctores Guardados······································");
		ArrayList<Patient> patientList = (ArrayList<Patient>) listPatients(Long.valueOf(1));
		objList.addAll(savePatients(patientList));
		System.out
				.println("······································Primera lista de pacientes Guardados······································");
		patientList = (ArrayList<Patient>) listPatients(Long.valueOf(7));
		objList.addAll(savePatients(patientList));
		System.out
				.println("······································Pacientes Guardados······································");

		return objList;
	}
	
	private List<Patient> savePatients(List<Patient> patients){
		List<Patient> guardados = new ArrayList<>();
		
		for(Patient patient : patients){
			guardados.add(savePatient(patient));
		}
		
		return guardados;
	}
	
	private Patient savePatient(Patient patient){
		
		try{
			Patient patientResp = new Patient();

			Background background = backgroundRepository.save(patient
					.getHistory().getBackground());

			History history = new History();
			history.setBackground(background);
			history = historyRepository.save(history);

			List<Allergy> allergies = patient.getHistory().getAllergies(), newAllergies = new ArrayList<>();
			List<Habit> habits = patient.getHistory().getHabits(), newHabits = new ArrayList<>();
			List<Vaccine> vaccines = patient.getHistory().getVaccines(), newVaccines = new ArrayList<>();
		
			for(Allergy allergy : allergies){
				allergy.setHistory(history);
				newAllergies.add(allergyRepository.saveAndFlush(allergy));
			}
			
			history.setAllergies(newAllergies);
			
			for(Habit habit : habits){
				habit.setHistory(history);
				newHabits.add(habitRepository.saveAndFlush(habit));
			}
			
			history.setHabits(newHabits);
			
			for(Vaccine vaccine: vaccines){
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
			System.out.println("Ocurrió una excepción pero pa'lante");
			return patientRepository.saveAndFlush(patient);
		}
	}

	private List<Patient> listPatients(Long idDoctor) {
		ArrayList<Patient> patients = new ArrayList<>();

		for (long i = idDoctor + 1; i < 10 + idDoctor; i++) {
			patients.add(createPatient(Long.valueOf(i), idDoctor));
		}

		return patients;
	}

	private Patient createPatient(Long idUser, Long idDoctor) {
		Patient patient;

		// System.out.println("idUser:\t\t" + idUser + "\nidDoctor:\t" +
		// idDoctor + "\n\t\t (" + idUser + ", " + idDoctor + ")");
		patient = patientRepository.findByUser(idUser);

		if (patient == null) {
			System.out.println("El paciente es nulo");

			patient = new Patient();
			patient.setUser(userRepository.findOne(idUser));
			ArrayList<Doctor> patientListDoctors = new ArrayList<>();
			patientListDoctors.add(doctorRepository.findOne(idDoctor));
			patient.setDoctors(patientListDoctors);
			patient.setHistory(createHistory());

		} else {
			System.out.println("El paciente NO es nulo");

			List<Doctor> patientListDoctors = doctorRepository
					.listDoctorbyPatient(patient.getId());
			patientListDoctors.add(doctorRepository.findOne(idDoctor));
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
		
		for (int i = 0; i < vaccinesCant; i++){
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

	private Allergy createAllergy(){
		Allergy allergy = new Allergy();
		
		allergy.setName(nombres[(int)(Math.random()*nombres.length)]);
		allergy.setSeverity(severidades[(int)(Math.random()*severidades.length)]);
		
		return allergy;
	}

	private Habit createHabit() {
		Habit habit = new Habit();

		habit.setName(habitNames[(int)(Math.random()*habitNames.length)]);
		habit.setFrecuency(habitFrecuency[(int)(Math.random()*habitFrecuency.length)]);

		return habit;
	}
	
	private Vaccine createVaccine(){
		Vaccine vaccine = new Vaccine();
		
		vaccine.setName(vaccineNames[(int)(Math.random()*vaccineNames.length)]);
		vaccine.setPotency(vaccinePotency[(int)(Math.random()*vaccinePotency.length)]);
		
		return vaccine;
	}

	private List<Doctor> listDoctors(Long size) {

		List<Doctor> doctors = new ArrayList<>();

		Doctor doctor = createDoctor(Long.valueOf(1));
		doctorRepository.save(doctor);

		for (Long i = Long.valueOf(2); i <= size / 4; i++) {
			doctors.add(createDoctor(i));
		}

		return doctors;
	}

	private Doctor createDoctor(Long id) {

		Doctor doctor = new Doctor();

		doctor.setUser(userRepository.findOne(id));
		doctor.setRegNumber((Long.valueOf(String.valueOf((int) (Math.random() * 20000000)))));

		return doctor;
	}

	private List<User> listUsers() {
		List<User> users = new ArrayList<User>();
		String[] firstnames = { "Juan", "Jose", "Alberto", "Pedro", "Carlos",
				"Julio", "Fernando", "Daniel" }, lastnames = { "Perez",
				"Lopez", "Mendez", "Ramirez" }, passwords = { "4242", "2121",
				"6363", "8484" };
		User ale = createUser("Alejandro", "Tarazona", "atarazona", "4242");
		ale.setId(Long.valueOf(1));
		users.add(ale);

		for (int i = 0; i < firstnames.length; i++) {
			for (int k = 0; k < lastnames.length; k++) {
				users.add(createUser(firstnames[i], lastnames[k],
						firstnames[i].substring(0, 2) + lastnames[k],
						passwords[k]));
			}
		}

		return users;
	}

	private User createUser(String firstname, String lastname, String username,
			String password) {
		User user = new User();
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setEmail(username + "@hxplus.com");
		user.setUsername(username);
		user.setPassword(password);
		user.setAddress("Caracas");
		return user;
	}

}

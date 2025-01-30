package wipro.day3.Hospital.v1;
//Base class for common properties
class User {
 protected String name;
 protected String email;
 protected String phone;

 public User(String name, String email, String phone) {
     this.name = name;
     this.email = email;
     this.phone = phone;
 }
}

//Patient class
class Patient extends User {
 private String medicalHistory;

 public Patient(String name, String email, String phone, String medicalHistory) {
     super(name, email, phone);
     this.medicalHistory = medicalHistory;
 }

 public void bookAppointment(String doctorName) {
     System.out.println(name + " booked an appointment with Dr. " + doctorName);
 }

 public void viewMedicalHistory() {
     System.out.println(name + "'s Medical History: " + medicalHistory);
 }

 public void makePayment(double amount) {
     System.out.println(name + " made a payment of $" + amount);
 }
}

//Doctor class
class Doctor extends User {
 private String specialization;

 public Doctor(String name, String email, String phone, String specialization) {
     super(name, email, phone);
     this.specialization = specialization;
 }

 public void viewAppointments() {
     System.out.println("Dr. " + name + " is viewing their daily appointments.");
 }

 public void accessPatientRecords(Patient patient) {
     System.out.println("Dr. " + name + " (Specialization: " + specialization + ") is accessing medical history of " + patient.name);
 }
}

//Admin class
class Admin extends User {
 public Admin(String name, String email, String phone) {
     super(name, email, phone);
 }

 public void manageUserData() {
     System.out.println(name + " is managing user data.");
 }

 public void generateReports() {
     System.out.println(name + " is generating reports.");
 }
}

//Main class to test the system
public class HospitalManagementSystem {
 public static void main(String[] args) {
     // Create instances of users
     Patient patient = new Patient("Wow", "Wow@WEPRO.com", "1234567890", "Diabetes, Hypertension");
     Doctor doctor = new Doctor("Nut", "Nut@hospital.com", "0987654321", "Cardiology");
     Admin admin = new Admin("DEV", "dev@admin.com", "1112223333");

     // Patient actions
     patient.bookAppointment(doctor.name);
     patient.viewMedicalHistory();
     patient.makePayment(100.50);

     // Doctor actions
     doctor.viewAppointments();
     doctor.accessPatientRecords(patient);

     // Admin actions
     admin.manageUserData();
     admin.generateReports();
 }
}
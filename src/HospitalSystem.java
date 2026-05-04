import  java.util.*;
import java.io.*;
public class HospitalSystem {
    private ArrayList<User> allUsers = new ArrayList<>();
    private ArrayList<Patient> patients  = new ArrayList<>();
    private ArrayList<Doctor> doctors  = new ArrayList<>();
    private ArrayList<Appointment> appointments  = new ArrayList<>();

    public void intialize(){
        System.out.println("Hospital System Initalizing...");
        loadAllData();
        System.out.println("Done.");

    }
    public void loadAllData(){
        loadUsers();
        loadDoctors();
        loadPatients();
        loadAppointments();
    }
private void loadUsers(){
        try {
            Scanner input = new Scanner(new File("users.txt"));
            while (input.hasNextLine()) {
                String line = input.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] p = line.split(",");
                String role = p[4].trim();
                if(role.equals("Admin")){
                    allUsers.add(new Admin(p[0],p[1],p[2],p[3]));
                }
            }
            input.close();
            System.out.println("Users loaded Done.");
        }catch(FileNotFoundException e) {
            System.out.println("users.txt not found");
        }}
    private void loadDoctors() {
        try {
            Scanner input = new Scanner(new File("doctors.txt"));
            while (input.hasNextLine()) {
                String line = input.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] p = line.split(",");
                Doctor d = new Doctor(p[0], p[1], p[2],p[3], p[4], p[5],p[6]);
                doctors.add(d);
                allUsers.add(d);
            }
            input.close();
            System.out.println(" Doctors loaded Done.");
        } catch (FileNotFoundException e) {
            System.out.println("doctors.txt not found");
        }
    }
    private void loadPatients() {
        try {
            Scanner input = new Scanner(new File("patients.txt"));
            while (input.hasNextLine()) {
                String line = input.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] p = line.split(",");
                Patient pt= new Patient(p[0], p[1], p[2], p[3],p[4], p[5], p[6]);
                patients.add(pt);
                allUsers.add(pt);
            }
            input.close();
            System.out.println("Patients loaded Done.");
        } catch (FileNotFoundException e) {
            System.out.println("Patients.txt not found");
        }
    }
    private void loadAppointments() {
        try {
            Scanner input = new Scanner(new File("appointments.txt"));
            while (input.hasNextLine()) {
                String line = input.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] p = line.split(",");
                Appointment a= new Appointment(p[0], p[1], p[2], p[4], p[5]);
                appointments.add(a);

            }
            input.close();
            System.out.println("Appointments loaded Done.");
        } catch (FileNotFoundException e) {
            System.out.println("appointments.txt not found");
        }
    }
    public User login(String username, String password) {
        for (User user : allUsers){
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
    public void redirectMenu(User user, Scanner input){
     if (user instanceof Admin) showAdminMenu((Admin) user, input);
     else if (user instanceof Doctor) {
         showDoctorMenu((Doctor)user,input);
     } else if (user instanceof Patient) {
         showPatientMenu((Patient)user,input);

     }
    }
    private void showAdminMenu(Admin user, Scanner input){
        int choice = 0;
        while(choice!=12){
            System.out.println("1.Add Doctor");
            System.out.println("2.Add Patient");
            System.out.println("3.Assign patient to doctor");
            System.out.println("4.Create Appointment");
            System.out.println("5.View All Doctors");
            System.out.println("6.View All Patients");
            System.out.println("7.View All Appointments");
            System.out.println("8.Search Patient by ID");
            System.out.println("9.Search Doctor by ID");
            System.out.println("10. Generate Reports");
            System.out.println("11.Save Data");
            System.out.println("12. Exit");
            System.out.println("Enter your choice");
            choice = input.nextInt();
            input.nextLine();
        }
    }
    private void showDoctorMenu(Doctor doctor, Scanner input){
        int choice = 0;
        while(choice!=5){
            System.out.println("1. View my profile");
            System.out.println("2. View Assigned Patients");
            System.out.println("3. View my Appointments");
            System.out.println("4. Update Appointment status");
            System.out.println("5. Exit");
            System.out.println("Enter your choice");
            choice = input.nextInt();
            input.nextLine();
        }
    }
    private void showPatientMenu(Patient patient, Scanner input){
        int choice = 0;
        while(choice!=6){
            System.out.println("1. View my profile");
            System.out.println("2. View Assigned Doctors");
            System.out.println("3. View my Appointments");
            System.out.println("4. Book Appointment");
            System.out.println("5. Cancel Appointment");
            System.out.println("5. Exit");
            System.out.println("Enter your choice");
            choice = input.nextInt();
            input.nextLine();
        }
    }
    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }
    public ArrayList<Patient> getPatients() {
        return patients;
    }
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }
    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    }
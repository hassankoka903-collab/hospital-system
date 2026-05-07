import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Doctor extends User{
        static  Scanner input = new Scanner(System.in);
  private String specialization;
    private String department;
    private long phone;
    private ArrayList<Patient> assignedPatients = new ArrayList<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();
    // Constructor
    public Doctor(int id, String name, String username, String password,String specialization, String department, long phone) {
super(id, name, username, password);
this.specialization = specialization;
        this.department = department;
        this.phone = phone;}
  // METHOD1:VIEW PROFILE
    public void viewProfile() {
        System.out.println("Doctor ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
        System.out.println("Department: " + department);
        System.out.println("Phone: " + phone);}
  //METHOD2:VIEW PATIENTS
    public void viewAssignedPatients() {
        if (assignedPatients.isEmpty()) {
            System.out.println("No assigned patients.");
            return;
        }
        for (Patient p : assignedPatients) {
            System.out.println(p.getId() + " - " + p.getName());
        }
    }
    // METHOD3:VIEW APPOINTMENTS
    public void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments.");
            return;
        }
        for (Appointment a : appointments) {
            System.out.println(a);
        }
    }
    //METHOD4:UPDATE STATUS 
    public void updateAppointmentStatus(String appointmentId, String newStatus) {
        for (Appointment a : appointments) {

            if (a.getAppointmentId().equals(appointmentId)) {
                // Validation
                if (a.getStatus().equals("Cancelled") && newStatus.equals("Completed")) {
                    System.out.println("Cannot complete cancelled appointment");
                    return;}
                a.setStatus(newStatus);
                System.out.println("Status updated successfully!");
                return;
            }
        }
        System.out.println("This Appointment not found!");}
  //ADDING NEW PATIENT
    public void addPatient(Patient p) {
        assignedPatients.add(p);
    }
    public void addAppointment(Appointment a) {
        appointments.add(a);
    }
    
public static void DoctorMenu(Doctor doc) {
    int choice;
    do {
        System.out.println("\n=== Doctor Menu ===");
        System.out.println("1. View Profile");
        System.out.println("2. View Patients");
        System.out.println("3. View Appointments");
        System.out.println("4. Update Appointment");
        System.out.println("5. Logout");
        choice = input.nextInt();
        switch (choice) {
            case 1:
                doc.viewProfile();
                break;
            case 2:
                doc.viewAssignedPatients();
                break;
            case 3:
                doc.viewAppointments();
                break;
            case 4:
                System.out.print("Enter Appointment ID: ");
                String id = input.next();
                System.out.print("Enter New Status: ");
                String status = input.next();
                doc.updateAppointmentStatus(id, status);
                break;


        }
    } while (choice != 5);
}

    public void Display() {
        throw new UnsupportedOperationException("Not supported yet."); }

    String getDepartment() {
        throw new UnsupportedOperationException("Not supported yet.");  }

    String getSpecialization() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    Object getPhone() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}

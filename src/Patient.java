public class Patient extends User {

    public Patient(int id, String name, String username, int password) {
        super(id, name, username, password);
    }

    @Override
    public void Display() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}

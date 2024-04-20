public class Professor extends Person{

    private float Salary=0.0f;

    public Professor(String name, String phone_number, String email_address, float Salary) {
        super(name, phone_number, email_address);
        this.Salary= Salary;
    }

    public Professor(String name, String phone_number, String email_address) {
        super(name, phone_number, email_address);
    }

    

}

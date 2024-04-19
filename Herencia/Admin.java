public class Admin extends Person{
    
    private String admin_id="";
    private String departament= "";

    public Admin(String user_name, String last_name, String document, String gender, String admin_id, String departament){
        super(user_name, last_name, document, gender);
        this.admin_id = admin_id;
        this.departament = departament;
    }

    public String getDeparment() {
        return departament;
    }

    public String getAdmin_id() {
        return admin_id;
    } 

    @Override
    public String toString(){
        return super.toString() + "\n Departamento: "+ departament + "\n Amdin ID: " + admin_id;
    }
}

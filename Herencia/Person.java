public class Person{
    protected String user_name="";
    protected String last_name="";
    protected String document="";
    protected String gender="";


    Person(String user_name, String last_name, String document, String gender){
        this.user_name=user_name;
        this.last_name=last_name;
        this.document=document;
        this.gender=gender;
    }


    public String getUser_name() {
        return user_name;
    }


    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }


    public String getLast_name() {
        return last_name;
    }


    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


    public String getDocument() {
        return document;
    }


    public void setDocument(String document) {
        this.document = document;
    }


    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "Username: " + user_name + " Lastname: " + last_name + " Document: " + document + " Gender: "
                + gender;
    }

    

}
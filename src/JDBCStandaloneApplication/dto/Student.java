package JDBCStandaloneApplication.dto;

public class Student {

    private int sid;
    private String name;
    private String email;
    private String city;
    private String country;

    public Student() {
        System.out.println("Student Object Created.");
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getSid() {
        return sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String toString() {
        return "Student [sid: "+sid+"\nname: "+name+"\nemail: "+email+"\ncity: "+city+"\ncountry: "+country+"]";
    }
}

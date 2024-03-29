package czy.bean;

public class User {


    private int id;
    private String username;
    private String password;
    private String gender;
    private String address;

    private Integer age;

    public User(String s) {
        this.username = s;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User(String username, String address, Integer age){
        this.username = username;
        this.address  = address;
        this.age = age;
    }
}

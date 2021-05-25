package hr.java.covid_tracker.login;

public class LoginDTO {

    private final String username;
    private final String password;
    private final Type role;

    public LoginDTO(String username, String password, Type role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public LoginDTO(Login login){
        this.username = login.getUsername();
        this.password = login.getPassword();
        this.role = login.getRole();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Type getRole() {
        return role;
    }

    @Override
    public String toString(){
        return "LoginDTO{"+
                "username='" + username + '\'' +
                ", role=" + role +
                '}';
    }

}

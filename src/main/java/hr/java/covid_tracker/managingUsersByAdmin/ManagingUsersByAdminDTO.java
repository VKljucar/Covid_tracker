package hr.java.covid_tracker.managingUsersByAdmin;

public class ManagingUsersByAdminDTO {

    private final String username;
    private final String password;


    public ManagingUsersByAdminDTO(ManagingUsersByAdmin managingUsersByAdmin) {

        this.username = managingUsersByAdmin.getUsername();
        this.password = managingUsersByAdmin.getPassword();

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public String toString() {

        return "ManagingUsersByAdminDTO{" + '\'' +
                "username: " + username + '\'' +
                "password: " + password +
                "}";


    }
}

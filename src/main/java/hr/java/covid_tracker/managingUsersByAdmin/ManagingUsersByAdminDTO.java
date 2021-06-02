package hr.java.covid_tracker.managingUsersByAdmin;

import hr.java.covid_tracker.login.Type;

public class ManagingUsersByAdminDTO {

    private final String username;
    private final String password;
    private final Type role;

    public ManagingUsersByAdminDTO(ManagingUsersByAdmin managingUsersByAdmin) {

        this.username = managingUsersByAdmin.getUsername();
        this.password = managingUsersByAdmin.getPassword();
        this.role = managingUsersByAdmin.getRole();

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
    public String toString() {

        return "ManagingUsersByAdminDTO{" + '\'' +
                "username: " + username + '\'' +
                "password: " + password + '\'' +
                "role: " + role + '\'' +
                "}";


    }
}

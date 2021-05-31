package hr.java.covid_tracker.managingUsersByAdmin;

import hr.java.covid_tracker.login.Type;

import javax.validation.constraints.NotBlank;

public class ManagingUsersByAdminCommand {

    @NotBlank(message = "ID must not be empty")
    private Long id;

    @NotBlank(message = "First name must not be empty")
    private String firstName;

    @NotBlank(message = "Last name must not be empty")
    private String lastName;

    @NotBlank(message = "Username must not be empty")
    private String username;

    @NotBlank(message = "Password must not be empty")
    private String password;

    @NotBlank(message = "Role must not be empty")
    private Type role;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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
}

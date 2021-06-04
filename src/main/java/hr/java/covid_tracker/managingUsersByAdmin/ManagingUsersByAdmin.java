package hr.java.covid_tracker.managingUsersByAdmin;

import hr.java.covid_tracker.login.Login;
import hr.java.covid_tracker.login.Type;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

public class ManagingUsersByAdmin {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        private String firstname;
        private String lastname;
        private String username;
        private String password;
        private Type role;

        @ManyToMany(targetEntity = ManagingUsersByAdmin.class)
        @JoinTable(
                name = "korisnici",
                joinColumns = { @JoinColumn(name = "id")},
                inverseJoinColumns = {@JoinColumn(name = "id")}
        )

        private List<ManagingUsersByAdmin> managingUsersByAdminList;

        public ManagingUsersByAdmin(int id, String firstname, String lastname, String username, String password, Type role) {
            this.id = id;
            this.firstname = firstname;
            this.lastname = lastname;
            this.username = username;
            this.password = password;
            this.role = role;
        }

        public ManagingUsersByAdmin(ManagingUsersByAdminCommand managingUsersByAdminCommand) {

        this.firstname = managingUsersByAdminCommand.getFirstName();
        this.lastname = managingUsersByAdminCommand.getLastName();
        this.username = managingUsersByAdminCommand.getUsername();
        this.password = managingUsersByAdminCommand.getPassword();
        this.role = managingUsersByAdminCommand.getRole();
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirstname() {
            return firstname;
        }

        public String getLastname() {
            return lastname;
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ManagingUsersByAdmin)) return false;
            ManagingUsersByAdmin ManagingUsersByAdmin = (hr.java.covid_tracker.managingUsersByAdmin.ManagingUsersByAdmin) o;
            return firstname.equals(ManagingUsersByAdmin.firstname) && lastname.equals(ManagingUsersByAdmin.lastname) && username.equals(ManagingUsersByAdmin.username) && password.equals(ManagingUsersByAdmin.password) && role.equals(ManagingUsersByAdmin.role);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, firstname, lastname, username, password, role);
        }
    }

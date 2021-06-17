package hr.java.covid_tracker.managingUsersByAdmin;

import hr.java.covid_tracker.cijepljeni.Cijepljeni;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "KORISNICI")
public class ManagingUsersByAdmin {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;

        @Column(name = "IME")
        private String firstname;

        @Column(name = "PREZIME")
        private String lastname;

        @Column(name = "KORISNICKO_IME")
        private String username;

        @Column(name = "LOZINKA")
        private String password;


        @OneToMany(mappedBy = "managingUsersByAdmin")
        private List<Cijepljeni> cijepljeni;

//        @ManyToMany(targetEntity = ManagingUsersByAdmin.class)
//        @JoinTable(
//                name = "korisnici",
//                joinColumns = { @JoinColumn(name = "id")},
//                inverseJoinColumns = {@JoinColumn(name = "id")}
//        )

        //private List<ManagingUsersByAdmin> managingUsersByAdminList;

        public ManagingUsersByAdmin(int id, String firstname, String lastname, String username, String password) {
            this.id = id;
            this.firstname = firstname;
            this.lastname = lastname;
            this.username = username;
            this.password = password;
        }

        public ManagingUsersByAdmin(ManagingUsersByAdminCommand managingUsersByAdminCommand) {

        this.firstname = managingUsersByAdminCommand.getFirstName();
        this.lastname = managingUsersByAdminCommand.getLastName();
        this.username = managingUsersByAdminCommand.getUsername();
        this.password = managingUsersByAdminCommand.getPassword();
        }

    public ManagingUsersByAdmin() {

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ManagingUsersByAdmin)) return false;
            ManagingUsersByAdmin ManagingUsersByAdmin = (hr.java.covid_tracker.managingUsersByAdmin.ManagingUsersByAdmin) o;
            return firstname.equals(ManagingUsersByAdmin.firstname) && lastname.equals(ManagingUsersByAdmin.lastname) && username.equals(ManagingUsersByAdmin.username) && password.equals(ManagingUsersByAdmin.password);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, firstname, lastname, username, password);
        }
    }


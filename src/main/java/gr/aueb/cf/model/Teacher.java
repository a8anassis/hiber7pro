package gr.aueb.cf.model;

import jakarta.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    //@Column(name = "firstname", length = 255, unique = false, nullable = true)
    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    // private Set<Course> courses;

    public Teacher() {

    }

    public Teacher(Long id, String firstname, String lastname) {
        Id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}

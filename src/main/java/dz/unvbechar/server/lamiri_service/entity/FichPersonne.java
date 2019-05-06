package dz.unvbechar.server.lamiri_service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FichPersonne {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(length = 25)
    private  String first_name;
    @Column(length = 25)
    private String last_name;
    @Column(length = 25)
    private String age;
    @Column(length = 25)
    private String  date_of_birth;
    private char sexe;
    @Column(length = 25)
    private String privacy_tag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public String getPrivacy_tag() {
        return privacy_tag;
    }

    public void setPrivacy_tag(String privacy_tag) {
        this.privacy_tag = privacy_tag;
    }

    public void setSexe() {
    }
}

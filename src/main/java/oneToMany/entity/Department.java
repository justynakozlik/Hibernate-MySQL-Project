package oneToMany.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_department")
    private Integer idDepartment;

    @Column(name = "city")
    private String city;

    @Column(name = "field_of_study_number")
    private Integer fieldOfStudyNumber;

    @OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST)
    private Set<FieldOfStudy> fieldsOfStudy;

    public Department() {
    }

    public Department(String city, Integer fieldOfStudyNumber) {
        this.city = city;
        this.fieldOfStudyNumber = fieldOfStudyNumber;
    }

    public Integer getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Integer idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getFieldOfStudyNumber() {
        return fieldOfStudyNumber;
    }

    public void setFieldOfStudyNumber(Integer fieldOfStudyNumber) {
        this.fieldOfStudyNumber = fieldOfStudyNumber;
    }

    public Set<FieldOfStudy> getFieldsOfStudy() {
        return fieldsOfStudy;
    }

    public void setFieldsOfStudy(Set<FieldOfStudy> fieldsOfStudy) {
        this.fieldsOfStudy = fieldsOfStudy;
    }

    @Override
    public String toString() {
        return "Department{" +
                "idDepartment=" + idDepartment +
                ", city='" + city + '\'' +
                ", fieldOfStudyNumber=" + fieldOfStudyNumber +
                ", fieldsOfStudy=" + fieldsOfStudy +
                '}';
    }
}

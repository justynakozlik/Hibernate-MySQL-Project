package oneToManyOneWay.entity;

import javax.persistence.*;
import java.util.HashSet;
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

    @Column(name = "name")
    private String name;

    @Column(name = "field_of_study_number")
    private Integer fieldOfStudyNumber;

    @OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST)
    private Set<FieldOfStudy> fieldsOfStudy;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_department")
    private Set<Laboratory> laboratories;

    public Department() {
    }

    public Department(String city, String name, Integer fieldOfStudyNumber) {
        this.city = city;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Laboratory> getLaboratories() {
        return laboratories;
    }

    public void setLaboratories(Set<Laboratory> laboratories) {
        this.laboratories = laboratories;
    }

    public void addFieldOfStudy(FieldOfStudy fieldOfStudy) {
        if (fieldsOfStudy == null) {
            fieldsOfStudy = new HashSet<FieldOfStudy>();
        }
        fieldsOfStudy.add(fieldOfStudy);
        fieldOfStudy.setDepartment(this);
    }

    public void addLaboratory(Laboratory laboratory) {
        if (laboratories == null) {
            laboratories = new HashSet<Laboratory>();
        }
        laboratories.add(laboratory);
    }

    @Override
    public String toString() {
        return "Department{" +
                "idDepartment=" + idDepartment +
                ", city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", fieldOfStudyNumber=" + fieldOfStudyNumber +
                ", fieldsOfStudy=" + fieldsOfStudy +
                ", laboratories=" + laboratories +
                '}';
    }
}
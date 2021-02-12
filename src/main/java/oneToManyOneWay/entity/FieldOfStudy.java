package oneToManyOneWay.entity;

import javax.persistence.*;

@Entity
@Table(name = "field_of_study")
public class FieldOfStudy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_field_of_study")
    private Integer idFieldOfStudy;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_department")
    private Department department;

    public FieldOfStudy(){}

    public FieldOfStudy(String name) {
        this.name = name;
    }

    public Integer getIdFieldOfStudy() {
        return idFieldOfStudy;
    }

    public void setIdFieldOfStudy(Integer idFieldOfStudy) {
        this.idFieldOfStudy = idFieldOfStudy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "FieldOfStudy{" +
                "idFieldOfStudy=" + idFieldOfStudy +
                ", name='" + name + '\'' +
                ", department=" + department +
                '}';
    }
}


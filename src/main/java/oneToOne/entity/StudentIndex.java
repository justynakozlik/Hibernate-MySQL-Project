package oneToOne.entity;

import javax.persistence.*;

@Entity
@Table(name = "student_index")
public class StudentIndex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student_index")
    private Integer idStudentIndex;

    @Column(name = "number")
    private Integer number;

    @OneToOne(mappedBy = "studentIndex", cascade = CascadeType.ALL)
    private Student student;

    public StudentIndex(){}

    public StudentIndex(Integer number) {
        this.number = number;
    }

    public Integer getIdStudentIndex() {
        return idStudentIndex;
    }

    public void setIdStudentIndex(Integer idStudentIndex) {
        this.idStudentIndex = idStudentIndex;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "StudentIndex{" +
                "idStudentIndex=" + idStudentIndex +
                ", number=" + number +
                ", student=" + student +
                '}';
    }
}

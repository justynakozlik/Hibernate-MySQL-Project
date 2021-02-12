package oneToManyOneWay.entity;

import javax.persistence.*;

@Entity
@Table(name = "laboratory")
public class Laboratory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_laboratory")
    private Integer idLaboratory;

    @Column(name = "name")
    private String name;

    public Laboratory(){}

    public Laboratory(String name) {
        this.name = name;
    }

    public Integer getIdLaboratory() {
        return idLaboratory;
    }

    public void setIdLaboratory(Integer idLaboratory) {
        this.idLaboratory = idLaboratory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Laboratory{" +
                "idLaboratory=" + idLaboratory +
                ", name='" + name + '\'' +
                '}';
    }
}

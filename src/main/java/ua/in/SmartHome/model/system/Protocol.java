package ua.in.SmartHome.model.system;

import javax.persistence.*;

@Entity
@Table(name = "Protocol")
public class Protocol {


    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    public Protocol() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

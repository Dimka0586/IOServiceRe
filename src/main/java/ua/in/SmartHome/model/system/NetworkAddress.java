package ua.in.SmartHome.model.system;

import javax.persistence.*;

@Entity
@Table(name = "NetworkAddress")
public class NetworkAddress {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "address")
    private String address;

    public NetworkAddress() {
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

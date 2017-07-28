package ua.in.SmartHome.model.system;

import javax.persistence.*;

@Entity
@Table(name = "IOServer")
public class IOServer {


    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    private NetworkAddress networkAddress;

    @Column(name = "comment")
    private String comment;

    public IOServer() {
    }

    public int getId() {
        return id;
    }

    public NetworkAddress getNetworkAddress() {
        return networkAddress;
    }

    public void setNetworkAddress(NetworkAddress networkAddress) {
        this.networkAddress = networkAddress;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

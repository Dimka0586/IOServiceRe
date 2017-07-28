package ua.in.SmartHome.model.system;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Entity
@Table(name = "IODevice")
public class IODevice {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Protocol protocol;

    @ManyToOne(fetch = FetchType.EAGER)
    private Port port;

    @ManyToOne(fetch = FetchType.EAGER)
    private IOServer ioServer;

    public IODevice() {
    }

    public int getId() {
        return id;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    public IOServer getIoServer() {
        return ioServer;
    }

    public void setIoServer(IOServer ioServer) {
        this.ioServer = ioServer;
    }
}

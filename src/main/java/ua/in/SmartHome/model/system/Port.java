package ua.in.SmartHome.model.system;

import javax.persistence.*;

@Entity
@Table(name = "Port")
public class Port {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "BaudRate")
    private int BaudRate;

    @Column(name = "DataBit")
    private byte dataBit;

    @Column(name = "StopBit")
    private byte stopBit;

    @Column(name = "Parity")
    private byte parity;

    @Column(name = "Encoding")
    private String encoding;

    @Column(name = "Echo")
    private boolean echo;

    @Column(name = "comment")
    private String comment;

    public Port() {
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

    public int getBaudRate() {
        return BaudRate;
    }

    public void setBaudRate(int baudRate) {
        BaudRate = baudRate;
    }

    public byte getDataBit() {
        return dataBit;
    }

    public void setDataBit(byte dataBit) {
        this.dataBit = dataBit;
    }

    public byte getStopBit() {
        return stopBit;
    }

    public void setStopBit(byte stopBit) {
        this.stopBit = stopBit;
    }

    public byte getParity() {
        return parity;
    }

    public void setParity(byte parity) {
        this.parity = parity;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public boolean isEcho() {
        return echo;
    }

    public void setEcho(boolean echo) {
        this.echo = echo;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

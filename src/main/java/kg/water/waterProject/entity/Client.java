package kg.water.waterProject.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {
    @Id
    private Long id;

    private String lchet;

    private String fio;

    private String address;

    private Boolean isActive;

    public Client() {
    }

    public Client(Long id, String lchet, String fio, String address, Boolean isActive) {
        this.id = id;
        this.lchet = lchet;
        this.fio = fio;
        this.address = address;
        this.isActive = isActive;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getLchet() {
        return lchet;
    }

    public void setLchet(String lchet) {
        this.lchet = lchet;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}

package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Customer {
    @Id
    private int Cid;
    private String name;
    @OneToMany(mappedBy = "customer")
    private Set<Address> address;

    public Customer() {

    }

    public Customer(int cid, String name, Set<Address> address) {
        Cid = cid;
        this.name = name;
        this.address = address;
    }

    public int getCid() {
        return Cid;
    }

    public void setCid(int cid) {
        Cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }

}

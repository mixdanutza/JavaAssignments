
package com.daniela.Licenses.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
@Table(name="persons")
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    @Size(min = 2, max = 20)
    private String firstname;
    @Size(min=2, max = 25)
    private String lastname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }
    @CreationTimestamp
    private Date createdat;
    @UpdateTimestamp
    private Date updatedat;
    @OneToOne(mappedBy = "person", fetch=FetchType.LAZY)
    private License license;

    public Person(){

    }
    public Person(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
        this.createdat = new Date();
        this.updatedat = new Date();
    }

}

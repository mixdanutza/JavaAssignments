package com.daniela.Licenses.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by dusty on 7/20/17.
 */
@Entity
@Table(name = "licenses")
public class License {
    @Id
    @GeneratedValue
    private Long id;

    private String number;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date expiration;
    private String state;
    @CreationTimestamp
    private Date createdat;
    @UpdateTimestamp
    private Date updatedat;
    @OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;
    public License(){
        this.number = String.format("%06d", this.id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public void setUpdatedAt(Date updatedat) {
        this.updatedat = updatedat;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
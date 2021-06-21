package com.jacobroe.DriversLicense.models;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="licenses")
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;
    private String state;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;
    
    //Constructors
    public License() {

    }

    public License(Long id, String number, Date expirationDate, String state, Person person) {
        this.id = id;
        this.number = number;
        this.expirationDate = expirationDate;
        this.state = state;
        this.person = person;
    }

    //Getters and Setters
    public void setId(Long id) {
    	this.id = id;
    }
    
    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }
    
	public void setNumber(String number) {
		this.number = number;
	}

    public void setState(String state) {
    	this.state = state;
    }

    public void setExpirationDate(Date expirationDate) {
    	this.expirationDate = expirationDate ;
    }
    
    public Date getExpirationDate() {
    	return expirationDate;
    }
    
    public void setPerson(Person person) {
    	this.person = person;
    }
    
    public Person getPerson() {
    	return person;
    }
    
    public String getState() {
        return state;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
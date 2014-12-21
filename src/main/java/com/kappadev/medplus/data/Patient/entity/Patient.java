/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kappadev.medplus.data.Patient.entity;

import com.kappadev.medplus.data.DB.DISEASE.entity.Disease;
import com.kappadev.medplus.data.DB.states.States;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Tomasz
 */
@Entity
@Table(name = "Patient")
public class Patient {

    @Id
    @Column(name = "peselId", precision = 11, scale = 0, unique = true, nullable = false)
    private long pesel_id; //THIS IS ID IN DATABASE

    @Column(name = "name", nullable = true, length = 100)
    private String name;

    @Column(name = "secondName", nullable = true, length = 100)
    private String secondName;

    @Column(name = "surname", nullable = true, length = 100)
    private String surname;

    @Column(name = "street", nullable = true, length = 200)
    private String street;

    @Column(name = "houseNo", nullable = true, length = 10)
    private String houseNo;

    @Column(name = "flat", nullable = true, length = 10)
    private String flat;

    @Column(name = "city", nullable = true, length = 100)
    private String city;

    @Column(name = "postCode", nullable = true, length = 6)
    private String postCode;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "state", referencedColumnName = "Id")
    private States state;

    @Column(name = "phone", length = 50, nullable = true)
    private String phone;

    private boolean selected;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "disease", referencedColumnName = "Id")
    private Disease disease;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the secondName
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * @param secondName the secondName to set
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the houseNo
     */
    public String getHouseNo() {
        return houseNo;
    }

    /**
     * @param houseNo the houseNo to set
     */
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    /**
     * @return the flat
     */
    public String getFlat() {
        return flat;
    }

    /**
     * @param flat the flat to set
     */
    public void setFlat(String flat) {
        this.flat = flat;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the postCode
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * @param postCode the postCode to set
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * @return the state
     */
    public States getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(States state) {
        this.state = state;
    }

    /**
     * @return the pesel_id
     */
    public long getPesel_id() {
        return pesel_id;
    }

    /**
     * @param pesel_id the pesel_id to set
     */
    public void setPesel_id(long pesel_id) {
        this.pesel_id = pesel_id;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" ");
        sb.append(surname);
        sb.append(" ");
        sb.append("PESEL: ");
        sb.append(pesel_id);
        return sb.toString();
    }

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setDiseaseId(Disease disease) {
        this.disease = disease;
    }

    public Disease getDisease() {
        return disease;
    }
}
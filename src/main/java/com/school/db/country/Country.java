/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.db.country;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Salah Atwa
 */
@Entity  
@Table(name = "COUNTRIES_NAME")

@ManagedBean(name = "country" ,eager = true)
@SessionScoped
public class Country implements Serializable {
    
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO) 
    @Column(name = "rec_id" , nullable = false ,length = 255 ) 
    private long rec_id;
    
    @Column(name = "country_name")
    private String countryName; 
    
//    @ManagedProperty(value = "#{city}")
    @OneToMany(fetch = FetchType.EAGER ,targetEntity = State.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id" )
    private Set<State> cities=new LinkedHashSet();

    public Country() {
    }

    
    

    /**
     * @return the countryName
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * @param countryName the countryName to set
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * @return the cities
     */
    public Set<State> getCities() {
        return cities;
    }

    /**
     * @param cities the cities to set
     */
    public void setCities(Set<State> cities) {
        this.cities = cities;
    }

    /**
     * @return the rec_id
     */
    public long getRec_id() {
        return rec_id;
    }

    /**
     * @param rec_id the rec_id to set
     */
    public void setRec_id(long rec_id) {
        this.rec_id = rec_id;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.db.school;

import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Salah Atwa
 */
@Entity
@Table(name = "Rows_OF_Stage")

@ManagedBean (name = "rowsOFStage")
@SessionScoped
public class RowsOFStage implements Serializable {
    
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO) 
    @Column(name = "id" , nullable = false) 
    private Long id;
    
    @Column(name = "row_name")
    private String rowName;

    public RowsOFStage() {
    }

    public RowsOFStage(String rowName) {
        this.rowName = rowName;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the rowName
     */
    public String getRowName() {
        return rowName;
    }

    /**
     * @param rowName the rowName to set
     */
    public void setRowName(String rowName) {
        this.rowName = rowName;
    }
    
    
}

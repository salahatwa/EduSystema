/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.db.school;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
@Table(name = "STAGE")
@ManagedBean(name = "stage")
@SessionScoped
public class Stage implements Serializable {
    
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO) 
    @Column(name = "id" , nullable = false) 
    private long id;
    
    @Column(name = "stage_name" , nullable = false)
    private String stageName;
    
    @Column(name = "stage_year" ,nullable = false)
    private String stageYear;
    
    
    @OneToMany(fetch = FetchType.EAGER,targetEntity = RowsOFStage.class ,cascade = CascadeType.ALL)
    @JoinColumn(name = "stage_id")
    private List<RowsOFStage> stageRowses;
    
    

    public Stage() {
        stageRowses = new ArrayList<>();
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the stageName
     */
    public String getStageName() {
        return stageName;
    }

    /**
     * @param stageName the stageName to set
     */
    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    /**
     * @return the stageYear
     */
    public String getStageYear() {
        return stageYear;
    }

    /**
     * @param stageYear the stageYear to set
     */
    public void setStageYear(String stageYear) {
        this.stageYear = stageYear;
    }

  

    
    
    
    /**
     * @return the stageRowses
     */
    public List<RowsOFStage> getStageRowses() {
       return stageRowses;
    }

    /**
     * @param stageRowses the stageRowses to set
     */
    public void setStageRowses(List<RowsOFStage> stageRowses) {
        this.stageRowses = stageRowses;
    }
    
    public List<RowsOFStage> getAllRows(Stage stage) {
         if(stage!=null)
              return stage.getStageRowses();
          else
              return null;     
    }
    
    public void addRow() {
       
        RowsOFStage rowsOFStage=new RowsOFStage();
        if(!stageRowses.contains(rowsOFStage))
        { stageRowses.add(rowsOFStage);
        }
         System.out.println("ADD ROW FOR STAGE ..");
    }
    
    public void removeRow(RowsOFStage rowsOFStage)
    {
        System.err.println("#$$$$$$:REMOVE:"+rowsOFStage.getRowName());
        stageRowses.remove(rowsOFStage);
    }
    
    
    
}

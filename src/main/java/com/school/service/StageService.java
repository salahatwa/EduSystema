/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.service;

import com.school.db.school.Stage;
import com.school.dao.StageDAO;
import com.school.dao.StageImplement;
import com.school.db.school.RowsOFStage;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Salah Atwa
 */
@ManagedBean(name = "stageService")
@SessionScoped
public class StageService implements Serializable {

    private StageDAO stageDAO;

    @ManagedProperty(value = "#{stage}")
    private Stage stage;

    public StageService() {
        stageDAO = new StageImplement();
    }

    public void addStage() {
        getStageDAO().insertStage(getStage());
//       List<RowsOFStage> ls= getStage().getStageRowses();
//       
//        for (RowsOFStage rowsOFStage : ls) {
//           System.err.println(rowsOFStage.getRowName()); 
//        }
        getStage().getStageRowses().clear();
        getStage().setStageName("");
        getStage().setStageYear("2017");
//        setStage(null);
        
    }

    public void saveStage(Stage stage) {
        getStageDAO().updateStage(stage);
    }

    public void deleteStage(Stage stage) {
        getStageDAO().deleteStage(stage);
    }

    public List<Stage> getAllStages() {
        return getStageDAO().getAllStages();
    }

    public void addRow() {
        System.out.println("ADD ROW FOR STAGE ..");
        stage.getStageRowses().add(new RowsOFStage());

    }

    public void removeRow(Stage stage, RowsOFStage rowsOFStage) {
        this.stage = stage;
        this.stage.getStageRowses().remove(rowsOFStage);
    }

    public List<RowsOFStage> getAllRows(Stage stage) {
      
        return getStageDAO().getAllRows(stage);
    }

    /**
     * @return the stageDAO
     */
    public StageDAO getStageDAO() {
        return stageDAO;
    }

    /**
     * @param stageDAO the stageDAO to set
     */
    public void setStageDAO(StageDAO stageDAO) {
        this.stageDAO = stageDAO;
    }

    /**
     * @return the stage
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * @param stage the stage to set
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

}

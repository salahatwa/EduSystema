/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.dao;

import com.school.db.school.RowsOFStage;
import com.school.db.school.Stage;
import com.school.db.setting.HibernateDriver;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;

/**
 *
 * @author Salah Atwa
 */
public class StageImplement implements StageDAO {

    private final HibernateDriver hibernateDriver = HibernateDriver.getInstance();

    @Override
    public List<Stage> getAllStages() {
        List<Stage> stages = null;
        try {
            hibernateDriver.openSession();
            String sql = "SELECT * FROM STAGE";
            SQLQuery query = hibernateDriver.getSession().createSQLQuery(sql);
            query.addEntity(Stage.class);
            stages = query.list();

            System.out.println("NUM OF STAGES:" + stages.size());
            hibernateDriver.closeSession();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return stages;
    }

    @Override
    public void insertStage(Stage stage) {

        try {
            hibernateDriver.openSession();
            hibernateDriver.getSession().save(stage);
            System.out.println("STAGE ADDED SUCCESSFULY");
            hibernateDriver.closeSession();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteStage(Stage stage) {
        hibernateDriver.openSession();
//      Stage stage =(Stage)hibernateDriver.getSession().get(Stage.class, EmployeeID); 
        hibernateDriver.getSession().delete(stage);
        hibernateDriver.closeSession();
    }

    @Override
    public void updateStage(Stage stage) {
        hibernateDriver.openSession();
        hibernateDriver.getSession().update(stage);
        hibernateDriver.closeSession();
    }
    
    /**
     * *****************************************************************************************************
     * **************************************** ROW OPERATION *******************************************************
     * *****************************************************************************************************
     * @param stage
     * @return 
     */

    @Override
    public List<RowsOFStage> getAllRows(Stage stage) {

        hibernateDriver.openSession();

        String sql = "SELECT * FROM Rows_OF_Stage WHERE stage_id= :stageID";
        SQLQuery query = hibernateDriver.getSession().createSQLQuery(sql);
        query.addEntity(RowsOFStage.class);
        query.setParameter("stageID", stage.getId());
        List<RowsOFStage> results = query.list();

        hibernateDriver.closeSession();

        return results;
    }

    @Override
    public void insertRow(RowsOFStage rowsOFStage) {
      hibernateDriver.openSession();
      hibernateDriver.getSession().save(rowsOFStage);
      hibernateDriver.closeSession();
    }

    @Override
    public void deleteRow(RowsOFStage rowsOFStage) {
    
    }

    @Override
    public void updateRow(RowsOFStage rowsOFStage) {
    
    }

}

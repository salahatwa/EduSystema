/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.dao;

import com.school.db.setting.HibernateDriver;
import com.school.db.user.Student;
import com.school.db.user.Stuff;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;

/**
 *
 * @author Salah Atwa
 */
public class UserImplement implements UserDAO, Serializable {

    private final HibernateDriver hibernateDriver = HibernateDriver.getInstance();

   //***********************************Admin****************************************
    @Override
    public void deleteUser(Stuff user) {
        hibernateDriver.openSession();
        hibernateDriver.getSession().delete(user);
        hibernateDriver.closeSession();
    }

    @Override
    public Stuff getUser(String userEmail, String userPassword) {
        Stuff user = null;
        try {
            hibernateDriver.openSession();

            String getUserSql = "Select u.REC_ID , u.USER_TYPE ,u.JOIN_DATE,u.FAMILY_INFO_ID,u.PERSONAL_INFO_ID,u.CLASS_ID,u.STAGE_ID from USERS u INNER JOIN PERSONAL_INFO p ON p.EMAIL= :userEmail and p.PASSWORD= :userPassword";
            SQLQuery query = hibernateDriver.getSession().createSQLQuery(getUserSql);
            query.addEntity(Stuff.class);
            query.setResultTransformer(Criteria.PROJECTION);
            query.setParameter("userEmail", userEmail);
            query.setParameter("userPassword", userPassword);
            user = (Stuff) query.uniqueResult();

            hibernateDriver.closeSession();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return user;
    }

    @Override
    public void updateUser(Stuff user) {
        hibernateDriver.openSession();
        hibernateDriver.getSession().update(user);
        hibernateDriver.closeSession();
    }
//******************************* Student *****************************************************
    @Override
    public void addStudent(Student student) {
        hibernateDriver.openSession();
        hibernateDriver.getSession().save(student);
        hibernateDriver.closeSession();
    }

    @Override
    public List<Student> getAllStudents() {
        hibernateDriver.openSession();
        String sql = "SELECT * FROM USERS where USER_TYPE='Student' order by JOIN_DATE asc";
        SQLQuery query = hibernateDriver.getSession().createSQLQuery(sql);
        query.addEntity(Student.class);
        List<Student> students = query.list();
        hibernateDriver.closeSession();
        return students;
    }

    @Override
    public void updateStudent(Student student) {
        hibernateDriver.openSession();
        hibernateDriver.getSession().update(student);
        hibernateDriver.closeSession();

    }

    @Override
    public void deleteStudent(Student student) {
        hibernateDriver.openSession();
        hibernateDriver.getSession().delete(student);
        hibernateDriver.closeSession();
    }

}

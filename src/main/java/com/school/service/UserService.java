/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.service;

import com.school.db.user.Stuff;
import com.school.dao.UserDAO;
import com.school.dao.UserImplement;
import com.school.db.user.Student;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Salah Atwa
 */
@ManagedBean(name = "userService")
@SessionScoped
public class UserService implements Serializable {

    private UserDAO userDAO;

    @ManagedProperty(value = "#{stuff}")
    private Stuff stuff;
    
    @ManagedProperty(value = "#{student}")
    private Student student;

  
    /**
     * Creates a new instance of UserService
     */
    public UserService() {
        userDAO = new UserImplement();
    }

    /**
     * Login method by userEmail and password
     *
     * @return
     */
    public String login() {
        //?faces-redirect=true
        String viewID = null;
        stuff=userDAO.getUser(stuff.getPersonalInfo().getEmail(), stuff.getPersonalInfo().getPassword());

        if (stuff != null) {
            switch (stuff.getUser_type()) {
                case "Admin":
                    viewID = "admin?faces-redirect=true";
                    System.out.println(stuff.getId()+"\t"+stuff.getPersonalInfo().getFname() + "Admin success Login");
                    break;
                case "Student":
                    viewID = "student?faces-redirect=true";
                    break;
                case "Teacher":
                    viewID = "teacher?faces-redirect=true";
                    break;
                default:
                    FacesMessage msg
                            = new FacesMessage("Error email or password",
                                    "Invalid credentails");
                    msg.setSeverity(FacesMessage.SEVERITY_ERROR);

                    FacesContext.getCurrentInstance().addMessage("loginBTN", msg);
                    viewID = "login?faces-redirect=true";
            }
        }

        return viewID;
    }
    
   
  //************************ ADMIN OPERATION *****************************************
    public void updateStuff(Stuff stuff)
    {
        getUserDAO().updateUser(stuff);
    }

    public void deleteStuff(Stuff stuff)
    {
       getUserDAO().deleteUser(stuff);
    }
    
  //************************* Student Operation *****************************************
    
    public void addStudent()
    {
       getUserDAO().addStudent(student);
    }
    
    public void updateStudent(Student student)
    {
        getUserDAO().updateStudent(student);
    }
    
    public void deleteStudent(Student student)
    {
        getUserDAO().deleteStudent(student);
    }
    
    public List<Student> getAllStudents()
    {
        return getUserDAO().getAllStudents();
    }
    /**
     * @return the userDAO
     */
    public UserDAO getUserDAO() {
        return userDAO;
    }

    /**
     * @param userImplement
     */
    public void setUserDAO(UserImplement userImplement) {
        this.userDAO = userImplement;
    }

    /**
     * @return the stuff
     */
    public Stuff getStuff() {
        return stuff;
    }

    /**
     * @param stuff the stuff to set
     */
    public void setStuff(Stuff stuff) {
        this.stuff = stuff;
    }

    /**
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }


   

}

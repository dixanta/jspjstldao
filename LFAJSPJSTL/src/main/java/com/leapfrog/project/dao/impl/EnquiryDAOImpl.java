/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.project.dao.impl;

import com.leapfrog.project.dao.EnquiryDAO;
import com.leapfrog.project.dbutil.DbConnection;
import com.leapfrog.project.entity.Enquiry;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author USER
 */
public class EnquiryDAOImpl implements EnquiryDAO {

    private DbConnection db = new DbConnection();

    @Override
    public int insert(Enquiry e) throws ClassNotFoundException, SQLException {
        db.open();
        String sql = "INSERT INTO tbl_enquiries(first_name,last_name,email,contact_no,course_id) VALUES(?,?,?,?,?)";
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setString(1, e.getFirstName());
        stmt.setString(2, e.getLastName());
       stmt.setString(3, e.getEmail());
       stmt.setString(4, e.getContactNo());
       stmt.setInt(5, e.getCourse().getId());
       
        int result = db.update();
        e.setId(result);
        db.close();
        return result;
    }

    @Override
    public List<Enquiry> getAll() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Enquiry> getEnquiryWithCourse() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.project.dao;

import com.leapfrog.project.entity.Enquiry;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author USER
 */
public interface EnquiryDAO {
    int insert(Enquiry enquiry)throws ClassNotFoundException,SQLException;
    List<Enquiry> getAll()throws ClassNotFoundException,SQLException;
    List<Enquiry> getEnquiryWithCourse()throws ClassNotFoundException,SQLException;
}

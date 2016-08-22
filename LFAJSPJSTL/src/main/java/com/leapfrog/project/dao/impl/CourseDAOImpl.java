/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.project.dao.impl;

import com.leapfrog.project.dao.CourseDAO;
import com.leapfrog.project.dbutil.DbConnection;
import com.leapfrog.project.entity.Course;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class CourseDAOImpl implements CourseDAO {
    private DbConnection db=new DbConnection();

    @Override
    public int insert(Course c) throws ClassNotFoundException, SQLException {
        db.open();
        String sql="INSERT INTO tbl_courses(course_name,fees,status) VALUES(?,?,?)";
        PreparedStatement stmt=db.initStatement(sql);
        stmt.setString(1, c.getName());
        stmt.setInt(2, c.getFees());
        stmt.setBoolean(3, c.isStatus());
        int result=db.update();
        c.setId(result);
        db.close();
        return result;
    }

    @Override
    public List<Course> getAll(boolean showActive) throws ClassNotFoundException, SQLException {
        List<Course> courseList=new ArrayList<>();
        db.open();
        String sql="SELECT * FROM tbl_courses WHERE 1=1";
        
        if(showActive){
            sql +=" AND status=1";
        }
        
        
        PreparedStatement stmt=db.initStatement(sql);
        ResultSet rs=db.query();
        while(rs.next()){
            Course c=new Course();
            c.setId(rs.getInt("course_id"));
            c.setName(rs.getString("course_name"));
            c.setFees(rs.getInt("fees"));
            c.setAddedDate(rs.getDate("added_date"));
            c.setStatus(rs.getBoolean("status"));
            courseList.add(c);
        }
        db.close();
        return courseList;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.project.dao;

import com.leapfrog.project.entity.Course;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author USER
 */
public interface CourseDAO {
    int insert(Course c)throws ClassNotFoundException,SQLException;
    List<Course> getAll(boolean showActive)throws ClassNotFoundException,SQLException;
}

<%@page import="com.leapfrog.project.dao.impl.EnquiryDAOImpl"%>
<%@page import="com.leapfrog.project.dao.EnquiryDAO"%>
<%@page import="com.leapfrog.project.entity.Course"%>
<%@page import="com.leapfrog.project.entity.Enquiry"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="courseDAO" class="com.leapfrog.project.dao.impl.CourseDAOImpl"/>
<%
      if(request.getMethod().equalsIgnoreCase("post")){
          Enquiry enq=new Enquiry();
          enq.setFirstName(request.getParameter("first_name"));
          enq.setLastName(request.getParameter("last_name"));
          enq.setEmail(request.getParameter("email"));
          enq.setContactNo(request.getParameter("contact_no"));
          Course c=new Course();
          c.setId(Integer.parseInt(request.getParameter("course")));
          enq.setCourse(c);
          EnquiryDAO enquiryDAO=new EnquiryDAOImpl();
          try{
            enquiryDAO.insert(enq);
            response.sendRedirect("?success");
          
          }catch(Exception e){
              out.println(e.getMessage());
          }
      }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Enquiry</h1>
        <form action="" method="post">
            <div>
                <div>
                <label>
                    First Name
                    <input type="text" name="first_name" required="required"/>
                </label>
                </div>
                <div>
                <label>
                    Last Name
                    <input type="text" name="last_name" required="required"/>
                </label> </div>
                    <div>
                <label>
                    Email
                    <input type="email" name="email" required="required"/>
                </label>  </div>
                        <div>
                <label>
                    Contact No
                    <input type="text" name="contact_no" required="required"/>
                </label> </div>
                            <div>
                <label>
                    Course
                    <select name="course">
                        <option value="">Interested Course</option>
                        <c:forEach var="course" items="${courseDAO.getAll(true)}">
                        <option value="${course.id}">${course.name}</option>
                        </c:forEach>
                    </select>
                </label>  </div>
                <div>
                    <button type="submit">Send</button>
                </div>
            </div>
        </form>
    </body>
</html>

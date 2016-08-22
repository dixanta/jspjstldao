
<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="courseDAO" class="com.leapfrog.project.dao.impl.CourseDAOImpl"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>        
    </head>
    <body>
        <div class="container">
        <h1>Courses</h1>
        <table class="table">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Fees</th>
                <th>Added Date</th>
                <th>Status</th>
            </tr>
            <c:forEach var="course" items="${courseDAO.getAll(false)}">
                <tr>
                    <td>${course.id}</td>
                    <td>${course.name}</td>
                    <td>${course.fees}</td>
                    <td>${course.addedDate}</td>
                    <td>
                        <c:choose>
                        <c:when test="${course.status}">
                            Active
                        </c:when>
                        <c:otherwise>
                            Inactive
                        </c:otherwise>
                        </c:choose>
                        
                    </td>
                </tr>
            </c:forEach>
        </table>
        </div>
    </body>
</html>

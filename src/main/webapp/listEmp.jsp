<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Spring Security</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <div class="container text-right">
            <form action="/logout">
                <button type="submit" class="btn btn-danger">Logout</button>
            </form>
        </div>
        <div class="container text-left">
            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#employee">Employee +
            </button>
            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#role">UserRole +</button>
        </div>
        <hr>
        <h3>Employee List</h3><br>
        <form action="/employee/list" method="GET">
            <table class="table table-dark">
                <tr>
                    <th>ID</th>
                    <th>Employee Name</th>
                    <th>Department</th>
                    <th>Mobile No</th>
                    <th>Actions</th>
                </tr>
                <tbody>
                <c:forEach var="emp" items="${list}">
                <tr>
                <tr>
                    <td><c:out value="${emp.id}"/></td>
                    <td><c:out value="${emp.username}"/></td>
                    <td><c:out value="${emp.department}"/></td>
                    <td><c:out value="${emp.mobile_no}"/></td>
                    <td>
                        <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#edit">Edit
                        </button>
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delete">Delete
                        </button>
                    </td>
                <tr>
                    </c:forEach>
                </tbody>
            </table>
        </form>
    </div>
</div>
<form action="/employee/add" method="post">
    <div id="employee" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title">Add Employee</h3>
                </div>
                <div class="modal-body">
                    <span style="color: red">*</span><small>required</small><br>
                    <fieldset class="form-group">
                        <label>Employee Username (0-15 Characters)</label><span style="color: red">*</span>
                        <input type="text" class="form-control" name="username"
                               required="required" pattern="[A-Za-z\s]{0,15}"
                               placeholder="Enter the username">
                    </fieldset>
                    <fieldset class="form-group">

                        <label>Select Department</label> <input type="text" class="form-control"
                                                                name="department" list="department"
                                                                placeholder="--Select Department--">
                        <datalist id="department">
                            <option value="Technical">
                            <option value="Finance">
                            <option value="Marketing">
                            <option value="Transportation">
                            <option value="Human Resource">
                        </datalist>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Employee Mobile Number</label>
                        <input type="text" class="form-control" name="mobile_no"
                               pattern="[A-Za-z\s]{0,15}"
                               placeholder="Enter the Mobile Number">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Select UserRole</label> <form:select path="roleList"
                                                                    class="form-control form-control-sm">
                        <c:forEach items="${roleList}" var="roles">
                            <form:option value="${roles.role_id}">
                                ${roles.role_name}</form:option>
                        </c:forEach>
                    </form:select>
                    </fieldset>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>
</form>
</body>
</html>
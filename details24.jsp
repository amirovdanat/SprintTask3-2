<%@ page import="SprintTask24.Model24" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <%@include file="bootstrapLink.jsp"%>
</head>
<body>
<%@include file="head24.jsp"%>
<div class="container">
    <%
        Model24 dt=(Model24) request.getAttribute("taskDetail");
    %>

    <form action="/update24" method="post">
        <div class="modal-body">
            <input type="hidden" name="id" value="<%=dt.getId()%>">
            <label for="name">NAME</label>
            <input type="text" name="name" id="name" value="<%=dt.getName()%>"><br>
            <label for="description">DESCRIPTION</label>
            <textarea name="description" id="description" placeholder="<%=dt.getDescription()%>"></textarea> <br>
            <label for="deadlineDate">DEADLINE</label>
            <input type="date" name="deadlineDate" id="deadlineDate" value="<%=dt.getDeadlineDate()%>"><br>
            <label for="status">Status</label>
            <select id="status" name="status">
                <option value="true" <%if (dt.isStatus()){%>selected<%}%> >Yes</option>
                <option value="false" <%if (!dt.isStatus()){%>selected<%}%> >No</option>
            </select><br>
            <div style="display: flex">
                <div><button class="btn btn-primary">Update</button></div>
                <div><!-- Button trigger modal -->
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                        Delete
                    </button>


                </div>
            </div>
        </div>
    </form>

    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form action="/delete24" method="post">
                    <div class="modal-body">
                        <input type="hidden" name="deleteId" class="form-control" value="<%=dt.getId()%>">
                        Are u sure delete?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>
</body>
</html>

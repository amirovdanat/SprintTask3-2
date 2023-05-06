<%@ page import="java.util.ArrayList" %>
<%@ page import="SprintTask24.Model24" %>
<%@ page import="SprintTask24.DBManager24" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="bootstrapLink.jsp"%>
</head>
<body>
<%@include file="head24.jsp"%>
<div class="container">
    <!-- Кнопка-триггер модального окна -->
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
        + Add Task
    </button>

    <!-- Модальное окно -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="/add24" method="post">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">New Task</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Закрыть"></button>
                </div>
                <div class="modal-body">
                    <div>
                    <label class="form-control" for="name">NAME</label>
                    <input type="text" class="form-control" name="name" id="name"><br>
                    </div>
                    <div>
                    <label class="form-control" for="description">DESCRIPTION</label>
                    <textarea class="form-control"  name="description" id="description"></textarea><br>
                    </div>
                    <div>
                    <label class="form-control" for="deadlineDate">DEADLINE</label>
                    <input class="form-control" type="date" name="deadlineDate" id="deadlineDate">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Add</button>
                </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Deadline</th>
            <th scope="col">Status</th>
            <th scope="col">Details</th>
        </tr>
        </thead>
        <tbody>
        <%ArrayList<Model24> task= DBManager24.getAllDbm();
            for (int i = 0; i < task.size(); i++) {%>
                <tr>
            <th scope="row"><%=task.get(i).getId()%></th>
            <td><%=task.get(i).getName()%></td>
            <td><%=task.get(i).getDeadlineDate()%></td>
            <td><%if(task.get(i).isStatus()){
                            %>Yes<%
                    }else {
                            %>No<%
                    }%></td>
                    <td><a href="/details24?id_task=<%=task.get(i).getId()%>"><button>Details</button></a></td>
        </tr>
          <% }%>
        </tbody>
    </table>
</div>
</body>
</html>

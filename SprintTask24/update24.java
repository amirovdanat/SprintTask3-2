package SprintTask24;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/update24")
public class update24  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id=Long.parseLong(req.getParameter("id"));
        String name=req.getParameter("name");
        String description=req.getParameter("description");
        String deadlineDate=req.getParameter("deadlineDate");
        boolean status=Boolean.parseBoolean(req.getParameter("status"));

        Model24 obj=new Model24(id,name,description,deadlineDate,status);

        DBManager24.updateTask(id,obj);
        resp.sendRedirect("/sprintTask24");
    }
}

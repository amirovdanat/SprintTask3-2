package SprintTask24;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/add24")
public class addServlet24 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String description=req.getParameter("description");
        String deadlineDate=req.getParameter("deadlineDate");
        boolean status=Boolean.parseBoolean(req.getParameter("status"));

        Model24 obj=new Model24();
        obj.setName(name);
        obj.setDescription(description);
        obj.setDeadlineDate(deadlineDate);
        obj.setStatus(status);

        DBManager24.addTask(obj);

        resp.sendRedirect("/sprintTask24");

    }
}

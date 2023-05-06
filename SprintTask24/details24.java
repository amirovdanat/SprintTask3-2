package SprintTask24;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/details24")
public class details24 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        String id=req.getParameter("id_task");
        Long taskId=null;

        try {
            taskId=Long.parseLong(id);
        }catch (Exception e){
            e.printStackTrace();
        }

        Model24 details= DBManager24.getTask(taskId);
        req.setAttribute("taskDetail", details);

        if (details!=null){
            req.getRequestDispatcher("details24.jsp").forward(req,resp);
        }
    }
}

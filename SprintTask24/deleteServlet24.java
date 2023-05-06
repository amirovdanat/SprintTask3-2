package SprintTask24;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/delete24")
public class deleteServlet24 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id=req.getParameter("deleteId");
        Long idDelete=null;

        try {
            idDelete=Long.parseLong(id);
        }catch (Exception e){
            e.printStackTrace();
        }

        DBManager24.deleteTask(idDelete);

        resp.sendRedirect("/sprintTask24");
    }
}

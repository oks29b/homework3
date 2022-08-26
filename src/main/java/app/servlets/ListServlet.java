package app.servlets;

import app.entities.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("user");

        if(name == null){
            PrintWriter pw = resp.getWriter();
            pw.println("<html>");
            pw.println("<body>");
            pw.println("Access denied!");
            pw.println("</body>");
            pw.println("</html>");
        }else {

            Model model = Model.getInstance();
            List<String> names = model.list();
            req.setAttribute("userNames", names);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/list.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}

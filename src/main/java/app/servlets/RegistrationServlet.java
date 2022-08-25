package app.servlets;

import app.entities.Model;
import app.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistrationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/registration.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("pass");
        String repassword = req.getParameter("repass");

        PrintWriter pw = resp.getWriter();
        if (name.isEmpty() || password.isEmpty() || repassword.isEmpty()) {
            pw.println("<html>");
            pw.println("<body>");
            pw.println("Fill all fields!");
            pw.println("</body>");
            pw.println("</html>");

        } else if (!password.equals(repassword)) {
            pw.println("<html>");
            pw.println("<body>");
            pw.println("Access denied!");
            pw.println("</body>");
            pw.println("</html>");

        } else {
            User user = new User(name, password);
            Model model = Model.getInstance();
            model.add(user);

            req.setAttribute("userName", name);
            doGet(req, resp);
        }
    }
}

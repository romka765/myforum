package servlets;
import classes.User;
import utils.Checker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Checker checker = new Checker();
        String userName= req.getParameter("userName");
        String password = req.getParameter("password");
        if (checker.isEmpty(userName)){
            System.out.println("1");
            User user = User.Users.userByName(userName);
            if(user != null && user.getPassword().equals(password)){
                System.out.println("2");
                req.setAttribute("userName", userName);
                req.getRequestDispatcher("/main.jsp").forward(req, resp);
                }
                else {
                    System.out.println("else1");
                    req.getRequestDispatcher("/index.jsp").forward(req, resp);
                }
        }
        else {
            System.out.println("else3");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}

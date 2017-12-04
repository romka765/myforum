package servlets;

import classes.User;
import utils.Checker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Checker checker = new Checker();

        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");
        String eMail = req.getParameter("eMail");
        if (checker.isEmpty(userName) && User.Users.userByName(userName) == null){
            System.out.println("1");
            if(checker.isEMail(eMail)&& User.Users.userByEMail(eMail)== null){
                System.out.println("2");
                if(checker.isEmpty(password) && password.equals(password2)){
                    System.out.println("3");
                    User.Users.addUser(new User(userName,eMail,password));
                    req.setAttribute("userName", userName);
                    req.getRequestDispatcher("/main.jsp").forward(req,resp);
                }
            }
        }
        else {
            System.out.println("no if");
            req.getRequestDispatcher("/index.jsp");
            //todo сообщение об ошибке
        }
    }
}

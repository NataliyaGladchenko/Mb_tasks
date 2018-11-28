package servlet;

import model.Users;
import repository.UsersRepository;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;


public class UserServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        UsersRepository usersRepository = new UsersRepository();
        List<Users> usersList = null;

        usersList = usersRepository.getAllUsers();
        PrintWriter printWriter = resp.getWriter();
        for (Users users : usersList) {
            printWriter.print(users.getUserName() + "      ");
            printWriter.println(users.getPasportData());
        }


    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        UsersRepository usersRepository = new UsersRepository();
        usersRepository.addUser(req.getParameter("name"),req.getParameter("pasport"));
//        usersRepository.deleteUser(req.getParameter("user_name"));
    }
}

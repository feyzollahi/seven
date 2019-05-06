package controller;

import model.Exceptions.DupEndorse;
import model.Exceptions.UserNotFound;
import model.Repo.GetRepo;
import model.Repo.UsersRepo;
import model.User.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/homePageCtrl")
public class HomePageCtrl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        GetRepo.print("HomePageCtrl");
//        if(!GetRepo.isSetRepo || UsersRepo.getInstance().getLoginUser() != null){
//            GetRepo.print("not setRepo");
//            request.getRequestDispatcher("home").forward(request, response);
//        }
//        String userId = (String) request.getParameter("userId");
//        try {
//            System.out.println(userId);
//            if(UsersRepo.getInstance().getLoginUser() != null)
//                GetRepo.print(UsersRepo.getInstance().getLoginUser().getLastName() + " is logout");
//            UsersRepo.getInstance().logOutAlUsers();
//            UsersRepo.getInstance().setLoginUser(userId);
//            GetRepo.print("user " + UsersRepo.getInstance().getLoginUser().getLastName() + " is login");
//            request.getRequestDispatcher("jsp/userOwnPage.jsp").forward(request, response);
//
//        } catch (UserNotFound userNotFound) {
//            userNotFound.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (DupEndorse dupEndorse) {
//            dupEndorse.printStackTrace();
//        }
    }
}

package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Exceptions.DupEndorse;
import model.Exceptions.UserNotFound;
import model.Project.Project;
import model.Repo.GetRepo;
import model.Repo.ProjectsRepo;
import model.Repo.UsersRepo;
import model.Skill.UserSkill;
import model.User.User;
import springController.ProjectCompleteData;
import springController.UserCompleteData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/showSpecifiedUserCtrl")
public class ShowSpecifiedUserCtrl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!GetRepo.isSetRepo){
            GetRepo.print("not setRepo ShowSpecifiedUserCtrl");
            request.getRequestDispatcher("home").forward(request, response);
        }
        GetRepo.print("showSpecifiedUserCtrl");
        String userId = request.getParameter("userId");
        if(userId.equals("profile")){
            try {
                userId = UsersRepo.getInstance().getLoginUser().getId();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (DupEndorse dupEndorse) {
                dupEndorse.printStackTrace();
            }
        }
        GetRepo.print(userId);
        try {
            User user = UsersRepo.getInstance().getUserById(userId);
            response.setHeader("Content-Type", "application/json; charset=UTF-8");
            UserCompleteData userCompleteData = new UserCompleteData(user.getId(), user.getBio(), user.getFirstName()
                    , user.getLastName(), user.getJobTitle());
            userCompleteData.setuSkills(new ArrayList<UserSkill>(user.getSkills().values()));
            response.setStatus(200);
            ArrayList<UserSkill> listSkills = new ArrayList<UserSkill>(user.getSkills().values());
            GetRepo.print(listSkills);
//            userCompleteData.isLoginUserEndorsed = false;
            GetRepo.print("id is" + user.getId());
            for (int i = 0; i < listSkills.size(); i++){
                listSkills.get(i).isLoginUserEndorsed = listSkills.get(i).isEndorser(UsersRepo.getInstance().getLoginUser().getId());
            }
            ObjectMapper om = new ObjectMapper();
            String json = om.writeValueAsString(userCompleteData);
            GetRepo.print(json);
            PrintWriter writer = response.getWriter();
            writer.print(json);
            writer.flush();
            GetRepo.print(UsersRepo.getInstance().getLoginUser().getFirstName() + UsersRepo.getInstance().getLoginUser().getLastName() + "is login");
            GetRepo.print("user " + user.getFirstName() + " " + user.getLastName() + " is login" + user.isLogin());
//            if(user.isLogin()){
//                request.getRequestDispatcher("jsp/userOwnPage.jsp").forward(request, response);
//            }
//            else{
//                request.getRequestDispatcher("jsp/userGuestPage.jsp").forward(request, response);
//            }
        } catch (UserNotFound userNotFound) {
            userNotFound.printStackTrace();
            response.setStatus(404);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DupEndorse dupEndorse) {
            dupEndorse.printStackTrace();
        }
    }
}
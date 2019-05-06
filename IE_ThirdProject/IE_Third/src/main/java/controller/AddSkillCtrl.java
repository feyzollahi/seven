package controller;

import model.Repo.GetRepo;
import model.Repo.UsersRepo;
import model.Skill.UserSkill;
import model.User.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addSkillCtrl")
public class AddSkillCtrl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        GetRepo.print("addSkillCtrl");
//        String skillName = request.getParameter("skillName");
//        User user = UsersRepo.getInstance().getLoginUser();
//        user.addSkill(new UserSkill(skillName));
//        request.setAttribute("addMsg", "skill " + "\"" + skillName + "\"" + " was added to user " + user.getFirstName()
//                + " " + user.getLastName() + " skills list");
//        request.getRequestDispatcher("jsp/userOwnPage.jsp").forward(request, response);
    }
}

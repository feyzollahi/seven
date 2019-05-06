package controller;

import model.Project.Project;
import model.Repo.ProjectsRepo;
import model.Repo.UsersRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/showAllProjects")
public class ShowAllProjects extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ArrayList<Project> matchingProjects = null;
//        try {
//            System.out.println("salam");
//            matchingProjects = ProjectsRepo.getInstance().getProjectFilteredByUserSkills(UsersRepo.getInstance().getLoginUser());
//            request.setAttribute("projects", matchingProjects);
//            request.getRequestDispatcher("home/oldHome.html").forward(request, response);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}

package servlet;

import java.io.IOException;
import java.io.Serial;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.PostDAO;
import model.Post;
import model.User;

@WebServlet("/publish")
public class PostServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("publish.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String title = request.getParameter("title");
        String content = request.getParameter("content");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Post post = new Post();
        post.setUserId(user.getUserId());
        post.setTitle(title);
        post.setContent(content);

        PostDAO postDAO = new PostDAO();
        if (postDAO.addPost(post)) {
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("message", "博客发布失败！");
            request.getRequestDispatcher("publish.jsp").forward(request, response);
        }
    }
}

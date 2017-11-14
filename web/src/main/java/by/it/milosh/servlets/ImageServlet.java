package by.it.milosh.servlets;

import by.it.milosh.pojo.Avatar;
import by.it.milosh.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet
public class ImageServlet extends HttpServlet{

    @Autowired
    private AvatarService avatarService;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jwitter_maven", "root", "12345");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM avatar");
            List<Avatar> avatars = new ArrayList<Avatar>();
            while (rs.next()) {
                Long id = rs.getLong(1);
                Blob avatarBlob = rs.getBlob(2);
                avatars.add(new Avatar(id, avatarBlob));
            }
            Avatar avatar = avatars.get(0);
            Blob blob = avatar.getImage();
            byte[] blobBytes = blob.getBytes(1, (int) blob.length());
            resp.setContentType("image/jpeg");
            resp.setContentLength(blobBytes.length);
            resp.getOutputStream().write(blobBytes);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().print("This is " + this.getClass().getName() + ", using the Post method");
    }
}

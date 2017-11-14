package by.it.milosh.controllers;

import by.it.milosh.pojo.Avatar;
import by.it.milosh.pojo.User;
import by.it.milosh.service.UserService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;

@Controller
public class AvatarController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/uploadAvatarFromPCToDatabase", method = RequestMethod.POST)
    public String uploadAvatarFromPCToDatabase(@RequestParam("file") MultipartFile file, @RequestParam("nickname") String nickname, Model model) {

        try {
            byte[] bytes = file.getBytes();
            userService.saveAvatarToUser(nickname, bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/personal/" + nickname;
    }

    @RequestMapping(value = "/uploadAvatarFromDatabaseToJSP", method = RequestMethod.GET)
    public @ResponseBody
    HttpServletResponse uploadAvatarFromDatabaseToJSP(@RequestParam("nickname") String nickname, HttpServletRequest request, HttpServletResponse response) {
        User user = userService.findUserByNickname(nickname);
        Blob blob = user.getAvatar();

        if (blob == null) {
            try {
                String dataDirectory = request.getServletContext().getRealPath("/resources/images/");
                InputStream initialStream = FileUtils.openInputStream(new File(dataDirectory + "noAvatar.jpg"));
                byte[] byteArray = IOUtils.toByteArray(initialStream);
                response.setContentType("image/jpeg");
                response.setContentLength(byteArray.length);
                response.getOutputStream().write(byteArray);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return response;
        } else {
            try {
                byte[] blobBytes = blob.getBytes(1, (int) blob.length());
                File file = new File("C:\\tiger.jpg");
                byte[] bFile = new byte[(int) file.length()];
                response.setContentType("image/jpeg");
                response.setContentLength(blobBytes.length);
                response.getOutputStream().write(blobBytes);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return response;
        }


/*
        File file = new File("C:\\tiger.jpg");
        byte[] bFile = new byte[(int) file.length()];

//        File fileF = new File("/resources/images/noAvatar.jpg");
//        byte[] bFile = new byte[(int) fileF.length()];
//
        String dataDirectory = request.getServletContext().getRealPath("/resources/images/");
        File fileData = new File(dataDirectory + "noAvatar.jpg");
        byte[] bFileData = new byte[(int) fileData.length()];
//
//
//        Path file = Paths.get(dataDirectory, "noAvatar.jpg");
//        if (Files.exists(file)) {
//            try {
//                response.setContentType("image/jpeg");
//                Files.copy(file, response.getOutputStream());
//                response.getOutputStream().flush();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return response;
//        } else {
        try {
            byte[] blobBytes = blob.getBytes(1, (int) blob.length());
            response.setContentType("image/jpeg");
            response.setContentLength(blobBytes.length);
            response.getOutputStream().write(blobBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
            return response;
        }
*/
   }

}

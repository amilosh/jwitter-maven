package by.it.milosh.controllers;

import by.it.milosh.pojo.Avatar;
import by.it.milosh.pojo.User;
import by.it.milosh.service.AvatarService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Blob;

@Controller
public class ImageController {

    @Autowired
    private AvatarService avatarService;

//    @RequestMapping(value = "/saveImage", method = RequestMethod.GET)
//    public String index(Model model) {
//        File file = new File("C:\\tiger.jpg");
//        byte[] bFile = new byte[(int) file.length()];
//
//        try {
//            FileInputStream fileInputStream = new FileInputStream(file);
//            fileInputStream.read(bFile);
//            fileInputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        Avatar avatar = new Avatar();
//        avatar.setImage(bFile);
//
//        avatarService.save(avatar);
//
//        Avatar avatar1 = (Avatar) avatarService.get(Avatar.class, avatar.getAvatarId());
//        byte[] bAvatar = avatar1.getImage();
//
//        try {
//            FileOutputStream fos = new FileOutputStream("C:\\tiger2.jpg");
//            fos.write(bAvatar);
//            fos.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "redirect:/";
//    }

    @RequestMapping(value = "/saveImage", method = RequestMethod.GET)
    public String index(Model model) {




        Avatar avatar = new Avatar();
        File file = new File("C:\\tiger.jpg");
        try {
            FileInputStream inputStream = new FileInputStream(file);
            avatarService.save(avatar, inputStream, file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//        byte[] bFile = new byte[(int) file.length()];
//
//        try {
//            FileInputStream fileInputStream = new FileInputStream(file);
//            fileInputStream.read(bFile);
//            fileInputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        Avatar avatar = new Avatar();
//        avatar.setImage(bFile);
//
//        avatarService.save(avatar);
//
//        Avatar avatar1 = (Avatar) avatarService.get(Avatar.class, avatar.getAvatarId());
//        byte[] bAvatar = avatar1.getImage();
//
//        try {
//            FileOutputStream fos = new FileOutputStream("C:\\tiger2.jpg");
//            fos.write(bAvatar);
//            fos.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return "redirect:/";
    }

    @RequestMapping(value = "/readImage", method = RequestMethod.GET)
    public String readImage(Model model) {

        Avatar avatar = avatarService.get(Avatar.class, 1L);
          /* Закомментировал нужное - извлечь картинку из базы данных  */
//        Blob blob = avatar.getImage();
//        try {
//            byte[] blobBytes = blob.getBytes(1, (int) blob.length());
//            FileOutputStream outputStream = new FileOutputStream("C:\\tiger2.jpg");
//            outputStream.write(blobBytes);
//            outputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        model.addAttribute("avatar", avatar);



        return "image";
    }

}


package com.fse.controller;

//import com.fse.bean.UserSession;

import com.fse.pojo.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

@Controller
public class CaptchaController {

    @Autowired
    private UserSession session;

    @RequestMapping(value = "/getCaptcha.jpg", method = RequestMethod.GET)
    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Executing captcha :::::::::::");
        response.setContentType("image/jpg");
        int iTotalChars = 6;
        int iHeight = 40;
        int iWidth = 150;
        Font fntStyle1 = new Font("Arial", Font.BOLD, 30);
        Random randChars = new Random();
        String sImageCode = (Long.toString(Math.abs(randChars.nextLong()), 36)).substring(0, iTotalChars);
        BufferedImage biImage = new BufferedImage(iWidth, iHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2dImage = (Graphics2D) biImage.getGraphics();
        int iCircle = 15;
        for (int i = 0; i < iCircle; i++) {
            g2dImage.setColor(new Color(randChars.nextInt(255), randChars.nextInt(255), randChars.nextInt(255)));
        }
        g2dImage.setFont(fntStyle1);
        for (int i = 0; i < iTotalChars; i++) {
            g2dImage.setColor(new Color(randChars.nextInt(255), randChars.nextInt(255), randChars.nextInt(255)));
            if (i % 2 == 0) {
                g2dImage.drawString(sImageCode.substring(i, i + 1), 25 * i, 24);
            } else {
                g2dImage.drawString(sImageCode.substring(i, i + 1), 25 * i, 35);
            }
        }
        OutputStream osImage = response.getOutputStream();
        ImageIO.write(biImage, "jpeg", osImage);
        g2dImage.dispose();
        osImage.close();
        /*HttpSession session = request.getSession();
        session.setAttribute("captcha_security", sImageCode);*/
        session.setCaptcha(sImageCode);
    }

}

package com.teameth.moviebooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service


public class EmailNotificationService {
   /* @Autowired
    public EmailService emailService;*/
   @Autowired
    JavaMailSender javaMailSender;

   /* public String sendEmail(String email) {
        return emailService.sendEmail(email);
    }*/
   //@RequestMapping("/sendEmail")
    public void sendEmail(String email, String name, Integer id) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("cinema.reservation.mail@gmail.com");
         //message.setTo("selamtsehaye21@gmail.com");//here getEmail from repository
        message.setTo(email);
        message.setSubject("Movie reservation");
        message.setText("Dear "+name+ "/n"+ "You have successfully reserved your seats"
                + "Your reservation ID is: "+ id);
        javaMailSender.send(message);

    }
}

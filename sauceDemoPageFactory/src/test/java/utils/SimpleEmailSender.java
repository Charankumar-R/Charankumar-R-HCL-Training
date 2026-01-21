package utils;

import java.io.File;
import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class SimpleEmailSender {

    public static void sendReport() {
        try {
            final String from = "charanrck10@gmail.com";
            final String password = "qfcucgqwvwbmynel"; // App password

            final String to =
                "bharathsbalaji05@gmail.com," +
                "kailashkarthikeyanms@gmail.com," +
                "senthil.natarajan1979@gmail.com";

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Automation Report");

            MimeBodyPart body = new MimeBodyPart();
            body.setText("Please find the automation report attached.");

            MimeBodyPart attachment = new MimeBodyPart();
            attachment.attachFile(new File("reports/ExtentReport.html"));

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(body);
            multipart.addBodyPart(attachment);

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Email sent");

        } catch (Exception e) {
            System.out.println("Email failed, continuing");
        }
    }
}

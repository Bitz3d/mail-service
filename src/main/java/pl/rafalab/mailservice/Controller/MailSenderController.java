package pl.rafalab.mailservice.Controller;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RestController
@RequestMapping("api")
public class MailSenderController {

    private JavaMailSender emailSender;

    public MailSenderController(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @GetMapping("send")
    public void senMail() throws MessagingException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo("kanarek.marek69@gmail.com");
        helper.setSubject("tak");
        helper.setText("adjhaskdjhasjkdhaskjd");

        emailSender.send(mimeMessage);

    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    @ResponseBody
    public String dzial() {
        return "dziala";
    }
}

package pl.edu.utp.wtie.homeworkweek6.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import pl.edu.utp.wtie.homeworkweek6.model.Movie;
import pl.edu.utp.wtie.homeworkweek6.service.MovieService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
@Aspect
public class Email {

    @Value("${spring.mail.username}")
    private String username;
    private JavaMailSender javaMailSender;
    private MovieService movieService;

    @Autowired
    public Email(JavaMailSender javaMailSender, MovieService movieService) {
        this.javaMailSender = javaMailSender;
        this.movieService = movieService;
    }

    @After("@annotation(EmailAspect)")
    private void sendEmail() {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        Movie movie = movieService.getMovieList().get(movieService.getMovieList().size() - 1);
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(username);
            mimeMessageHelper.setFrom(username);
            mimeMessageHelper.setSubject("Hi, you just added a new movie...");
            mimeMessageHelper.setText("Information about the added movie:\n" +
                    "-> id: " + movie.getId() + ",\n" +
                    "-> title: " + movie.getTitle() + ",\n" +
                    "-> production year: " + movie.getProductionYear() + ",\n" +
                    "-> director: " + movie.getDirector() + ".");
        } catch (MessagingException e) {
            System.err.println("Error creating email!");
            e.printStackTrace();
        }

        javaMailSender.send(mimeMessage);
    }
}

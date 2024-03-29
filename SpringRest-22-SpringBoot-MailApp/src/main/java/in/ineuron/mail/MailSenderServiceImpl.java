package in.ineuron.mail;

import java.io.File;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailSenderServiceImpl implements IMailSenderService {
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String sender;


	@Override
	public String sendSimpleMail(EmailDetails details) {
			try {

				SimpleMailMessage mailMessage = new SimpleMailMessage();

				mailMessage.setFrom(sender);
				mailMessage.setTo(details.getRecipient());
				mailMessage.setText(details.getMsgBody());
				mailMessage.setSubject(details.getSubject());

				javaMailSender.send(mailMessage);
				return "Mail Sent Successfully to "+details.getRecipient();
			}

			catch (Exception e) {
				System.out.println(e);
				return "Error while Sending Mail";
			}
	}
		

	@Override
	public String sendMailWithAttachment(EmailDetails details) {
			
			
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper;

			try {

				mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
				mimeMessageHelper.setFrom(sender);
				mimeMessageHelper.setTo(details.getRecipient());
				mimeMessageHelper.setText(details.getMsgBody());
				mimeMessageHelper.setSubject(details.getSubject());

				FileSystemResource file = new FileSystemResource(new File(details.getAttachment()));
				mimeMessageHelper.addAttachment(file.getFilename(), file);

				javaMailSender.send(mimeMessage);
				return "Mail sent Successfully";
			}

			catch (MessagingException e) {
				return "Error while sending mail!!!";
			}
		}


	@Override
	public String sendMailToAll(EmailDetails details, Set<String> mailIds) {
		try {

			SimpleMailMessage mailMessage = new SimpleMailMessage();

			mailMessage.setFrom(sender);
			mailMessage.setTo(details.getRecipient());
			mailMessage.setTo();
			mailMessage.setText(details.getMsgBody());
			mailMessage.setSubject(details.getSubject());
			
			mailIds.forEach(person ->{
				mailMessage.setTo(person);
				javaMailSender.send(mailMessage);
			});
			return "Mail Sent Successfully...";
		}

		catch (Exception e) {
			System.out.println(e);
			return "Error while Sending Mail";
		}
		
	}
	
	
}
	

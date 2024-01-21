package in.ineuron.mail;

import java.util.Set;

import org.springframework.web.bind.annotation.RequestBody;

public interface IMailSenderService {
	
	public String sendSimpleMail(EmailDetails details);
	public String sendMailWithAttachment(EmailDetails details);
	public String sendMailToAll(@RequestBody EmailDetails details , Set<String> mailIds);

}

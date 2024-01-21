package in.ineuron.service;

public interface IEmailService {
	
    String sendSimpleMail(EmailDetails details);
 
    String sendMailWithAttachment(EmailDetails details);

}

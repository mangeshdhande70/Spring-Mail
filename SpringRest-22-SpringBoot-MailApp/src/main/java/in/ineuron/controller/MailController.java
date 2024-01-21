package in.ineuron.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.mail.EmailDetails;
import in.ineuron.mail.IMailSenderService;

@RestController
@RequestMapping(value = "/mail")
public class MailController {
	
	@Autowired
	private IMailSenderService emailService;
	

	
	@GetMapping("/wel")
	public String welcome() {
		return "Welcome to Email API";
	}

	
	@PostMapping("/sendMail")
	public String sendMail(@RequestBody EmailDetails details) {

		String status = emailService.sendSimpleMail(details);

		return status;
	}
	
	

	@PostMapping("/sendMailWithAttachment")
	public String sendMailWithAttachment(@RequestBody EmailDetails details) {
		String status = emailService.sendMailWithAttachment(details);

		return status;
	}
	
	
	@PostMapping("/sendMailToAll")
	public String sendMailToAll(@RequestBody EmailDetails details) {
		
		
		Set<String> mailIdSet = Set.of("mangeshdhande98@gmail.com" , "mangeshdhande70@gmail.com"); 
		
		String status = emailService.sendMailToAll(details, mailIdSet);

		return status;
	}
	

}

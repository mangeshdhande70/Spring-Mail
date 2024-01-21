package in.ineuron.controller;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.service.EmailDetails;
import in.ineuron.service.IEmailService;

@RestController
public class EmailController {

	@Autowired	private IEmailService iEmailService;
	
	@Autowired
	private EmailDetails emailDetails;
	
	
	public void sendMail() {
		
		String status = iEmailService.sendSimpleMail(emailDetails);
		
		System.out.println(status);
		
	}
	
	public void testUsingEmailValidator() {
	  String  emailAddress = "mangesh@gmail.com";
	  Assert.isTrue(EmailValidator.getInstance().isValid(emailAddress));

	  
	 
	}

}

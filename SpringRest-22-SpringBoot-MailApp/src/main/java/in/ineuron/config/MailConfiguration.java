package in.ineuron.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.ineuron.mail.EmailDetails;

@Configuration
public class MailConfiguration {

	@Bean
	public EmailDetails getEmailDetails() {
		return new EmailDetails();
	}
	
	
	
}

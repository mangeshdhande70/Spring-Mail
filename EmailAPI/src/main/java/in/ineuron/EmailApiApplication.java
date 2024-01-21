package in.ineuron;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import in.ineuron.controller.EmailController;
import in.ineuron.service.EmailDetails;

@SpringBootApplication
public class EmailApiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EmailApiApplication.class, args);
		
		System.out.println("******** Bean Created by container :: **************");
		System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
		System.out.println(context.getBeanDefinitionCount());
		
		System.out.println("\n\n******************************************************");
		EmailController controller = context.getBean(EmailController.class);
		controller.sendMail();
		
	}
	
	
	@Bean
	public EmailDetails getDetails() {
		EmailDetails emailDetails = new EmailDetails();
		emailDetails.setRecipient("mageshdhande70@gmail.com");
		emailDetails.setMsgBody("Hi we are happy to see you............");
		emailDetails.setSubject("Selection process");
		return emailDetails;
	}

}

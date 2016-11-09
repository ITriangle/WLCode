package com.wang.SpringHello;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// @ComponentScan
public class JavaConfigClass {

	@Bean
	MessageService mockMessageService() {
		return new MessageService() {
			public String getMessage() {
				return "Hello World!";
			}
		};
	}

	@Bean
	MessagePrinter mockMessagePrinter(MessageService service) {
		return new MessagePrinter(service);
	}

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfigClass.class);
		MessagePrinter messagePrinter = context.getBean(MessagePrinter.class);
		messagePrinter.printMessage();
		((AnnotationConfigApplicationContext) context).close();

	}

	@Test
	public void testMain() {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfigClass.class);
		MessagePrinter messagePrinter = context.getBean(MessagePrinter.class);
		messagePrinter.printMessage();
		((AnnotationConfigApplicationContext) context).close();

	}
}
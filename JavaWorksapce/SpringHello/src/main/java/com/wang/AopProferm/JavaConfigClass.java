package com.wang.AopProferm;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class JavaConfigClass {

	
	@Test
	public void testAop(){
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfigClass.class);
		PersonService personService = context.getBean(PersonService.class);
		
		String personName = "Jim";
    	personService.addPerson(personName);
    	personService.deletePerson(personName);
    	personService.editPerson(personName);
    	
    	((AnnotationConfigApplicationContext)context).close();
	}
}
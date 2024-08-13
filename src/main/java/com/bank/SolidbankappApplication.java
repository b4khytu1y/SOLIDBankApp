package com.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.bank.cli.MyCLI;

@SpringBootApplication
public class SolidbankappApplication {

	public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("props.xml");
        MyCLI cli = context.getBean(MyCLI.class);
        cli.start();
    }

}

package com.bank;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bank.cli.MyCLI;
import com.bank.config.AppConfig;

@SpringBootApplication
public class SolidbankappApplication {

	public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyCLI accountCLI = context.getBean(MyCLI.class);

        accountCLI.start();

    }
}

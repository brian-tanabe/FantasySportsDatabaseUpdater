package com.btanabe.fsdu.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Brian on 12/23/15.
 */
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-configuration/application-configuration.xml");

        new EspnPlayerOwnershipScraper().printPlayersOwnedByTheParameterizedTeam("Ty Fighter");
    }
}

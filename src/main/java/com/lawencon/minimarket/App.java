package com.lawencon.minimarket;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lawencon.minimarket.view.MainView;

/**
 *
 * @author Galih Dika
 *
 */

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("main.xml");
		MainView mainView = context.getBean(MainView.class);
		mainView.show();
	}
}

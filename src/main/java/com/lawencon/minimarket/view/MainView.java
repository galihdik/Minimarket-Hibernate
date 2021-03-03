package com.lawencon.minimarket.view;

import java.util.Scanner;

/**
 *
 * @author Galih Dika
 *
 */

public class MainView {
	private Login login;

	public MainView(Login login) {
		this.login = login;
	}

	public void show() {
		byte menu = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("============ WELCOME TO LawenMart ==================");
		System.out.println("1. Login");
		System.out.println("2. Keluar");
		System.out.println("Masukan menu : ");
		byte pilihMenu = input.nextByte();
		if (pilihMenu == 1) {
			login.show(val -> {
				show();
			});
		} else if (pilihMenu == 2) {
			System.out.println("Terima kasih telah berbelanja di LawenMart");
		}
	}
}

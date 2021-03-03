package com.lawencon.minimarket.view;

import java.util.Scanner;

import com.lawencon.minimarket.util.CallBack;

/**
 *
 * @author Galih Dika
 *
 */

public class MenuAdmin {
	private AboutView aboutView;
	private CategoryView categoryView;
	private ItemView itemView;
	private PaymentView paymentView;
	private ProfileView profileView;
	private RoleView roleView;
	private SuplierView suplierView;
	private UserView userView;
	private History history;

	public MenuAdmin(AboutView aboutView, CategoryView categoryView, ItemView itemView, PaymentView paymentView,
			ProfileView profileView, RoleView roleView, SuplierView suplierView, UserView userView, History history) {
		this.aboutView = aboutView;
		this.categoryView = categoryView;
		this.itemView = itemView;
		this.paymentView = paymentView;
		this.profileView = profileView;
		this.roleView = roleView;
		this.suplierView = suplierView;
		this.userView = userView;
		this.history = history;
	}

	void show(CallBack cb) {
		Scanner input = new Scanner(System.in);
		System.out.println("============ Menu User ==================");
		System.out.println("1. CRUD User");
		System.out.println("2. CRUD Item");
		System.out.println("3. CRUD Category");
		System.out.println("4. CRUD Payments");
		System.out.println("5. CRUD Supliers");
		System.out.println("6. History");
		System.out.println("7. CRUD About");
		System.out.println("8. CRUD Profile");
		System.out.println("9. CRUD Roles");
		System.out.println("10. Logout");
		System.out.println("Pilih Menu : ");
		byte menu = input.nextByte();
		if (menu == 1) {
			userView.show(val -> {
				show(cb);
			});
		} else if (menu == 2) {
			itemView.show(val -> {
				show(cb);
			});
		} else if (menu == 3) {
			categoryView.show(val -> {
				show(cb);
			});
		} else if (menu == 4) {
			paymentView.show(val -> {
				show(cb);
			});
		} else if (menu == 5) {
			suplierView.show(val -> {
				show(cb);
			});
		} else if (menu == 6) {
			history.show(val -> {
				show(cb);
			});
		} else if (menu == 7) {
			aboutView.show(val -> {
				show(cb);
			});
		} else if (menu == 8) {
			profileView.show(val -> {
				show(cb);
			});
		} else if (menu == 9) {
			roleView.show(val -> {
				show(cb);
			});
		} else if (menu == 10) {
			cb.onDone("");
		}
	}
}

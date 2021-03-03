package com.lawencon.minimarket.view;

import java.util.List;
import java.util.Scanner;

import com.lawencon.minimarket.model.Roles;
import com.lawencon.minimarket.service.RolesService;
import com.lawencon.minimarket.util.CallBack;

/**
 *
 * @author Galih Dika
 *
 */

public class RoleView {
	private RolesService roleServices;
	private List<Roles> role;
	private Scanner input2 = new Scanner(System.in);
	private Scanner input = new Scanner(System.in);

	public RoleView(RolesService roleServices) {
		this.roleServices = roleServices;
	}

	void show(CallBack cb) {
		System.out.println("===== Role ====");
		System.out.println("1. Create Role");
		System.out.println("2. Read Role");
		System.out.println("3. Search by Code");
		System.out.println("4. Back");
		Scanner input = new Scanner(System.in);
		System.out.println("Pilih : ");
		byte pilih = input.nextByte();
		if (pilih == 1) {
			addRoles();
			show(cb);
		} else if (pilih == 2) {
			try {
				role = roleServices.getRoles();
				System.out.println("Id Role  | Name Role| Role Code");
				role.forEach(rl -> {
					System.out.printf("|%-8s|%-10s|%-10s\n", rl.getIdRoles(), rl.getNameRoles(), rl.getCodeRoles());

				});
			} catch (Exception e) {
				e.printStackTrace();
			}
			show(cb);
		} else if (pilih == 3) {

		} else if (pilih == 4) {
			cb.onDone("");
		}
	}

	void addRoles() {
		Roles rl = new Roles();
		System.out.println("Masukan Nama Role: ");
		String nama = input2.next();
		System.out.println("Masukan code role : ");
		String code = input2.next();
		rl.setNameRoles(nama);
		rl.setCodeRoles(code);
		try {
			roleServices.addData(rl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

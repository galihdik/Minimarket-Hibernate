package com.lawencon.minimarket.view;

import java.util.List;
import java.util.Scanner;

import com.lawencon.minimarket.model.Profiles;
import com.lawencon.minimarket.model.Roles;
import com.lawencon.minimarket.model.Users;
import com.lawencon.minimarket.service.UsersServices;
import com.lawencon.minimarket.util.CallBack;

/**
 *
 * @author Galih Dika
 *
 */

public class UserView {
	private UsersServices userServices;
	private List<Users> user;
	private Scanner input = new Scanner(System.in);
	private Scanner input2 = new Scanner(System.in);

	public UserView(UsersServices userServices) {
		this.userServices = userServices;
	}

	void show(CallBack cb) {
		System.out.println("===== USER ====");
		System.out.println("1. Create User");
		System.out.println("2. Read User");
		System.out.println("3. Search by Code");
		System.out.println("4. Back");
		Scanner input = new Scanner(System.in);
		System.out.println("Pilih : ");
		byte pilih = input.nextByte();
		if (pilih == 1) {
			addUser();
			show(cb);
		} else if (pilih == 2) {
			try {
				user = userServices.getUser();
				System.out.println("User Id  | Username | Password | Id Role  | Id Profile");
				user.forEach(usr -> {
					System.out.printf("|%-8s|%-10s|%-10s|%-10s|%-11s|\n", usr.getUserId(), usr.getUsername(),
							usr.getPswd(), usr.getIdRoles().getIdRoles(), usr.getIdProfiles().getIdProfiles());

				});
			} catch (Exception e) {
				e.printStackTrace();
			}
			show(cb);
		} else if (pilih == 3) {

		} else {
			cb.onDone("");
		}
	}

	void addUser() {
		Users usr = new Users();
		System.out.println("Masukan username : ");
		String nama = input2.nextLine();
		System.out.println("Masukan Password : ");
		String paswd = input2.nextLine();
		System.out.println("Masukan Role ID : ");
		Integer role = input.nextInt();
		System.out.println("Masukan Profile ID : ");
		Integer prof = input.nextInt();
		System.out.println("Masukan code user : ");
		String code = input2.nextLine();
		usr.setUsername(nama);
		usr.setPswd(paswd);
		Roles rl = new Roles();
		rl.setIdRoles(role.longValue());
		Profiles pf = new Profiles();
		pf.setIdProfiles(prof.longValue());
		usr.setIdRoles(rl);
		usr.setIdProfiles(pf);
		usr.setUserCode(code);
		try {
			userServices.addData(usr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

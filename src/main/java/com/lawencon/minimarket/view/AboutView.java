package com.lawencon.minimarket.view;

import java.util.List;
import java.util.Scanner;

import com.lawencon.minimarket.model.About;
import com.lawencon.minimarket.service.AboutService;
import com.lawencon.minimarket.util.CallBack;

/**
 *
 * @author Galih Dika
 *
 */

public class AboutView {
	private AboutService aboutServices;
	private List<About> about;
	private Scanner input2 = new Scanner(System.in);
	private Scanner input = new Scanner(System.in);

	public AboutView(AboutService aboutServices) {
		this.aboutServices = aboutServices;
	}

	void show(CallBack cb) {
		System.out.println("===== About ====");
		System.out.println("1. Create About");
		System.out.println("2. Read About");
		System.out.println("3. Search by Code");
		System.out.println("4. Back");

		System.out.println("Pilih : ");
		byte pilih = input.nextByte();
		if (pilih == 1) {
			addAbout();
			show(cb);
		} else if (pilih == 2) {
			try {
				about = aboutServices.getAbout();
				System.out.println("User Id  | Name     | Location");
				about.forEach(abt -> {
					System.out.printf("|%-8s|%-10s|%-10s\n", abt.getIdAbout(), abt.getNameAbout(),
							abt.getLocationAbout());

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

	void addAbout() {
		About abt = new About();
		System.out.println("Masukan Nama : ");
		String nama = input2.next();
		System.out.println("Masukan lokasi : ");
		String lokasi = input2.next();
		System.out.println("Masukan code about : ");
		String code = input2.next();
		abt.setNameAbout(nama);
		abt.setLocationAbout(lokasi);
		abt.setAboutCode(code);
		try {
			aboutServices.addData(abt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

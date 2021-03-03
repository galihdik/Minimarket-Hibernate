package com.lawencon.minimarket.view;

import java.util.List;
import java.util.Scanner;

import com.lawencon.minimarket.model.Supliers;
import com.lawencon.minimarket.service.SupliersService;
import com.lawencon.minimarket.util.CallBack;

/**
 *
 * @author Galih Dika
 *
 */

public class SuplierView {
	private SupliersService suplierServices;
	private List<Supliers> suplier;
	private Scanner input = new Scanner(System.in);
	private Scanner input2 = new Scanner(System.in);

	public SuplierView(SupliersService suplierServices) {
		this.suplierServices = suplierServices;
	}

	void show(CallBack cb) {
		System.out.println("===== Suplier ====");
		System.out.println("1. Create Suplier");
		System.out.println("2. Read Suplier");
		System.out.println("3. Search by Code");
		System.out.println("4. Back");
		Scanner input = new Scanner(System.in);
		System.out.println("Pilih : ");
		byte pilih = input.nextByte();
		if (pilih == 1) {
			addSuplier();
			show(cb);
		} else if (pilih == 2) {
			try {
				suplier = suplierServices.getSupliers();
				System.out.println("Id Suplier | Name Suplier | Phone Number | Location Suplier ");
				suplier.forEach(spl -> {
					System.out.printf("|%-8s|%-10s|%-10s|%-10s\n", spl.getIdSupliers(), spl.getNameSupliers(),
							spl.getPhoneNumber(), spl.getLocationSupliers());

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

	void addSuplier() {
		Supliers spl = new Supliers();
		System.out.println("Masukan Nama suplier: ");
		String nama = input2.next();
		System.out.println("Masukan Nomer Telepon: ");
		String noHp = input2.next();
		System.out.println("Masukan Lokasi suplier: ");
		String lokasi = input2.next();
		System.out.println("Masukan code suplier : ");
		String code = input2.next();
		spl.setNameSupliers(nama);
		spl.setPhoneNumber(noHp);
		spl.setLocationSupliers(lokasi);
		spl.setSuplierCode(code);
		try {
			suplierServices.addData(spl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

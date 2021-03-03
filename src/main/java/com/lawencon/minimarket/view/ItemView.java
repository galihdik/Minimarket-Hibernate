package com.lawencon.minimarket.view;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.lawencon.minimarket.model.Category;
import com.lawencon.minimarket.model.Items;
import com.lawencon.minimarket.model.Supliers;
import com.lawencon.minimarket.service.ItemService;
import com.lawencon.minimarket.util.CallBack;

/**
 *
 * @author Galih Dika
 *
 */

public class ItemView {
	private ItemService itemServices;
	private List<Items> item;
	private Scanner input2 = new Scanner(System.in);
	private Scanner input = new Scanner(System.in);

	public ItemView(ItemService itemServices) {
		this.itemServices = itemServices;
	}

	void show(CallBack cb) {
		System.out.println("===== Item ====");
		System.out.println("1. Create Item");
		System.out.println("2. Read Item");
		System.out.println("3. Search by Code");
		System.out.println("4. Back");
		Scanner input = new Scanner(System.in);
		System.out.println("Pilih : ");
		byte pilih = input.nextByte();
		if (pilih == 1) {
			addItem();
			show(cb);
		} else if (pilih == 2) {
			try {
				item = itemServices.getItem();
				System.out.println(
						"Id Item| Name Item| Expired Item | Stock Item | Price Item | Id Supliers | Id Category | Code Item");
				item.forEach(it -> {
					System.out.printf("|%-8s|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s\n", it.getIdItems(),
							it.getNameItems(), it.getExpiredItems(), it.getStockItems(), it.getPriceItems(),
							it.getIdSupliers().getIdSupliers(), it.getIdCategory().getIdCategory(), it.getCodeItems());

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

	void addItem() {
		Items itm = new Items();
		System.out.println("Masukan Nama Item : ");
		String nama = input2.nextLine();
		System.out.println("Masukan Tanggal Expired (yyyy-MM-dd HH:mm)  : ");
		String exp = input2.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime lclDate = LocalDateTime.parse(exp, formatter);
		System.out.println("Masukan Stock Items :");
		Integer itemStoc = input.nextInt();
		System.out.println("Masukan harga item :");
		BigDecimal hargaItem = input.nextBigDecimal();
		System.out.println("Masukan nomer supliernya : ");
		Integer supp = input.nextInt();
		System.out.println("Masukan nomer category barangnya :");
		Integer ctgg = input.nextInt();
		System.out.println("Masukan code Item : ");
		String code = input2.nextLine();
		itm.setNameItems(nama);
		itm.setExpiredItems(lclDate);
		itm.setStockItems(itemStoc);
		itm.setPriceItems(hargaItem);
		Category ctg = new Category();
		ctg.setIdCategory(ctgg.longValue());
		Supliers sup = new Supliers();
		sup.setIdSupliers(supp.longValue());
		itm.setIdSupliers(sup);
		itm.setIdCategory(ctg);
		itm.setCodeItems(code);
		try {
			itemServices.insertData(itm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

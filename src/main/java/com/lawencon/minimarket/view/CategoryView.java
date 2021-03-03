package com.lawencon.minimarket.view;

import java.util.List;
import java.util.Scanner;

import com.lawencon.minimarket.model.Category;
import com.lawencon.minimarket.service.CategoryService;
import com.lawencon.minimarket.util.CallBack;

/**
 *
 * @author Galih Dika
 *
 */

public class CategoryView {
	private CategoryService categoryServices;
	private List<Category> category;
	private Scanner input2 = new Scanner(System.in);
	private Scanner input = new Scanner(System.in);

	public CategoryView(CategoryService categoryServices) {
		this.categoryServices = categoryServices;
	}

	void show(CallBack cb) {
		System.out.println("===== Category ====");
		System.out.println("1. Create Category");
		System.out.println("2. Read Category");
		System.out.println("3. Search by Code");
		System.out.println("4. Back");
		Scanner input = new Scanner(System.in);
		System.out.println("Pilih : ");
		byte pilih = input.nextByte();
		if (pilih == 1) {
			addCatogry();
			show(cb);
		} else if (pilih == 2) {
			try {
				category = categoryServices.getCategory();
				System.out.println("Id Category| Name Category|Category Code");
				category.forEach(ctg -> {
					System.out.printf("|%-8s|%-10s|%-10s\n", ctg.getIdCategory(), ctg.getCategoryName(),
							ctg.getCategoryCode());

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

	void addCatogry() {
		Category ctg = new Category();
		System.out.println("Masukan Nama Kategori : ");
		String nama = input2.next();
		System.out.println("Masukan code kategori : ");
		String code = input2.next();
		ctg.setCategoryName(nama);
		ctg.setCategoryCode(code);
		try {
			categoryServices.addData(ctg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

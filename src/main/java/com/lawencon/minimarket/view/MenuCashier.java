package com.lawencon.minimarket.view;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.lawencon.minimarket.model.DetailTransactions;
import com.lawencon.minimarket.model.Items;
import com.lawencon.minimarket.model.Payments;
import com.lawencon.minimarket.model.Transactions;
import com.lawencon.minimarket.service.TransactionService;
import com.lawencon.minimarket.util.CallBack;

/**
 *
 * @author Galih Dika
 *
 */

public class MenuCashier {
	private List<DetailTransactions> detailList = new ArrayList<>();
	private Scanner input = new Scanner(System.in);
	private Scanner input2 = new Scanner(System.in);
	private TransactionService transactionService;
	private int kuantiti;
	private BigDecimal tampungDetailPrice = BigDecimal.ZERO;
	private BigDecimal tampungDetailPriceTotal = BigDecimal.ZERO;
	private Transactions transactions = new Transactions();

	public MenuCashier(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	void show(CallBack cb) {
		System.out.println("============ Menu  Cashier ==================");
		System.out.println(
				"====BARANG YANG SUDAH BELI TIDAK BISA DIBATALKAN DAN JUGA JIKA MENAMBAH HARUS TRANSAKSI ULANG====");
		System.out.println("1. Beli Barang");
		System.out.println("2. Logout");
		System.out.println("Masukan menu : ");
		byte pilihMenu = input.nextByte();
		if (pilihMenu == 1) {
			addBarang();
			show(cb);
		} else if (pilihMenu == 2) {
			cb.onDone("");
		}

	}

	void addBarang() {
		DetailTransactions detailTransactions = new DetailTransactions();
		System.out.println("Ingin beli yang mana (masukan code item): ");
		String codeItems = input2.nextLine();
		try {
			Items itemDB = transactionService.getItem(codeItems);
			detailTransactions.setIdItems(itemDB);
			detailTransactions.setPrice(itemDB.getPriceItems());
			tampungDetailPrice = itemDB.getPriceItems();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Ingin beli berapa banyak : ");
		kuantiti = input.nextInt();
		tampungDetailPrice = tampungDetailPrice.multiply(BigDecimal.valueOf(kuantiti));
		tampungDetailPriceTotal = tampungDetailPriceTotal.add(tampungDetailPrice);
		transactions.setDetailTransactions(detailList);
		transactions.setTransactionDate(LocalDateTime.now());
		detailTransactions.setQty(kuantiti);
		detailList.add(detailTransactions);
		System.out.println("Ingin ulang ? (Y/N) : ");
		String ulang = input2.next();
		if (ulang.equalsIgnoreCase("Y")) {
			System.out.println("Barang berhasil ditambah");
			addBarang();
		} else if (ulang.equalsIgnoreCase("n")) {
			addPayment();
		}
	}

	void addPayment() {
		System.out.println("Harga anda totalnya : " + tampungDetailPriceTotal);
		System.out.println("Ingin bayar pakai apa? (Cash/Cashless)");
		System.out.println("Pilih :");
		String pilih = input2.next();
		Random random = new Random();
		int tampungRandom = random.nextInt(999);
		String tampungCode = "trx" + tampungRandom;
		transactions.setStrukCode(tampungCode);
		Payments payment = new Payments();
		if (pilih.equalsIgnoreCase("cash")) {
			System.out.println("Anda memilih cash");
			System.out.println("Silahkan Bayar : ");
			Integer bayar = input.nextInt();
			if (bayar < tampungDetailPriceTotal.intValue()) {
				System.out.println("Anda bayarnya kurang !");
				addPayment();
			}
			try {
				payment = transactionService.getPayments(pilih);
				transactions.setIdPayments(payment);
				transactionService.addData(detailList, transactions);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (pilih.equalsIgnoreCase("cashless")) {
			System.out.println("Anda memilih Cashless");
			try {
				payment = transactionService.getPayments("2");
				transactions.setIdPayments(payment);
				transactionService.addData(detailList, transactions);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Pembayaran anda telah diambil, terima kasih");
		}
	}
}

package com.lawencon.minimarket.view;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.lawencon.minimarket.model.Transactions;
import com.lawencon.minimarket.service.TransactionService;
import com.lawencon.minimarket.util.CallBack;

/**
 *
 * @author Galih Dika
 *
 */

public class History {
	private TransactionService transactionServices;
	private List<Transactions> transaction;

	public History(TransactionService transactionServices) {
		this.transactionServices = transactionServices;
	}

	void show(CallBack cb) {
		System.out.println("===== History ====");
		System.out.println("1. Read History");
		System.out.println("2. Search by Code");
		System.out.println("3. Back");
		Scanner input = new Scanner(System.in);
		System.out.println("Pilih : ");
		byte pilih = input.nextByte();
		if (pilih == 1) {
			try {
				transaction = transactionServices.getTransaction();
				System.out.println(
						"Id Transaction  | Transaction Date | Price Total | Id About | Id Payment | Id User | Struk Code");
				transaction.forEach(trx -> {
					System.out.printf("|%-15s|%-15s|%-10s|%-10s|%-10s|%-10s|%-10s\n", trx.getIdTransaction(),
							trx.getTransactionDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
							trx.getPriceTotal(), trx.getIdAbout().getIdAbout(), trx.getIdPayments().getIdPayments(),
							trx.getIdUsers().getUserId(), trx.getStrukCode());

				});
			} catch (Exception e) {
				e.printStackTrace();
			}
			show(cb);
		} else if (pilih == 2) {
			show(cb);
		} else if (pilih == 3) {
			cb.onDone("");
		}
	}
}

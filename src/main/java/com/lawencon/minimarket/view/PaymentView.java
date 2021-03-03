package com.lawencon.minimarket.view;

import java.util.List;
import java.util.Scanner;

import com.lawencon.minimarket.model.Payments;
import com.lawencon.minimarket.service.PaymentService;
import com.lawencon.minimarket.util.CallBack;

/**
 *
 * @author Galih Dika
 *
 */

public class PaymentView {
	private PaymentService paymentServices;
	private List<Payments> payment;
	private Scanner input2 = new Scanner(System.in);
	private Scanner input = new Scanner(System.in);

	public PaymentView(PaymentService paymentServices) {
		this.paymentServices = paymentServices;
	}

	void show(CallBack cb) {
		System.out.println("===== Payment ====");
		System.out.println("1. Create Payment");
		System.out.println("2. Read Payment");
		System.out.println("3. Search by Code");
		System.out.println("4. Back");
		Scanner input = new Scanner(System.in);
		System.out.println("Pilih : ");
		byte pilih = input.nextByte();
		if (pilih == 1) {
			addPayment();
			show(cb);
		} else if (pilih == 2) {
			try {
				payment = paymentServices.getPayment();
				System.out.println("ID Payment  | Payment Name | Payment Type");
				payment.forEach(py -> {
					System.out.printf("|%-8s|%-10s|%-10s\n", py.getIdPayments(), py.getNamePayments(),
							py.getPaymentsType());

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

	void addPayment() {
		Payments py = new Payments();
		System.out.println("Masukan Nama Pembayaran: ");
		String nama = input2.next();
		System.out.println("Masukan Tipe Pembayaran : ");
		String tipe = input2.next();
		System.out.println("Masukan code payment : ");
		String code = input2.next();
		py.setNamePayments(nama);
		py.setPaymentsType(tipe);
		py.setPaymentCode(code);
		try {
			paymentServices.addDataa(py);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.lawencon.minimarket.model;

/**
 *
 * @author Galih Dika
 *
 */

public class Payments {
	private Long idPayments;
	private String namePayments;
	private String paymentsType;
	private String paymentCode;

	public Long getIdPayments() {
		return idPayments;
	}

	public void setIdPayments(Long idPayments) {
		this.idPayments = idPayments;
	}

	public String getNamePayments() {
		return namePayments;
	}

	public void setNamePayments(String namePayments) {
		this.namePayments = namePayments;
	}

	public String getPaymentsType() {
		return paymentsType;
	}

	public void setPaymentsType(String paymentsType) {
		this.paymentsType = paymentsType;
	}

	public String getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
}

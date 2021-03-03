package com.lawencon.minimarket.model;

/**
 *
 * @author Galih Dika
 *
 */

public class Supliers {
	private Long idSupliers;
	private String nameSupliers;
	private String phoneNumber;
	private String locationSupliers;
	private String suplierCode;

	public Long getIdSupliers() {
		return idSupliers;
	}

	public void setIdSupliers(Long idSupliers) {
		this.idSupliers = idSupliers;
	}

	public String getNameSupliers() {
		return nameSupliers;
	}

	public void setNameSupliers(String nameSupliers) {
		this.nameSupliers = nameSupliers;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getLocationSupliers() {
		return locationSupliers;
	}

	public void setLocationSupliers(String locationSupliers) {
		this.locationSupliers = locationSupliers;
	}

	public String getSuplierCode() {
		return suplierCode;
	}

	public void setSuplierCode(String suplierCode) {
		this.suplierCode = suplierCode;
	}

}

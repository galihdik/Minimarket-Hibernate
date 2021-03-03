package com.lawencon.minimarket.model;

/**
 *
 * @author Galih Dika
 *
 */

public class Profiles {
	private Long idProfiles;
	private String addressProfile;
	private String nameProfile;
	private String profileCode;

	public Long getIdProfiles() {
		return idProfiles;
	}

	public void setIdProfiles(Long idProfiles) {
		this.idProfiles = idProfiles;
	}

	public String getAddressProfile() {
		return addressProfile;
	}

	public void setAddressProfile(String addressProfile) {
		this.addressProfile = addressProfile;
	}

	public String getNameProfile() {
		return nameProfile;
	}

	public void setNameProfile(String nameProfile) {
		this.nameProfile = nameProfile;
	}

	public String getProfileCode() {
		return profileCode;
	}

	public void setProfileCode(String profileCode) {
		this.profileCode = profileCode;
	}
}

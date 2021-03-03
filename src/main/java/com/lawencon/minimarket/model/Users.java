package com.lawencon.minimarket.model;

/**
 *
 * @author Galih Dika
 *
 */

public class Users {

	private Long userId;
	private String username;
	private String pswd;
	private Roles idRoles;
	private Profiles idProfiles;
	private String userCode;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public Roles getIdRoles() {
		return idRoles;
	}

	public void setIdRoles(Roles idRoles) {
		this.idRoles = idRoles;
	}

	public Profiles getIdProfiles() {
		return idProfiles;
	}

	public void setIdProfiles(Profiles idProfiles) {
		this.idProfiles = idProfiles;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
}

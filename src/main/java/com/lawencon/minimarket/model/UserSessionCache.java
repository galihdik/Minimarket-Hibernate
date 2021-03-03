package com.lawencon.minimarket.model;

/**
 *
 * @author Galih Dika
 *
 */

public class UserSessionCache {
	private Users activeUser;

	public Users getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(Users activeUser) {
		this.activeUser = activeUser;
	}
}

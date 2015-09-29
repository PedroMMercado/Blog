package com.noobcoder.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	@Size(min = 6 , max = 12)
	@Pattern(regexp="^[a-zA-Z0-9]")
	private String userName;
	@Pattern(regexp="^[a-zA-Z0-9]")
	private String password;
	@Pattern(regexp="^[a-zA-Z0-9]")
	private String userDomain;
	private Boolean enabled;

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserDomain() {
		return userDomain;
	}

	public void setUserDomain(String userDomain) {
		this.userDomain = userDomain;
	}

}

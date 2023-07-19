package com.mis.dto;

public class LoginDTO {

	private String usid;
	private String upw;
	private String useCookie;

	public String getUsid() {
		return usid;
	}

	public void setUsid(String usid) {
		this.usid = usid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public String getUseCookie() {
		return useCookie;
	}

	public void setUseCookie(String useCookie) {
		this.useCookie = useCookie;
	}

	@Override
	public String toString() {
		return "LoginDTO [usid=" + usid + ", upw=" + upw + ", useCookie=" + useCookie + "]";
	}

}

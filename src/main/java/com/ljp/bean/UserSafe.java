package com.ljp.bean;

import java.util.Date;

public class UserSafe {
    @Override
	public String toString() {
		return "UserSafe [userId=" + userId + ", lastLoginDate=" + lastLoginDate + ", lastLoginIp=" + lastLoginIp
				+ ", lastLoginMac=" + lastLoginMac + ", lastLoginSource=" + lastLoginSource + ", updateDate="
				+ updateDate + ", registerData=" + registerData + ", registerSource=" + registerSource
				+ ", registerAdress=" + registerAdress + "]";
	}

	private String userId;

    private Date lastLoginDate;

    private String lastLoginIp;

    private String lastLoginMac;

    private String lastLoginSource;

    private Date updateDate;

    private Date registerData;

    private String registerSource;

    private String registerAdress;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    public String getLastLoginMac() {
        return lastLoginMac;
    }

    public void setLastLoginMac(String lastLoginMac) {
        this.lastLoginMac = lastLoginMac == null ? null : lastLoginMac.trim();
    }

    public String getLastLoginSource() {
        return lastLoginSource;
    }

    public void setLastLoginSource(String lastLoginSource) {
        this.lastLoginSource = lastLoginSource == null ? null : lastLoginSource.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getRegisterData() {
        return registerData;
    }

    public void setRegisterData(Date registerData) {
        this.registerData = registerData;
    }

    public String getRegisterSource() {
        return registerSource;
    }

    public void setRegisterSource(String registerSource) {
        this.registerSource = registerSource == null ? null : registerSource.trim();
    }

    public String getRegisterAdress() {
        return registerAdress;
    }

    public void setRegisterAdress(String registerAdress) {
        this.registerAdress = registerAdress == null ? null : registerAdress.trim();
    }
}
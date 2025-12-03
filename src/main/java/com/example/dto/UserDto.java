package com.example.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserDto {
	
	
	private Long userId;
    private String userName;
    private Integer gender;
    private LocalDate birthday;
    private String mailAddress;
    private String userPassword;
    private String phoneNumber;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
	
	//----------------------------------------------------------------
	//getter/setter
	//----------------------------------------------------------------
	
 // --- ゲッター (Getter: フィールドの値を取得) ---

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    // --- セッター (Setter: フィールドに値を設定) ---

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
	

}

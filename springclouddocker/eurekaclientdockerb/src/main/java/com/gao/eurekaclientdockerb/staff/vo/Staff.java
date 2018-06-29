package com.gao.eurekaclientdockerb.staff.vo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "staff")
public class Staff implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nickName")
    private String nickName;

    @Column(name = "passwd")
    private String passwd;
    
    @Column(name = "roleId")
    private Integer roleId;
    
    @Column (name="userId")
    private Integer userId;
    
    @Column(name = "mobile")
    private String mobile;
    
    @Column(name = "idCard")
    private String idCard;
    
    @Column(name = "trueName")
    private String trueName;
    
    @Column(name = "departmentId")
    private Integer departmentId;

    @Column(name = "accountType")
    private Integer accountType;

    @Column(name = "status")
    private Integer status;
    
    @Column(name = "auditingNum")
    private Integer auditingNum;
    
    @Column(name = "audit")
    private Integer audit;

    @Column(name = "accessToken")
    private String accessToken;

    @Column(name = "tokenValidTime")
    private Date tokenValidTime;
    
    //以下为非本表的字段，用作临时字段
  	@Transient
  	private String departmentName;
  	
  	@Transient
  	private String userRoleName;
  	
  	@Transient
  	private String thirdCompanyName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getAccountType() {
		return accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getAuditingNum() {
		return auditingNum;
	}

	public void setAuditingNum(Integer auditingNum) {
		this.auditingNum = auditingNum;
	}

	public Integer getAudit() {
		return audit;
	}

	public void setAudit(Integer audit) {
		this.audit = audit;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getUserRoleName() {
		return userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	public String getThirdCompanyName() {
		return thirdCompanyName;
	}

	public void setThirdCompanyName(String thirdCompanyName) {
		this.thirdCompanyName = thirdCompanyName;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Date getTokenValidTime() {
		return tokenValidTime;
	}

	public void setTokenValidTime(Date tokenValidTime) {
		this.tokenValidTime = tokenValidTime;
	}
}

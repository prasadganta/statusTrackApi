
package com.statustracker.springboot.model;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.data.annotation.Id;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "userName", "userTask", "iA", "entryTime", "blocker", "entryDate", "svcName" })

@Document(collection = "statusDetail")
@Component("statusDetail")
public class StatusDetail {

	@Id
	private String id;
	private String userName;
	private String userTask;
	
	private String iA;
	private String entryTime;
	private String blocker;
	private String entryDate;
	private String svcName;
	


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserTask() {
		return userTask;
	}

	public void setUserTask(String userTask) {
		this.userTask = userTask;
	}

	public String getiA() {
		return iA;
	}

	public void setiA(String iA) {
		this.iA = iA;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getBlocker() {
		return blocker;
	}

	public void setBlocker(String blocker) {
		this.blocker = blocker;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getSvcName() {
		return svcName;
	}

	public void setSvcName(String svcName) {
		this.svcName = svcName;
	}
}

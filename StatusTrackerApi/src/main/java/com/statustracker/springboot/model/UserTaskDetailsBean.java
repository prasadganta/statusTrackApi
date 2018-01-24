package com.statustracker.springboot.model;

import java.util.Date;

public class UserTaskDetailsBean {
	
       private String usrName;
       private Date entryDate;
       private Date entryTime;
       private String svcName;
       private String iA;
       private boolean blocker=false;
       private String usrTask;
       
       public String getUsrName() {
              return usrName;
       }
       public void setUsrName(String usrName) {
              this.usrName = usrName;
       }
       
       public Date getEntryDate() {
              return entryDate;
       }
       public void setEntryDate(Date entryDate) {
              this.entryDate = entryDate;
       }
       
       public Date getEntryTime() {
              return entryTime;
       }
       public void setEntryTime(Date entryTime) {
              this.entryTime = entryTime;
       }
       
       public String getSvcName() {
              return svcName;
       }
       public void setSvcName(String svcName) {
              this.svcName = svcName;
       }
       
       public String getiA() {
              return iA;
       }
       public void setiA(String iA) {
              this.iA = iA;
       }
       
       public boolean isBlocker() {
              return blocker;
       }
       public void setBlocker(boolean blocker) {
              this.blocker = blocker;
       }
       
       public String getUsrTask() {
              return usrTask;
       }
       public void setUsrTask(String usrTask) {
              this.usrTask = usrTask;
       }

}

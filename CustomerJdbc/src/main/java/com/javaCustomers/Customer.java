package com.javaCustomers;

public class Customer {
	


		
		private int cusId;
		private String cusName;
		private String cusPhoneNo;
		private String cusUserName;
		private String cusPassword;
		private String cusEmail;
		public int getCusId() {
			return cusId;
		}
		public void setCusId(int cusId) {
			this.cusId = cusId;
		}
		public String getCusName() {
			return cusName;
		}
		public void setCusName(String cusName) {
			this.cusName = cusName;
		}
		public String getCusPhoneNo() {
			return cusPhoneNo;
		}
		public void setCusPhoneNo(String cusPhoneNo) {
			this.cusPhoneNo = cusPhoneNo;
		}
		public String getCusUserName() {
			return cusUserName;
		}
		public void setCusUserName(String cusUserName) {
			this.cusUserName = cusUserName;
		}
		public String getCusPassword() {
			return cusPassword;
		}
		public void setCusPassword(String cusPassword) {
			this.cusPassword = cusPassword;
		}
		public String getCusEmail() {
			return cusEmail;
		}
		public void setCusEmail(String cusEmail) {
			this.cusEmail = cusEmail;
		}
		
		@Override
		public String toString() {
			return "Customer [cusId=" + cusId + ", cusName=" + cusName + ", cusPhoneNo=" + cusPhoneNo + ", cusUserName="
					+ cusUserName + ", cusPassword=" + cusPassword + ", cusEmail=" + cusEmail + "]";
		}
		public Customer(int cusId, String cusName, String cusPhoneNo, String cusUserName, String cusPassword,
				String cusEmail) {
			super();
			this.cusId = cusId;
			this.cusName = cusName;
			this.cusPhoneNo = cusPhoneNo;
			this.cusUserName = cusUserName;
			this.cusPassword = cusPassword;
			this.cusEmail = cusEmail;
		}
		
		   public Customer() {
		
		
		
		}
		

	}



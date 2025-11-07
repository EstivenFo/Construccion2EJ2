package app.adapter.in.rest.request;



public class UserRequest {

		private String fullName;
		private long idCard;
		private String email;
		private long phone;
		private long birthDate;
		private String address;


		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public long getIdCard() {
			return idCard;
		}

		public void setIdCard(long idCard) {
			this.idCard = idCard;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public long getPhone() {
			return phone;
		}

		public void setPhone(long phone) {
			this.phone = phone;
		}

		public long getBirthDate() {
			return birthDate;
		}

		public void setBirthDate(long birthDate) {
			this.birthDate = birthDate;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		
		}

	}
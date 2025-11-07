package app.adapter.rest.request;

public class PersonRequest {

    private String fullName;
    private String idCard;       // Se recibe como texto (por ejemplo: "1020456789")
    private String email;
    private String phone;        // Texto para conservar ceros iniciales o formatos especiales
    private String birthDate;    // Texto (por ejemplo: "1990-05-12")
    private String address;
    private String role;         // Texto ("ADMIN", "DOCTOR", "PATIENT", etc.)
    private String gender;       // Texto ("MALE", "FEMALE", "OTHER")

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

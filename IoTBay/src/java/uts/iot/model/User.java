package uts.iot.model;

public class User {
    private int customerID;
    private String UserName;
    private String email;
    private String FName;
    private String LName;
    private String Address;
    private String City;
    private String PostCode;
    private String PhoneNum;
    private String PWord;
    private String Gender;
    private java.sql.Date DOB;
    
    
    
    public User() {
    }

    public User(String UserName, String email, String FName, String LName, String Address, String City, String PostCode, String PhoneNum, String PWord, String Gender, java.sql.Date DOB) {
        this.UserName = UserName;
        this.email = email;
        this.FName = FName;
        this.LName = LName;
        this.Address = Address;
        this.City = City;
        this.PostCode = PostCode;
        this.PhoneNum = PhoneNum;
        this.PWord = PWord;
        this.Gender = Gender;
        this.DOB = DOB;
        
        
    }
    
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }
    
    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }    
    
    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }
    
    public String getPostCode() {
        return PostCode;
    }

    public void setPostCode(String PostCode) {
        this.PostCode = PostCode;
    }
    
    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(String PhoneNum) {
        this.PhoneNum = PhoneNum;
    }
    
    public String getPWord() {
        return PWord;
    }

    public void setPWord(String PWord) {
        this.PWord = PWord;
    }
    
    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }
    
    public java.sql.Date getDOB() {
        return DOB;
    }

    public void setDOB(java.sql.Date DOB) {
        this.DOB = DOB;
    }    
}

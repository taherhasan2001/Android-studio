package com.example.customerlist;
import java.util.ArrayList;

public class Customer {
    private long mCustomerId ;
    private String mName;
    private String mPhone;
    private String mGender;
    private String mCity;
    public Customer() {
    }
    public Customer(long mCustomerId, String mName, String mPhone, String mGender, String mCity)
    {
        this.mCustomerId = mCustomerId;
        this.mName = mName;
        this.mPhone = mPhone;
        this.mGender = mGender;
        this.mCity = mCity;
    }

    public String getmCity() {
        return mCity;
    }

    public void setmCity(String mCity) {
        this.mCity = mCity;
    }

    public long getmCustomerId() {
        return mCustomerId;
    }
    public void setmCustomerId(long mCustomerId) {
        this.mCustomerId = mCustomerId;
    }
    public String getmName() {
        return mName;
    }
    public void setmName(String mName) {
        this.mName = mName;
    }
    public String getmPhone() {
        return mPhone;
    }
    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }
    public String getmGender() {
        return mGender;
    }
    public void setmGender(String mGender) {
        this.mGender = mGender;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "\nmCustomerId=" + mCustomerId +
                "\n, mName='" + mName + '\'' +
                "\n, mPhone='" + mPhone + '\'' +
                "\n, mGender='" + mGender + '\'' +
                "\n, mCity='" + mCity + '\'' +
                "\n}\n\n";
    }
}
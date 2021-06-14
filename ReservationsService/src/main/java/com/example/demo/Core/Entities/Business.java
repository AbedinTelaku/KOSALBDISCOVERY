package com.example.demo.Core.Entities;

import javax.persistence.Embeddable;

@Embeddable
public class Business {
    private String businessName;
    private String businessEmail;
    private String businessPhoneNumber;

    public Business(String businessName, String businessEmail, String businessPhoneNumber) {
        this.businessName = businessName;
        this.businessEmail = businessEmail;
        this.businessPhoneNumber = businessPhoneNumber;
    }

    public Business() {
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessEmail() {
        return businessEmail;
    }

    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail;
    }

    public String getBusinessPhoneNumber() {
        return businessPhoneNumber;
    }

    public void setBusinessPhoneNumber(String businessPhoneNumber) {
        this.businessPhoneNumber = businessPhoneNumber;
    }
}

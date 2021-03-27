package com.bkotte.contact.service.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Contact {

    @Id
    private String email;

    private String mobile;

    private String mobileCode;

    private String name;

    private String gender;

    private String dob;

    private String maritalStatus;

    private String dom;

    private String spouseName;

    private String spouseDob;

    private String address;

    private String pinCode;

    private String country;

    private String bankName;

    private String bankIfsc;

    private String bankAccountNo;

    private String vpa;

}

package com.ltgsas.mybatis.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Casebase {
    private Integer ID; // Table Column name: id
    private Integer CBID; // Table Column name: cbid;
    private String cName; // Table Column name: cname;
    private String aliasName; // Table Column name: alias_name;
    private String grade; // Table Column name: grade;
    private Short age; // Table Column name: age;
    private String eMail; // Table Column name: email;
    private String IDNumber; // Table Column name: identity_card;
    private Character gender; // Table Column name: gender;
    private Boolean member; // Table Column name: member;
    private String mobile; // Table Column name: mobile;
    private String address; // Table Column name: address;
    private Date joinDate; // Table Column name: join_Date;
    private Casescore casescore;
}

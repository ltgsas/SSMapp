package com.ltgsas.mybatis.pojo;

public class Tdbassistan {
    private Integer ID;
    private String sname;
    private String email;
    private Short number;
    private Float score;

    public Tdbassistan() {
    }

    public Tdbassistan(String sname, String email, Short number, Float score) {
        this.sname = sname;
        this.email = email;
        this.number = number;
        this.score = score;
    }

    public Tdbassistan(Integer ID, String sname, String email, Short number, Float score) {
        this.ID = ID;
        this.sname = sname;
        this.email = email;
        this.number = number;
        this.score = score;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Short getNumber() {
        return number;
    }

    public void setNumber(Short number) {
        this.number = number;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Tdbassistan{" +
                "ID=" + ID +
                ", sname='" + sname + '\'' +
                ", email='" + email + '\'' +
                ", number=" + number +
                ", score=" + score +
                '}';
    }
}

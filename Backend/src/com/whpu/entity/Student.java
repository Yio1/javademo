package com.whpu.entity;

public class Student {
    private Integer sid;
    private String sname;
    private String sno;
    private int gradeid;
    private String address;
    private Integer score;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public int getGradeid() {
        return gradeid;
    }

    public void setGradeid(int gradeid) {
        this.gradeid = gradeid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
            "sid=" + sid +
            ", sname='" + sname + '\'' +
            ", sno='" + sno + '\'' +
            ", gradeid=" + gradeid +
            ", address='" + address + '\'' +
            ", score=" + score +
            '}';
    }
}

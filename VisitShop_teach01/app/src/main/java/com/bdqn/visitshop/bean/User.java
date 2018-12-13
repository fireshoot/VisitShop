package com.bdqn.visitshop.bean;

/**
 * 作者：Leon
 * 时间：2017/7/5
 * 描述:
 */
public class User {
    private int id;
    private String userId;
    private String passWord;
    private String job;
    private String nickName;
    private int sex;// 性别 1:男,0:女
    private String img;
    private String phoneNum;
    private String area;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", passWord='" + passWord + '\'' +
                ", job='" + job + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex=" + sex +
                ", img='" + img + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}

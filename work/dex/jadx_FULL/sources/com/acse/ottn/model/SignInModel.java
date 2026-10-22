package com.acse.ottn.model;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SignInModel {
    private String points;
    private int r;
    private List<SignBean> sign = new ArrayList();
    private int sign_in;

    public static class SignBean {
        private String day;
        private String points;
        private int sign;

        public String getDay() {
            return this.day;
        }

        public String getPoints() {
            return this.points;
        }

        public int getSign() {
            return this.sign;
        }

        public void setDay(String str) {
            this.day = str;
        }

        public void setPoints(String str) {
            this.points = str;
        }

        public void setSign(int i) {
            this.sign = i;
        }
    }

    public String getPoints() {
        return this.points;
    }

    public int getR() {
        return this.r;
    }

    public List<SignBean> getSign() {
        return this.sign;
    }

    public int getSign_in() {
        return this.sign_in;
    }

    public void setPoints(String str) {
        this.points = str;
    }

    public void setR(int i) {
        this.r = i;
    }

    public void setSign(List<SignBean> list) {
        this.sign = list;
    }

    public void setSign_in(int i) {
        this.sign_in = i;
    }
}

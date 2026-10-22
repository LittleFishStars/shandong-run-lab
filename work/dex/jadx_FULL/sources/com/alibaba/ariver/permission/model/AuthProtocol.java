package com.alibaba.ariver.permission.model;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AuthProtocol {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24365a;
    private String b;

    public AuthProtocol(String str, String str2) {
        this.f24365a = str;
        this.b = str2;
    }

    public String getLink() {
        return this.b;
    }

    public String getName() {
        return this.f24365a;
    }

    public void setLink(String str) {
        this.b = str;
    }

    public void setName(String str) {
        this.f24365a = str;
    }
}

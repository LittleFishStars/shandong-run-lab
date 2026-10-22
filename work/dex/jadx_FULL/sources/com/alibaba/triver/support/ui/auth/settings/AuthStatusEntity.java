package com.alibaba.triver.support.ui.auth.settings;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AuthStatusEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f25170a;
    private String b;
    private String c;
    private boolean d;
    private AuthType e;
    private boolean f;
    private List<AuthStatusEntity> g;

    public enum AuthType {
        Device,
        UserInfo,
        Subscribe
    }

    public String a() {
        return this.f25170a;
    }

    public String b() {
        return this.b;
    }

    public AuthType c() {
        return this.e;
    }

    public List<AuthStatusEntity> d() {
        return this.g;
    }

    public boolean e() {
        return this.f;
    }

    public String f() {
        return this.c;
    }

    public boolean g() {
        return this.d;
    }

    public void a(String str) {
        this.f25170a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public void a(AuthType authType) {
        this.e = authType;
    }

    public void b(boolean z) {
        this.d = z;
    }

    public void a(List<AuthStatusEntity> list) {
        this.g = list;
    }

    public void a(boolean z) {
        this.f = z;
    }
}

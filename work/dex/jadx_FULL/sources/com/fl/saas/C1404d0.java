package com.fl.saas;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/* JADX INFO: renamed from: com.fl.saas.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class C1404d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f30155a;
    private String b;
    private String c;
    private int d;
    private int e;
    private int f;

    public String a() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.f30155a;
    }

    public int f() {
        return this.f;
    }

    public void a(String str) {
        this.c = str;
    }

    public void b(int i) {
        this.e = i;
    }

    public void c(String str) {
        this.f30155a = str;
    }

    public void a(int i) {
        this.d = i;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.b = new String(AbstractC1421m.b(str), StandardCharsets.UTF_8);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public void c(int i) {
        this.f = i;
    }
}

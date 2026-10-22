package com.beizi.fusion.asnp.common.analyse2.db;

import android.text.TextUtils;
import com.beizi.fusion.f3;
import com.beizi.fusion.ka;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AnalyseEventDBModel extends ka {
    private byte[] e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27083a = "";
    private String b = "";
    private String c = "";
    private String d = "";
    private boolean f = false;

    public void a(byte[] bArr) {
        this.e = bArr;
    }

    public void b(String str) {
        this.f27083a = str;
    }

    public String c() {
        return this.c;
    }

    public byte[] d() {
        byte[] bArr = this.e;
        if (bArr != null) {
            return bArr;
        }
        if (TextUtils.isEmpty(this.d)) {
            return null;
        }
        return f3.a(this.d);
    }

    public String e() {
        return this.f27083a;
    }

    public boolean f() {
        return this.f;
    }

    public void setEventTime(String str) {
        this.b = str;
    }

    public void a(String str) {
        this.c = str;
    }

    public void b() {
        byte[] bArr = this.e;
        if (bArr != null) {
            this.d = f3.d(bArr);
            this.e = null;
        }
    }

    public void a(boolean z) {
        this.f = z;
    }
}

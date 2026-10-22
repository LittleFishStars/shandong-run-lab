package com.autonavi.aps.amapapi.trans;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003l.hm;
import com.zj.adlib.r4b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class d extends hm {
    Map<String, String> h;
    String i;
    String j;
    byte[] k;
    byte[] l;
    boolean m;
    String n;
    Map<String, String> o;
    boolean p;
    private String q;

    public d(Context context, r4b r4bVar) {
        super(context, r4bVar);
        this.h = null;
        this.q = "";
        this.i = "";
        this.j = "";
        this.k = null;
        this.l = null;
        this.m = false;
        this.n = null;
        this.o = null;
        this.p = false;
    }

    public final void a(Map<String, String> map) {
        this.o = map;
    }

    public final void b(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            if (bArr != null) {
                try {
                    byteArrayOutputStream2.write(hm.a(bArr));
                    byteArrayOutputStream2.write(bArr);
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    try {
                        th.printStackTrace();
                        if (byteArrayOutputStream != null) {
                            try {
                                return;
                            } catch (IOException e) {
                                return;
                            }
                        }
                        return;
                    } finally {
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            }
            this.l = byteArrayOutputStream2.toByteArray();
            try {
                byteArrayOutputStream2.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void c(byte[] bArr) {
        this.k = bArr;
    }

    @Override // com.amap.api.col.p0003l.hm
    public final byte[] d() {
        return this.l;
    }

    @Override // com.amap.api.col.p0003l.hm
    public final boolean f() {
        return this.m;
    }

    @Override // com.amap.api.col.p0003l.hm
    public final String g() {
        return this.n;
    }

    @Override // com.amap.api.col.p0003l.hs
    public final String getIPDNSName() {
        return this.q;
    }

    @Override // com.amap.api.col.p0003l.fm, com.amap.api.col.p0003l.hs
    public final String getIPV6URL() {
        return this.j;
    }

    @Override // com.amap.api.col.p0003l.hm, com.amap.api.col.p0003l.hs
    public final Map<String, String> getParams() {
        return this.o;
    }

    @Override // com.amap.api.col.p0003l.hs
    public final Map<String, String> getRequestHead() {
        return this.h;
    }

    @Override // com.amap.api.col.p0003l.hs
    public final String getSDKName() {
        return "loc";
    }

    @Override // com.amap.api.col.p0003l.hs
    public final String getURL() {
        return this.i;
    }

    @Override // com.amap.api.col.p0003l.hm
    public final boolean h() {
        return this.p;
    }

    public final void a(String str) {
        this.n = str;
    }

    public final void c(String str) {
        this.j = str;
    }

    public final void d(String str) {
        if (TextUtils.isEmpty(str)) {
            this.q = "";
        } else {
            this.q = str;
        }
    }

    public final void a(boolean z) {
        this.m = z;
    }

    @Override // com.amap.api.col.p0003l.hm
    public final byte[] c() {
        return this.k;
    }

    public final void b(String str) {
        this.i = str;
    }

    public final void b(Map<String, String> map) {
        this.h = map;
    }

    public final void b(boolean z) {
        this.p = z;
    }
}

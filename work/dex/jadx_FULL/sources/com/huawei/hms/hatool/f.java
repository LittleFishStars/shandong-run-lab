package com.huawei.hms.hatool;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class f implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f37555a;
    private String b;
    private String c;
    private String d;
    private String e;
    private List<b1> f;

    public f(byte[] bArr, String str, String str2, String str3, String str4, List<b1> list) {
        this.f37555a = (byte[]) bArr.clone();
        this.b = str;
        this.c = str2;
        this.e = str3;
        this.d = str4;
        this.f = list;
    }

    private n0 a(Map<String, String> map) {
        return w.a(this.b, this.f37555a, map);
    }

    private Map<String, String> a() {
        return k.b(this.c, this.e, this.d);
    }

    private void b() {
        b0.c().a(new d1(this.f, this.c, this.d, this.e));
    }

    @Override // java.lang.Runnable
    public void run() {
        v.c("hmsSdk", "send data running");
        int iB = a(a()).b();
        if (iB != 200) {
            b();
            return;
        }
        v.b("hmsSdk", "events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:" + this.d, this.e, this.c, Integer.valueOf(iB));
    }
}

package com.baidu.mshield.x6.e;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f26762a;

    public d(Context context) {
        this.f26762a = context;
    }

    public void a() {
        try {
            com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(this.f26762a);
            String strA = com.baidu.mshield.x6.c.a.a(this.f26762a);
            String strB = com.baidu.mshield.x6.c.a.b(this.f26762a);
            String strO = bVar.O();
            String strN = bVar.N();
            if (!TextUtils.isEmpty(strO)) {
                strO = com.baidu.mshield.b.f.e.a(strO);
                bVar.o(strO);
            }
            if (!TextUtils.isEmpty(strN)) {
                strN = com.baidu.mshield.b.f.e.a(strN);
                bVar.n(strN);
            }
            if (TextUtils.isEmpty(strA)) {
                if (TextUtils.isEmpty(strB)) {
                    if (TextUtils.isEmpty(strO)) {
                        return;
                    }
                    bVar.e(true);
                    bVar.o("");
                    bVar.n("");
                    return;
                }
                if (strN.equals(com.baidu.mshield.b.f.e.a(strB))) {
                    return;
                }
                bVar.e(true);
                bVar.o("");
                bVar.n(com.baidu.mshield.b.f.e.a(strB));
                return;
            }
            if (TextUtils.isEmpty(strB)) {
                if (strO.equals(com.baidu.mshield.b.f.e.a(strA))) {
                    return;
                }
                bVar.e(true);
                bVar.o(com.baidu.mshield.b.f.e.a(strA));
                bVar.n("");
                return;
            }
            if (strO.equals(com.baidu.mshield.b.f.e.a(strA)) && strN.equals(com.baidu.mshield.b.f.e.a(strB))) {
                return;
            }
            bVar.e(true);
            bVar.o(com.baidu.mshield.b.f.e.a(strA));
            bVar.n(com.baidu.mshield.b.f.e.a(strB));
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
    }
}

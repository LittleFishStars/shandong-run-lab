package com.zj.adlib;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003l.fj;
import com.amap.api.col.p0003l.ip;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ybb extends ip {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f45992a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f20823a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f20825a;
    public int b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f20824a = "iKey";
    public int c = 0;

    public ybb(Context context, boolean z, int i, int i2, String str) {
        e(context, z, i, i2, str, 0);
    }

    @Override // com.amap.api.col.p0003l.ip
    public final int a() {
        int i;
        if ((fj.Y(this.f20823a) == 1 || (i = this.f45992a) <= 0) && ((i = this.c) <= 0 || i >= Integer.MAX_VALUE)) {
            i = Integer.MAX_VALUE;
        }
        ip ipVar = ((ip) this).f25975a;
        return ipVar != null ? Math.max(i, ipVar.a()) : i;
    }

    @Override // com.amap.api.col.p0003l.ip
    public final void b(int i) {
        if (fj.Y(this.f20823a) == 1) {
            return;
        }
        String strC = s4b.c(System.currentTimeMillis(), "yyyyMMdd");
        String strA = y6b.a(this.f20823a, this.f20824a);
        if (!TextUtils.isEmpty(strA)) {
            String[] strArrSplit = strA.split("\\|");
            if (strArrSplit == null || strArrSplit.length < 2) {
                y6b.g(this.f20823a, this.f20824a);
            } else if (strC.equals(strArrSplit[0])) {
                i += Integer.parseInt(strArrSplit[1]);
            }
        }
        y6b.d(this.f20823a, this.f20824a, strC + "|" + i);
    }

    @Override // com.amap.api.col.p0003l.ip
    public final boolean c() {
        if (fj.Y(this.f20823a) == 1) {
            return true;
        }
        if (!this.f20825a) {
            return false;
        }
        String strA = y6b.a(this.f20823a, this.f20824a);
        if (TextUtils.isEmpty(strA)) {
            return true;
        }
        String[] strArrSplit = strA.split("\\|");
        if (strArrSplit != null && strArrSplit.length >= 2) {
            return !s4b.c(System.currentTimeMillis(), "yyyyMMdd").equals(strArrSplit[0]) || Integer.parseInt(strArrSplit[1]) < this.b;
        }
        y6b.g(this.f20823a, this.f20824a);
        return true;
    }

    public final void e(Context context, boolean z, int i, int i2, String str, int i3) {
        this.f20823a = context;
        this.f20825a = z;
        this.f45992a = i;
        this.b = i2;
        this.f20824a = str;
        this.c = i3;
    }

    public ybb(Context context, boolean z, int i, int i2, String str, int i3) {
        e(context, z, i, i2, str, i3);
    }
}

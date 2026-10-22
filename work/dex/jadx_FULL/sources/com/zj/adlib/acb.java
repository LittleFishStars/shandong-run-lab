package com.zj.adlib;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003l.ip;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class acb extends ip {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f40507a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f15248a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f15249a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f15250a;

    public acb(Context context, int i, String str, ip ipVar) {
        super(ipVar);
        this.f40507a = i;
        this.f15250a = str;
        this.f15249a = context;
    }

    @Override // com.amap.api.col.p0003l.ip
    public final boolean c() {
        if (this.f15248a == 0) {
            String strA = y6b.a(this.f15249a, this.f15250a);
            this.f15248a = TextUtils.isEmpty(strA) ? 0L : Long.parseLong(strA);
        }
        return System.currentTimeMillis() - this.f15248a >= ((long) this.f40507a);
    }

    @Override // com.amap.api.col.p0003l.ip
    public final void c(boolean z) {
        super.c(z);
        if (z) {
            String str = this.f15250a;
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f15248a = jCurrentTimeMillis;
            y6b.d(this.f15249a, str, String.valueOf(jCurrentTimeMillis));
        }
    }
}

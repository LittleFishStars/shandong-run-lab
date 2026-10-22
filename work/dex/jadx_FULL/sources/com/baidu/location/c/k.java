package com.baidu.location.c;

import android.net.wifi.ScanResult;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<ScanResult> f26442a;
    public long b;
    public long c;
    public boolean e;
    public boolean d = false;
    public String f = null;
    public String g = null;

    public k(List<ScanResult> list, long j) {
        this.c = 0L;
        this.b = j;
        this.f26442a = list;
        this.c = System.currentTimeMillis();
        try {
            d();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private void d() {
        /*
            r7 = this;
            int r0 = r7.a()
            r1 = 1
            if (r0 >= r1) goto L8
            return
        L8:
            java.util.List<android.net.wifi.ScanResult> r0 = r7.f26442a
            int r0 = r0.size()
            int r0 = r0 - r1
            r2 = r1
        L10:
            if (r0 < r1) goto L60
            if (r2 == 0) goto L60
            r2 = 0
            r3 = r2
        L16:
            if (r2 >= r0) goto L5c
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f26442a
            java.lang.Object r4 = r4.get(r2)
            if (r4 == 0) goto L59
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f26442a
            int r5 = r2 + 1
            java.lang.Object r4 = r4.get(r5)
            if (r4 == 0) goto L59
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f26442a
            java.lang.Object r4 = r4.get(r2)
            android.net.wifi.ScanResult r4 = (android.net.wifi.ScanResult) r4
            int r4 = r4.level
            java.util.List<android.net.wifi.ScanResult> r6 = r7.f26442a
            java.lang.Object r6 = r6.get(r5)
            android.net.wifi.ScanResult r6 = (android.net.wifi.ScanResult) r6
            int r6 = r6.level
            if (r4 >= r6) goto L59
            java.util.List<android.net.wifi.ScanResult> r3 = r7.f26442a
            java.lang.Object r3 = r3.get(r5)
            android.net.wifi.ScanResult r3 = (android.net.wifi.ScanResult) r3
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f26442a
            java.lang.Object r6 = r4.get(r2)
            android.net.wifi.ScanResult r6 = (android.net.wifi.ScanResult) r6
            r4.set(r5, r6)
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f26442a
            r4.set(r2, r3)
            r3 = r1
        L59:
            int r2 = r2 + 1
            goto L16
        L5c:
            int r0 = r0 + (-1)
            r2 = r3
            goto L10
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.k.d():void");
    }

    public int a() {
        List<ScanResult> list = this.f26442a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public boolean a(k kVar) {
        List<ScanResult> list = this.f26442a;
        if (list == null || kVar == null || kVar.f26442a == null) {
            return false;
        }
        int iMin = Math.min(list.size(), kVar.f26442a.size());
        for (int i = 0; i < iMin; i++) {
            if (this.f26442a.get(i) != null) {
                String str = this.f26442a.get(i).BSSID;
                int i2 = this.f26442a.get(i).level;
                String str2 = kVar.f26442a.get(i).BSSID;
                int i3 = kVar.f26442a.get(i).level;
                if ((!TextUtils.isEmpty(str) && !str.equals(str2)) || i2 != i3) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean a(k kVar, float f) {
        return com.baidu.location.c.a.b.a(kVar, this, f);
    }

    public boolean b() {
        return System.currentTimeMillis() - this.c > 0 && System.currentTimeMillis() - this.c < 5000;
    }

    public boolean c() {
        return System.currentTimeMillis() - this.b > 0 && System.currentTimeMillis() - this.b < 5000;
    }
}

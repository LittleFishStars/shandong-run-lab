package com.byazt.hr;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 29, 20})
public class c {
    public String c;
    public String tt;
    public String uj;
    public long ve;

    public c(String str, String str2, long j) {
        this(str, str2, j, null);
    }

    public long c() {
        return this.ve;
    }

    public String toString() {
        return "AdnLoadFailShowBean{slotId='" + this.c + "', adnName='" + this.tt + "', effectiveTime=" + this.ve + '}';
    }

    public String tt() {
        return this.uj;
    }

    public c(String str, String str2, long j, String str3) {
        this.c = str2;
        this.tt = str;
        this.ve = j;
        this.uj = str3;
    }
}

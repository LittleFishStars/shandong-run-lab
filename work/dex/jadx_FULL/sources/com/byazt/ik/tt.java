package com.byazt.ik;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2058, 13})
public class tt {
    public String c;
    public long n;
    public String tt;
    public String uj;
    public String ve;

    public void c(String str) {
        this.c = str;
    }

    public String toString() {
        return "MediationBehaviorDbData{primeRit='" + this.c + "', adnRit='" + this.tt + "', adnName='" + this.ve + "', adAction='" + this.uj + "', timeStamp=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(this.n)) + '}';
    }

    public void tt(String str) {
        this.tt = str;
    }

    public void uj(String str) {
        this.uj = str;
    }

    public void ve(String str) {
        this.ve = str;
    }

    public String c() {
        return this.uj;
    }

    public void c(long j) {
        this.n = j;
    }
}

package com.alibaba.appmonitor.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@com.alibaba.analytics.core.b.a.c("alarm_temp")
public class a extends c {

    @com.alibaba.analytics.core.b.a.a("arg")
    public String aT;

    @com.alibaba.analytics.core.b.a.a("err_code")
    public String bj;

    @com.alibaba.analytics.core.b.a.a("err_msg")
    public String bk;

    @com.alibaba.analytics.core.b.a.a("success")
    public String bl;

    public a() {
    }

    @Override // com.alibaba.appmonitor.b.c
    public String toString() {
        return "TempAlarm{ module='" + this.module + "', monitorPoint='" + this.monitorPoint + "', commitTime=" + this.m + ", access='" + this.aj + "', accessSubType='" + this.ak + "', arg='" + this.aT + "', errCode='" + this.bj + "', errMsg='" + this.bk + "', success='" + this.bl + "'}";
    }

    public boolean y() {
        return "1".equalsIgnoreCase(this.bl);
    }

    public a(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7) {
        super(str, str2, str6, str7);
        this.aT = str3;
        this.bj = str4;
        this.bk = str5;
        this.bl = z ? "1" : "0";
    }
}

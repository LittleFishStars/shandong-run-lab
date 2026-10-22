package com.alibaba.appmonitor.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@com.alibaba.analytics.core.b.a.c("counter_temp")
public class b extends c {

    @com.alibaba.analytics.core.b.a.a("arg")
    public String aT;

    @com.alibaba.analytics.core.b.a.a("value")
    public double value;

    public b(String str, String str2, String str3, double d, String str4, String str5) {
        super(str, str2, str4, str5);
        this.aT = str3;
        this.value = d;
    }

    @Override // com.alibaba.appmonitor.b.c
    public String toString() {
        return "TempCounter{arg='" + this.aT + "', value=" + this.value + '}';
    }

    public b() {
    }
}

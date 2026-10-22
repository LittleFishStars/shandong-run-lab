package com.alipay.android.phone.mobilesdk.socketcraft.e;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25294a = "connect";
    public static final String b = "close";
    public static final String c = "send";
    public static final String d = "receive";
    public String e;
    public String f;
    public String g;
    public int h;
    public int i;

    public a(String str, String str2, String str3, int i, int i2) {
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = i;
        this.i = i2;
    }

    public String toString() {
        return "DataflowMonitorModel{url='" + this.e + "', ownerId=" + this.f + ", methodName=" + this.g + ", sendSize=" + this.h + ", receiveSize=" + this.i + '}';
    }
}

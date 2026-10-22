package com.ali.auth.third.core.cookies;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f23416a;
    public String b;
    public String c;
    public String d;
    public long e;
    public boolean f;
    public boolean g;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.c);
        sb.append("=");
        sb.append(this.d);
        sb.append("; ");
        sb.append("Domain=");
        sb.append(this.f23416a);
        if (this.e > 0) {
            sb.append("; ");
            sb.append("Expires=");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            sb.append(simpleDateFormat.format(Long.valueOf(this.e)));
        }
        sb.append("; ");
        sb.append("Path=");
        sb.append(this.b);
        if (this.f) {
            sb.append("; ");
            sb.append("Secure");
        }
        if (this.g) {
            sb.append("; ");
            sb.append("HttpOnly");
        }
        return sb.toString();
    }
}

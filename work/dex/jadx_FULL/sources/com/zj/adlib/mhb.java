package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class mhb {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f18215a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f18216a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public short f18217a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18218a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f18219b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f43306a = -113;
    public long c = 0;

    public mhb(boolean z) {
        this.f18218a = z;
    }

    public static long a(String str) {
        long j;
        if (str == null || str.length() == 0) {
            return 0L;
        }
        int i = 0;
        long j2 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            long jCharAt = str.charAt(length);
            if (jCharAt < 48 || jCharAt > 57) {
                long j3 = 97;
                if (jCharAt < 97 || jCharAt > 102) {
                    j3 = 65;
                    if (jCharAt < 65 || jCharAt > 70) {
                        if (jCharAt != 58 && jCharAt != 124) {
                            return 0L;
                        }
                    }
                }
                j = (jCharAt - j3) + 10;
            } else {
                j = jCharAt - 48;
            }
            j2 += j << i;
            i += 4;
        }
        if (i != 48) {
            return 0L;
        }
        return j2;
    }

    public static String c(long j) {
        if (j < 0 || j > 281474976710655L) {
            return null;
        }
        return shb.a(shb.b(j), u15.f19942b);
    }

    public final String b() {
        return this.f18218a + "#" + this.f18215a;
    }

    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final mhb clone() {
        mhb mhbVar = new mhb(this.f18218a);
        mhbVar.f18215a = this.f18215a;
        mhbVar.f18216a = this.f18216a;
        mhbVar.f43306a = this.f43306a;
        mhbVar.b = this.b;
        mhbVar.f18219b = this.f18219b;
        mhbVar.c = this.c;
        mhbVar.f18217a = this.f18217a;
        mhbVar.f18218a = this.f18218a;
        return mhbVar;
    }

    public final String toString() {
        return "AmapWifi{mac=" + this.f18215a + ", ssid='" + this.f18216a + "', rssi=" + this.f43306a + ", frequency=" + this.b + ", timestamp=" + this.f18219b + ", lastUpdateUtcMills=" + this.c + ", freshness=" + ((int) this.f18217a) + ", connected=" + this.f18218a + '}';
    }
}

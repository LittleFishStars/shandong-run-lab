package com.zj.adlib;

import android.os.SystemClock;
import com.amap.api.col.p0003l.ka;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class qeb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile qeb f44195a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Object f19084a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f19085a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public lhb f19087a;
    public lhb b = new lhb();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public peb f19088a = new peb();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public reb f19089a = new reb();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public dcb f19086a = new dcb();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte f44196a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f19090a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public lhb f19091a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f19092a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public List<mhb> f19093a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f19094a;
        public long b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public List<ka> f19095b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f19096b;
        public long c;
    }

    public static qeb a() {
        if (f44195a == null) {
            synchronized (f19084a) {
                if (f44195a == null) {
                    f44195a = new qeb();
                }
            }
        }
        return f44195a;
    }

    public final ueb b(a aVar) {
        ueb uebVar = null;
        if (aVar == null) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        lhb lhbVar = this.f19087a;
        if (lhbVar == null || aVar.f19091a.a(lhbVar) >= 10.0d) {
            peb.a aVarA = this.f19088a.a(aVar.f19091a, aVar.f19096b, aVar.f44196a, aVar.f19092a, aVar.f19095b);
            List<mhb> listA = this.f19089a.a(aVar.f19091a, aVar.f19093a, aVar.f19094a, aVar.b, jCurrentTimeMillis);
            if (aVarA != null || listA != null) {
                ofb.a(this.b, aVar.f19091a, aVar.c, jCurrentTimeMillis);
                uebVar = new ueb(0, this.f19086a.f(this.b, aVarA, aVar.f19090a, listA));
            }
            this.f19087a = aVar.f19091a;
            this.f19085a = jElapsedRealtime;
        }
        return uebVar;
    }
}

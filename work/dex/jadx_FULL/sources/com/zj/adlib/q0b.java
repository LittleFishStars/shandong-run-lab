package com.zj.adlib;

import android.util.Log;
import com.amap.api.col.p0003l.ea;
import com.amap.api.col.p0003l.r;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class q0b implements ea {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, a> f44096a = new ConcurrentHashMap();

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f44097a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f18972a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final AtomicInteger f18973a = new AtomicInteger(0);
        public String b;

        public a(int i, String str, String str2) {
            this.f18972a = str;
            this.b = str2;
            this.f44097a = i;
        }

        public final int a() {
            return this.f18973a.incrementAndGet();
        }
    }

    public static void b(int i, String str, String str2, int i2) {
        if (i == 0) {
            r.c(zwa.t()).i(m6b.b(str, str2 + " counter " + i2));
        } else {
            r.c(zwa.t()).i(m6b.b(str, str2 + " counter " + i2));
        }
        if (axa.f15411b) {
            d(i, str, str2 + " counter " + i2);
        }
    }

    public static String c(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        if (str == null) {
            str = "";
        }
        sb.append(str);
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        return sb.toString();
    }

    public static void d(int i, String str, String str2) {
        if (i == 0) {
            Log.i("linklog", str + " " + str2);
            return;
        }
        Log.e("linklog", str + " " + str2);
    }

    @Override // com.amap.api.col.p0003l.ea
    public final void a(int i, String str, String str2) {
        try {
            String strC = c(i, str, str2);
            a aVar = f44096a.get(strC);
            if (aVar == null) {
                aVar = new a(i, str, str2);
                f44096a.put(strC, aVar);
            }
            if (aVar.a() > 100) {
                b(aVar.f44097a, aVar.f18972a, aVar.b, aVar.f18973a.get());
                f44096a.remove(strC);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.amap.api.col.p0003l.ea
    public final void a() {
        try {
            Iterator<Map.Entry<String, a>> it = f44096a.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (value != null) {
                    b(value.f44097a, value.f18972a, value.b, value.f18973a.get());
                }
            }
            f44096a.clear();
            r.c(zwa.t()).e();
        } catch (Throwable unused) {
        }
    }
}

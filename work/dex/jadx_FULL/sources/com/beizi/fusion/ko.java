package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ko {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27483a;
    private final Map b = new ArrayMap();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f27484a;

        static {
            int[] iArr = new int[d.values().length];
            f27484a = iArr;
            try {
                iArr[d.INTERSTITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27484a[d.SPLASH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f27484a[d.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f27484a[d.BANNER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f27484a[d.VIDEO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public ko(Context context) {
        this.f27483a = context.getApplicationContext();
    }

    private void c() {
        long jA = a("UPT", 0L);
        if (jA == 0) {
            jA = System.currentTimeMillis();
            b("UPT", jA);
        }
        this.b.put("UPT", Long.valueOf(jA));
    }

    public boolean a(long j) {
        Map map = this.b;
        if (map != null && map.containsKey("UPT")) {
            Long l = (Long) this.b.get("UPT");
            if (System.currentTimeMillis() - (l != null ? l.longValue() : 0L) < j) {
                return true;
            }
        }
        return false;
    }

    public void b(d dVar) {
        String strA = a(dVar);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.b.put(strA, Long.valueOf(jCurrentTimeMillis));
        b(strA, jCurrentTimeMillis);
    }

    public void d() {
        c();
        b();
    }

    public boolean a(d dVar, long j) {
        Map map;
        String strA = a(dVar);
        if (!TextUtils.isEmpty(strA) && (map = this.b) != null && map.containsKey(strA)) {
            Long l = (Long) this.b.get(strA);
            if (System.currentTimeMillis() - (l != null ? l.longValue() : 0L) < j) {
                return true;
            }
        }
        return false;
    }

    private void b() {
        String[] strArr = {"SCD", "BCD", "NCD", "ICD", "VCD"};
        for (int i = 0; i < 5; i++) {
            String str = strArr[i];
            long jA = a(str, 0L);
            if (jA != 0) {
                this.b.put(str, Long.valueOf(jA));
            }
        }
    }

    private String a(d dVar) {
        int i = a.f27484a[dVar.ordinal()];
        if (i == 1) {
            return "ICD";
        }
        if (i == 2) {
            return "SCD";
        }
        if (i == 3) {
            return "NCD";
        }
        if (i == 4) {
            return "BCD";
        }
        if (i != 5) {
            return null;
        }
        return "VCD";
    }

    private long a(String str, long j) {
        return (TextUtils.isEmpty(str) || !p0.a(this.f27483a, a(), str)) ? j : p0.a(this.f27483a, a(), str, j);
    }

    private void b(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        p0.b(this.f27483a, a(), str, j);
    }

    private String a() {
        return String.format("asnp_user_%s", m0.a());
    }
}

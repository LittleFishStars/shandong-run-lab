package com.baidu.location.b;

import android.location.Location;
import android.os.Bundle;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class h {
    private static String b = "NULL";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f26356a = false;
    private long c = -1;
    private int d = -1;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final h f26357a = new h();
    }

    private int a(String str) {
        return d.a(str);
    }

    public static h a() {
        return a.f26357a;
    }

    private String b(Location location) {
        StringBuilder sb = new StringBuilder();
        sb.append(location.getAccuracy());
        sb.append("|");
        sb.append(com.baidu.location.c.d.f26424a);
        sb.append("|");
        Bundle extras = location.getExtras();
        if (extras == null || !extras.containsKey("meanCn0")) {
            sb.append(-1);
        } else {
            sb.append(extras.get("meanCn0"));
        }
        sb.append("|");
        if (extras == null || !extras.containsKey("SourceType")) {
            sb.append(-1);
        } else {
            sb.append(extras.get("SourceType"));
        }
        sb.append("|");
        sb.append(b);
        return sb.toString();
    }

    private void d() {
        String strA = com.baidu.location.e.b.b.a().a(com.baidu.location.e.b.b.EnumC0267b.GPS_CHECKER_STATUS);
        if (strA != null && d.a(strA, c.b().ca) == 0) {
            this.f26356a = true;
        }
    }

    public int a(Location location) {
        if (location == null) {
            return -1;
        }
        this.c = System.currentTimeMillis() / 1000;
        if (!b()) {
            d();
        }
        int iA = b() ? a(b(location)) : -1;
        this.d = iA;
        return iA;
    }

    public void a(ArrayList<ArrayList<Float>> arrayList) {
        String string;
        StringBuilder sb = new StringBuilder();
        if (arrayList.size() == 0) {
            string = "NULL";
        } else {
            boolean z = true;
            for (ArrayList<Float> arrayList2 : arrayList) {
                if (arrayList2.size() == 6) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append(com.alipay.sdk.m.y.l.b);
                    }
                    sb.append(String.format("%.1f,", arrayList2.get(2)));
                    sb.append(String.format("%.0f", arrayList2.get(3)));
                }
            }
            string = sb.toString();
        }
        b = string;
    }

    public boolean b() {
        return this.f26356a;
    }

    public void c() {
        d.b();
        this.f26356a = false;
        b = "";
        this.c = -1L;
        this.d = -1;
    }
}

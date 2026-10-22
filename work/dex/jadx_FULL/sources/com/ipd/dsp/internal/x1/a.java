package com.ipd.dsp.internal.x1;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f38604a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public long k;

    public a() {
        this.f38604a = -1;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = 0L;
    }

    public void a(float f, float f2, float f3, float f4) {
        this.c = (int) f;
        this.d = (int) f2;
        this.e = (int) f3;
        this.f = (int) f4;
    }

    public void b(float f, float f2, float f3, float f4) {
        this.g = (int) f;
        this.h = (int) f2;
        this.i = (int) f3;
        this.j = (int) f4;
        this.k = System.currentTimeMillis();
    }

    public void a(int i, int i2) {
        this.f38604a = i;
        this.b = i2;
    }

    public Map<String, Object> a() {
        HashMap map = new HashMap();
        map.put("ad_click_point_down_x", Integer.valueOf(this.c));
        map.put("ad_click_point_down_y", Integer.valueOf(this.d));
        map.put("scr_click_point_down_x", Integer.valueOf(this.e));
        map.put("scr_click_point_down_y", Integer.valueOf(this.f));
        map.put("ad_click_point_up_x", Integer.valueOf(this.g));
        map.put("ad_click_point_up_y", Integer.valueOf(this.h));
        map.put("scr_click_point_up_x", Integer.valueOf(this.i));
        map.put("scr_click_point_up_y", Integer.valueOf(this.j));
        map.put("ad_width", Integer.valueOf(this.f38604a));
        map.put("ad_height", Integer.valueOf(this.b));
        map.put("click_ts", Long.valueOf(this.k));
        return map;
    }

    public a(int i, int i2) {
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = 0L;
        this.f38604a = i;
        this.b = i2;
    }
}

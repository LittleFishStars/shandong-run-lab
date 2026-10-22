package com.ipd.dsp.internal.j1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f38368a;
    public final Map<String, Object> b;
    public long c;
    public int d;
    public long e;
    public boolean f;
    public int g;
    public int h;

    public c() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
        this.f38368a = simpleDateFormat;
        HashMap map = new HashMap();
        this.b = map;
        this.g = 1;
        this.h = 2;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        map.put("play_begin_ts", 0);
        map.put("play_first_frame", 1);
        map.put("play_behavior", 1);
        map.put("play_scene", 1);
    }

    public void a(int i) {
        this.c = System.currentTimeMillis();
        this.d = i;
        this.h = 1;
    }

    public void b(int i) {
        if (i > 0) {
            this.e = i;
        }
    }

    public void c() {
        this.f = true;
    }

    public void d() {
        this.h = 4;
    }

    public void e() {
        this.g = 3;
    }

    public void f() {
        this.g = 2;
    }

    public Map<String, Object> g() {
        this.b.put("material_down_fin_ms", Long.valueOf(this.c));
        this.b.put("play_progress_ts", Long.valueOf(this.e / 1000));
        this.b.put("play_progress_ms", Long.valueOf(this.e));
        this.b.put("play_progress_part_time", a(this.e));
        this.b.put("play_end_ts", Long.valueOf(this.e / 1000));
        this.b.put("play_last_frame", Integer.valueOf(this.f ? 1 : 0));
        this.b.put("play_type", Integer.valueOf(this.g));
        this.b.put("play_status", Integer.valueOf(this.h));
        this.b.put("video_time", Integer.valueOf(this.d));
        return this.b;
    }

    public float b() {
        return (this.e / 1000.0f) / this.d;
    }

    public final String a(long j) {
        return this.f38368a.format(new Date(j));
    }

    public int a() {
        return (int) (this.e / 1000);
    }
}

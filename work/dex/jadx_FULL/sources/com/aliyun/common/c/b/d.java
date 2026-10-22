package com.aliyun.common.c.b;

import android.content.Context;
import com.aliyun.svideosdk.conan.event.AlivcEventReporter;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d extends f {
    public d(Context context, String str) {
        AlivcEventReporter alivcEventReporterA = g.a(context);
        this.f25568a = alivcEventReporterA;
        if (alivcEventReporterA != null) {
            alivcEventReporterA.c(str);
            this.f25568a.d("svplayer");
        }
        this.b = 3000;
    }

    public void a(int i, int i2) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setDisplaySize");
        map.put("width", String.valueOf(i));
        map.put("height", String.valueOf(i2));
        a(map);
    }

    public void a(String str) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setSource");
        map.put("path", str);
        a(map);
    }

    public void c() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "init");
        a(map);
    }

    public void d() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "pause");
        a(map);
    }

    public void e() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "play");
        a(map);
    }

    public void f() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "release");
        a(map);
    }

    public void g() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "resume");
        a(map);
    }

    public void h() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setDisplay");
        a(map);
    }

    public void i() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "stop");
        a(map);
    }
}

package com.getui.gtc.a.a;

import android.net.Network;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f30246a;
    public byte[] b;
    public Network c;
    public boolean d;
    public e e;
    public boolean f;
    public boolean g;
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public HashMap<String, String> n;

    public f() {
        this.c = null;
        this.h = 30000;
        this.i = 60000;
        this.j = true;
        this.k = true;
        this.l = false;
        this.m = true;
        this.n = new HashMap<>();
    }

    public f(String str) {
        this.c = null;
        this.h = 30000;
        this.i = 60000;
        this.j = true;
        this.k = true;
        this.l = false;
        this.m = true;
        HashMap<String, String> map = new HashMap<>();
        this.n = map;
        this.f30246a = str;
        map.put("Content-Type", "application/x-www-form-urlencoded");
    }

    public void a() {
    }

    public void a(int i) {
    }

    public void a(Map<String, List<String>> map, byte[] bArr) {
    }
}

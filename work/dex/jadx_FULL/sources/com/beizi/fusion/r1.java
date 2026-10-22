package com.beizi.fusion;

import android.content.Context;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class r1 {
    private String b;
    private WeakReference l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private th f27707a = th.PREFETCH;
    private int c = 3;
    private boolean d = false;
    private int e = -1;
    private int f = -1;
    private int g = -1;
    private int h = -1;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private String m = "";

    public r1(Context context) {
        this.l = new WeakReference(context);
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(String str) {
        this.m = str;
    }

    public void a(th thVar) {
        this.f27707a = thVar;
    }

    public th a() {
        return this.f27707a;
    }
}

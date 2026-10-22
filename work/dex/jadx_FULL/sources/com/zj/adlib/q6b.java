package com.zj.adlib;

import android.text.TextUtils;
import java.util.Vector;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class q6b {
    public static int c = 100;
    public static int d = 10000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f44139a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Vector<m6b> f19020a;
    public int b;

    public q6b() {
        this.b = 0;
        this.f44139a = 10;
        this.f19020a = new Vector<>();
    }

    public final Vector<m6b> a() {
        return this.f19020a;
    }

    public final synchronized void b(m6b m6bVar) {
        if (m6bVar != null) {
            if (!TextUtils.isEmpty(m6bVar.g())) {
                this.f19020a.add(m6bVar);
                this.b += m6bVar.g().getBytes().length;
            }
        }
    }

    public final synchronized boolean c(String str) {
        if (str == null) {
            return false;
        }
        if (this.f19020a.size() >= this.f44139a) {
            return true;
        }
        return this.b + str.getBytes().length > d;
    }

    public final synchronized void d() {
        this.f19020a.clear();
        this.b = 0;
    }

    public q6b(byte b) {
        this.f44139a = c;
        this.b = 0;
        this.f19020a = new Vector<>();
    }
}

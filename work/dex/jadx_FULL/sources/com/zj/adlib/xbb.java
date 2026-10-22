package com.zj.adlib;

import com.amap.api.col.p0003l.ip;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class xbb extends ip {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f45787a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f20629a;

    public xbb(String str, ip ipVar) {
        super(ipVar);
        this.f45787a = 30;
        this.f20629a = str;
    }

    public static int e(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.list().length;
            }
            return 0;
        } catch (Throwable th) {
            a7b.m(th, "fus", "gfn");
            return 0;
        }
    }

    @Override // com.amap.api.col.p0003l.ip
    public final boolean c() {
        return e(this.f20629a) >= this.f45787a;
    }
}

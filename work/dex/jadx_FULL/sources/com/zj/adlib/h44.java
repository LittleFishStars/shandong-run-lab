package com.zj.adlib;

import androidx.annotation.Nullable;
import com.huachenjie.base.module_bridge.interfaces.IMMethodLoader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class h44 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static h44 f42046a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f16926a = "IMBridge";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public IMMethodLoader f16927a;

    public static h44 a() {
        h44 h44Var;
        synchronized (h44.class) {
            if (f42046a == null) {
                f42046a = new h44();
            }
            h44Var = f42046a;
        }
        return h44Var;
    }

    @Nullable
    public IMMethodLoader b() {
        return this.f16927a;
    }

    public void c(IMMethodLoader loader) {
        this.f16927a = loader;
    }
}

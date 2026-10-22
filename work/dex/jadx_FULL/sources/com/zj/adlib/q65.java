package com.zj.adlib;

import androidx.annotation.Nullable;
import com.huachenjie.base.module_bridge.interfaces.MallMethodLoader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class q65 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static q65 f44137a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f19018a = "MallBridge";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MallMethodLoader f19019a;

    public static q65 a() {
        q65 q65Var;
        synchronized (q65.class) {
            if (f44137a == null) {
                f44137a = new q65();
            }
            q65Var = f44137a;
        }
        return q65Var;
    }

    @Nullable
    public MallMethodLoader b() {
        return this.f19019a;
    }

    public void c(MallMethodLoader loader) {
        this.f19019a = loader;
    }
}

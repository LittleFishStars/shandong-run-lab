package com.zj.adlib;

import androidx.annotation.Nullable;
import com.huachenjie.base.module_bridge.interfaces.CollegeMethodLoader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ln1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ln1 f43107a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f18001a = "CollegeBridge";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CollegeMethodLoader f18002a;

    public static ln1 a() {
        ln1 ln1Var;
        synchronized (ln1.class) {
            if (f43107a == null) {
                f43107a = new ln1();
            }
            ln1Var = f43107a;
        }
        return ln1Var;
    }

    @Nullable
    public CollegeMethodLoader b() {
        return this.f18002a;
    }

    public void c(CollegeMethodLoader loader) {
        this.f18002a = loader;
    }
}

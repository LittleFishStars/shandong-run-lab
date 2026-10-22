package com.zj.adlib;

import androidx.annotation.Nullable;
import com.huachenjie.base.module_bridge.interfaces.BaseMethodLoader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class qn0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static qn0 f44248a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f19149a = "BaseBridge";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BaseMethodLoader f19150a;

    public static qn0 a() {
        qn0 qn0Var;
        synchronized (qn0.class) {
            if (f44248a == null) {
                f44248a = new qn0();
            }
            qn0Var = f44248a;
        }
        return qn0Var;
    }

    @Nullable
    public BaseMethodLoader b() {
        return this.f19150a;
    }

    public void c(BaseMethodLoader loader) {
        this.f19150a = loader;
    }
}

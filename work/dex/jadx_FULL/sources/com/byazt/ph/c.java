package com.byazt.ph;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ExitInstallListener;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 763, 20})
public class c implements Function<SparseArray<Object>, Object> {
    public final ExitInstallListener c;

    public c(ExitInstallListener exitInstallListener) {
        this.c = exitInstallListener;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.c != null && com.byazt.rl.ve.c(sparseArray).tt().intValue(-99999987) == 223101) {
            this.c.onExitInstall();
        }
        return null;
    }
}

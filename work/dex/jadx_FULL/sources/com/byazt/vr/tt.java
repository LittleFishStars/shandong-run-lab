package com.byazt.vr;

import android.os.Handler;
import android.text.TextUtils;
import com.byazt.mg.da;
import com.byazt.uy.x;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1683, 13})
public class tt extends c {
    public tt(Handler handler, long j, long j2) {
        super(handler, j, j2);
    }

    @Override // java.lang.Runnable
    public void run() {
        String strN = x.c().n();
        if (TextUtils.isEmpty(strN) || "0".equals(strN)) {
            c(ve());
            da.c("[DeviceIdTask] did is null, continue check.");
        } else {
            x.ve().c(strN);
            da.c("[DeviceIdTask] did is ".concat(String.valueOf(strN)));
        }
    }
}

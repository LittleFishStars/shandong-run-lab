package com.kc.dw.core.loader.strategy;

import android.text.TextUtils;
import com.kc.dw.core.domain.SdkAdInfo;
import com.kc.dw.core.safe.j;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.z;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f39269a;

    public b(e eVar) {
        this.f39269a = eVar;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        SdkAdInfo sdkAdInfo;
        e eVar = this.f39269a;
        eVar.getClass();
        try {
            eVar.u = true;
            eVar.e();
            for (int i = 0; i < eVar.e.size(); i++) {
                com.kc.dw.core.loader.loadbean.a aVar = eVar.e.get(i);
                if (aVar.c != 1 && (sdkAdInfo = aVar.f39268a) != null) {
                    String err = sdkAdInfo.getErr();
                    if (err.contains("__MS_ERRNO__")) {
                        String strReplace = err.replace("__MS_ERRNO__", "1025").replace("__TIMEOUT__", String.valueOf(10));
                        aVar.f39268a.setErr(strReplace);
                        if (TextUtils.isEmpty(strReplace)) {
                            continue;
                        } else {
                            z.a(eVar.f39271a.getContext().getApplicationContext(), g0.a(strReplace), new com.kc.dw.core.utils.j());
                        }
                    } else {
                        continue;
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

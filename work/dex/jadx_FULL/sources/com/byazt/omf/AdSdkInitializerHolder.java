package com.byazt.omf;

import android.os.Bundle;
import android.util.SparseArray;
import androidx.annotation.Keep;
import com.byazt.ut.ATSKeep;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 31, 774})
public class AdSdkInitializerHolder implements com.byazt.dna.i, Function {
    public static volatile ve c;
    public static volatile Object tt;

    private static int c() {
        try {
            return TTAdSdk.class.getField("SDK_VERSION_CODE").getInt(null);
        } catch (Throwable th) {
            com.byazt.ukr.yp.c().c("init", th);
            com.byazt.nr.m.c(th);
            return 0;
        }
    }

    @Keep
    public static Object getNewInstance(Bundle bundle) {
        com.byazt.dna.my myVar;
        if (c == null) {
            synchronized (AdSdkInitializerHolder.class) {
                if (c == null) {
                    c = new ve(bundle);
                    if (p.c.booleanValue() && (myVar = (com.byazt.dna.my) com.byazt.ut.uj.getService("m")) != null) {
                        tt = myVar.getDispatchAdSdkInitializer(bundle, c);
                    }
                }
            }
        }
        int iC = bundle.getInt("api_sdk_version", 0);
        if (iC == 0) {
            iC = c();
            com.byazt.nr.m.c("wzj,通过反射取apiSdkVersion值=".concat(String.valueOf(iC)));
            if (iC == 0) {
                return null;
            }
        }
        com.byazt.mta.c.c().c(iC);
        if (iC < 6803) {
            return tt != null ? new com.byazt.ap.tt((Function) tt) : new com.byazt.ap.c(c);
        }
        return tt != null ? tt : c;
    }

    public static boolean hasDispatchAdSdkInitializer() {
        return tt != null;
    }

    public static boolean isSdkInitSuccess() {
        if (c != null) {
            return c.isInitSuccess();
        }
        return false;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        if (((Integer) sparseArray.get(0)).intValue() != 1) {
            return null;
        }
        return getInitialInstance((Bundle) sparseArray.get(1));
    }

    @Override // com.byazt.dna.i
    public Object getInitialInstance(Bundle bundle) {
        return getNewInstance(bundle);
    }
}

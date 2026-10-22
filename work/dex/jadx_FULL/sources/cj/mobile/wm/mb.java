package cj.mobile.wm;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class mb implements va {
    @Override // cj.mobile.wm.va
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean zDexb = cb.dexb(context);
        f1.dexa("getOAID", "isSupported " + zDexb);
        if (zDexb) {
            return cb.dexa(context);
        }
        return null;
    }
}

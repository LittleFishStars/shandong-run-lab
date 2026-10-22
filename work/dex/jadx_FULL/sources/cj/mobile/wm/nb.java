package cj.mobile.wm;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class nb implements va {
    @Override // cj.mobile.wm.va
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean zDexa = xa.dexa();
        f1.dexa("getOAID", "isSupported " + zDexa);
        if (zDexa) {
            return xa.dexa(context);
        }
        return null;
    }
}

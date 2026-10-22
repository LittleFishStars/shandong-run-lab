package cj.mobile.wm;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dexs implements dexr {
    @Override // cj.mobile.wm.dexr
    public boolean dexa(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 1) != null;
        } catch (Throwable unused) {
            return false;
        }
    }
}

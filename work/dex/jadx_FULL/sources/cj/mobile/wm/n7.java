package cj.mobile.wm;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class n7 {
    public m7 dexa(Context context, m7.dexa dexaVar) {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 ? new o7(context, dexaVar) : new s7();
    }
}

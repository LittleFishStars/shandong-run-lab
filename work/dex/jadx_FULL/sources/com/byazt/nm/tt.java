package com.byazt.nm;

import android.content.Context;
import com.byazt.omf.h;
import com.byazt.tjo.DispatchAdSdkInitializerHolder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 585, 13})
public abstract class tt extends com.byazt.sp.tt {
    public static final String VERSION_00 = "0.0";

    public tt(com.byazt.db.tt ttVar) {
        super(ttVar);
    }

    public h getPluginCSJLoader(Context context) {
        h csjLoader = DispatchAdSdkInitializerHolder.getCsjLoader(context);
        if (csjLoader == null) {
            notifyLoadFail(new com.byazt.pp.c("ClassCastException：load ad fail loader is null"));
        }
        return csjLoader;
    }

    @Override // com.byazt.db.c
    public String getSdkVersion(String str) {
        try {
            return com.byazt.tjo.tt.ve();
        } catch (Exception unused) {
            return "0.0";
        }
    }
}

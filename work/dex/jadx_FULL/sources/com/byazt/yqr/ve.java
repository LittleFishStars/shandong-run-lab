package com.byazt.yqr;

import android.content.Context;
import com.byazt.fk.da;
import com.byazt.fk.u;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 982, 54})
public class ve {
    public static final ConcurrentHashMap<String, tt> c = new ConcurrentHashMap<>();

    public static synchronized void c(Context context, u uVar, da.c cVar) {
        try {
            if (uVar == null) {
                com.byazt.lt.tt.c(" url、dir and hash is must property   in VideoInfoModel");
                return;
            }
            ConcurrentHashMap<String, tt> concurrentHashMap = c;
            tt ttVar = concurrentHashMap.get(uVar.getFileNameKey());
            if (ttVar == null) {
                ttVar = new tt(context, uVar);
                concurrentHashMap.put(uVar.getFileNameKey(), ttVar);
                uVar.getPreloadSize();
                uVar.getFileNameKey();
            }
            ttVar.c(cVar);
            uVar.getPreloadSize();
            uVar.getFileNameKey();
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized void c(u uVar) {
        tt ttVarRemove = c.remove(uVar.getFileNameKey());
        if (ttVarRemove != null) {
            ttVarRemove.c(true);
        }
        uVar.getPreloadSize();
        uVar.getFileNameKey();
    }
}

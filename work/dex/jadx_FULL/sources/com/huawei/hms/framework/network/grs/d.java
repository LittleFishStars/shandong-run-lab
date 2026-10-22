package com.huawei.hms.framework.network.grs;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, c> f37516a = new ConcurrentHashMap(16);
    private static final Object b = new Object();

    public static c a(GrsBaseInfo grsBaseInfo, Context context) {
        synchronized (b) {
            int iUniqueCode = grsBaseInfo.uniqueCode();
            Map<String, c> map = f37516a;
            c cVar = map.get(context.getPackageName() + iUniqueCode);
            if (cVar == null) {
                Logger.i("GrsClientManager", "grsClientImpl == null, and new GrsClientImpl");
                c cVar2 = new c(context, grsBaseInfo);
                map.put(context.getPackageName() + iUniqueCode, cVar2);
                return cVar2;
            }
            if (cVar.a((Object) new c(grsBaseInfo))) {
                return cVar;
            }
            Logger.i("GrsClientManager", "The app_name, ser_country, reg_country and issue_country is equal, but other not.");
            c cVar3 = new c(context, grsBaseInfo);
            map.put(context.getPackageName() + iUniqueCode, cVar3);
            return cVar3;
        }
    }
}

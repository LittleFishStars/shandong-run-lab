package cj.mobile.wm;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import cj.mobile.wm.common.utils.ConstantInfo;
import cj.mobile.wm.common.utils.DebugLog;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dexl {
    public static boolean dexa;

    public static void dexa(Context context) {
        dexg dexdVar;
        try {
            Map<Integer, String> map = ConstantInfo.Config.schemeMap;
            if (map == null || map.isEmpty() || ConstantInfo.Config.appWakeupCheckDuration <= 0) {
                return;
            }
            if (dexa) {
                DebugLog.common_weak(dexc.dexa("jtJoju!sfuvso"));
                return;
            }
            dexa = true;
            ArrayList arrayList = new ArrayList(ConstantInfo.Config.schemeMap.values());
            if (Build.VERSION.SDK_INT >= 29) {
                dexdVar = new dexe();
                DebugLog.common_weak(dexc.dexa("bt3:"));
            } else {
                dexdVar = new dexd();
                DebugLog.common_weak(dexc.dexa("bt37"));
            }
            dexdVar.dexa(context, arrayList);
        } catch (Throwable th) {
            DebugLog.common_weak(dexc.dexa("bt!gbjm!") + Log.getStackTraceString(th));
        }
    }
}

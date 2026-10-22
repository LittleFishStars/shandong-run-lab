package com.kc.bw;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.kc.bw.common.utils.ConstantInfo;
import com.kc.bw.common.utils.DebugLog;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class dexp {
    public static boolean dexa;

    public static void dexa(Context context) {
        dexk dexhVar;
        String strDexa;
        try {
            Map<Integer, String> map = ConstantInfo.Config.schemeMap;
            if (map == null || map.isEmpty() || ConstantInfo.Config.appWakeupCheckDuration <= 0) {
                DebugLog.common_weak(dexg.dexa("bt!gbjm-dgh!jt!jowbmje"));
                return;
            }
            if (dexa) {
                DebugLog.common_weak(dexg.dexa("jtJoju!sfuvso"));
                return;
            }
            dexa = true;
            ArrayList arrayList = new ArrayList(ConstantInfo.Config.schemeMap.values());
            if (Build.VERSION.SDK_INT >= 29) {
                dexhVar = new dexi();
                strDexa = dexg.dexa("bt3:");
            } else {
                dexhVar = new dexh();
                strDexa = dexg.dexa("bt37");
            }
            DebugLog.common_weak(strDexa);
            dexhVar.dexa(context, arrayList);
        } catch (Throwable th) {
            DebugLog.common_weak(dexg.dexa("bt!gbjm!") + Log.getStackTraceString(th));
        }
    }
}

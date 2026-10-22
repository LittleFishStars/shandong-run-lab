package cj.mobile.wm;

import android.text.TextUtils;
import com.wangmai.insightvision.openadsdk.entity.insight.AdConfigInfo;
import com.wangmai.insightvision.openadsdk.entity.insight.AdLayoutInfo;
import java.util.Calendar;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class o1 {
    public static long dexa() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static long dexa(long j, long j2) {
        return (j2 - j) / 86400000;
    }

    public static boolean dexa(com.wangmai.insightvision.openadsdk.common.f fVar, String str) {
        Map extraInfo;
        if (fVar == null) {
            return false;
        }
        if (TextUtils.isEmpty(str) && (extraInfo = fVar.getExtraInfo()) != null && extraInfo.containsKey("slot_id")) {
            Object obj = extraInfo.get("slot_id");
            if (obj instanceof String) {
                str = (String) obj;
            }
        }
        if (dex03.dexf(fVar) <= 0 || TextUtils.isEmpty(str)) {
            f1.dexa("TouchJumpHelper", "isTouchJumpEnable: false, slotId = " + str);
            return false;
        }
        int iDexf = dex03.dexf(fVar);
        long jDexa = dexa(com.wangmai.insightvision.openadsdk.h.e.b.d(fVar), dexa());
        StringBuilder sb = new StringBuilder();
        sb.append("isTouchJumpEnable = ");
        long j = iDexf;
        sb.append(jDexa >= j);
        sb.append(", jumpType = ");
        sb.append(iDexf);
        sb.append(", daysDiff = ");
        sb.append(jDexa);
        sb.append(", slotId = ");
        sb.append(str);
        f1.dexa("TouchJumpHelper", sb.toString());
        return jDexa >= j;
    }

    public static boolean dexa(com.wangmai.insightvision.openadsdk.common.f fVar, boolean z) {
        return (fVar == null || !z || dex03.dexh(fVar)) ? false : true;
    }

    public static boolean dexa(AdConfigInfo adConfigInfo) {
        return adConfigInfo != null && adConfigInfo.getTouchJumpCallbackType() >= 0;
    }

    public static boolean dexa(AdLayoutInfo adLayoutInfo) {
        return adLayoutInfo != null && adLayoutInfo.getTouchJumpCallbackType() >= 0;
    }
}

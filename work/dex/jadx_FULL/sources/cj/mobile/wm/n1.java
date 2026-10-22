package cj.mobile.wm;

import android.text.TextUtils;
import java.util.Calendar;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class n1 {

    public interface dexa {
        void a();
    }

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

    public static void dexa(com.wangmai.insightvision.openadsdk.common.f fVar) {
        Map extraInfo;
        if (fVar == null || (extraInfo = fVar.getExtraInfo()) == null) {
            return;
        }
        extraInfo.put("fanti_click_type", Integer.valueOf(com.wangmai.insightvision.openadsdk.h.e.b.a.c.a()));
    }

    public static void dexa(com.wangmai.insightvision.openadsdk.common.f fVar, String str, dexa dexaVar) {
        int iDexd;
        Map extraInfo;
        if (fVar == null) {
            return;
        }
        if (TextUtils.isEmpty(str) && (extraInfo = fVar.getExtraInfo()) != null && extraInfo.containsKey("slot_id")) {
            str = (String) extraInfo.get("slot_id");
        }
        String strP = fVar.p();
        if (fVar.C() || !be.dexa(strP) || TextUtils.isEmpty(str) || (iDexd = dex03.dexd(fVar)) <= 0) {
            return;
        }
        long jDexa = dexa(com.wangmai.insightvision.openadsdk.h.e.b.d(fVar), dexa());
        StringBuilder sb = new StringBuilder();
        sb.append("isJumpEnable = ");
        long j = iDexd;
        sb.append(jDexa >= j);
        sb.append(", checkAndJump: jumpType=");
        sb.append(iDexd);
        sb.append(", daysDiff=");
        sb.append(jDexa);
        sb.append(", slotId=");
        sb.append(str);
        f1.dexa("JumpHelper", sb.toString());
        if (jDexa < j || dexaVar == null) {
            return;
        }
        dexa(fVar);
        dexaVar.a();
        h1.dexa().dexa(fVar, "a_click");
    }
}

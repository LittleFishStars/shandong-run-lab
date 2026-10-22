package cj.mobile.wm;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.camera.video.AudioStats;
import com.wangmai.insightvision.openadsdk.api.FanTiAdSdk;
import com.wangmai.insightvision.openadsdk.api.FanTiAppConfig;
import com.wangmai.insightvision.openadsdk.api.INativeAd;
import com.wangmai.insightvision.openadsdk.entity.insight.AdInteractInfo;
import java.util.Calendar;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class be {
    public static String dexa() {
        return String.valueOf((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000);
    }

    public static String dexa(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod(com.acse.ottn.p3.f, String.class, String.class).invoke(null, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    public static boolean dexa(Context context, String str, boolean z) {
        try {
            return context.getSharedPreferences("fanti_demo_sp_file", 0).getBoolean(str, z);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean dexa(INativeAd iNativeAd) {
        FanTiAppConfig fanTiAppConfigDexb = g1.dexc().dexb();
        if (fanTiAppConfigDexb == null || fanTiAppConfigDexb.getCustomControl() == null || !fanTiAppConfigDexb.getCustomControl().isCanUseSensor() || iNativeAd == null) {
            return false;
        }
        com.wangmai.insightvision.openadsdk.common.f fVar = (com.wangmai.insightvision.openadsdk.common.f) iNativeAd;
        return fVar.h() != null && "1".equals(fVar.h().getShake()) && dexb(fVar);
    }

    public static boolean dexa(com.wangmai.insightvision.openadsdk.common.f fVar) {
        boolean zDexa = dexa(FanTiAdSdk.getContext(), "handleJumpApp", false);
        int iDexc = dex03.dexc(fVar);
        f1.dexa("AdUtils", "isSystemDpJump: handleJumpApp = " + zDexa + ", dpCfgType = " + iDexc);
        return zDexa || iDexc == 1;
    }

    public static boolean dexa(String str) {
        Intent uri;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            uri = Intent.parseUri(str, 1);
            try {
                uri.setFlags(268435456);
            } catch (Exception e) {
                e = e;
                Log.e("AdUtils", "URISyntaxException " + e.getMessage());
            }
        } catch (Exception e2) {
            e = e2;
            uri = null;
        }
        return (uri == null || FanTiAdSdk.getContext().getPackageManager().resolveActivity(uri, 0) == null) ? false : true;
    }

    public static double dexb(INativeAd iNativeAd) {
        Object obj;
        Map extraInfo = iNativeAd.getExtraInfo();
        return (extraInfo == null || !extraInfo.containsKey("price") || (obj = extraInfo.get("price")) == null) ? AudioStats.AUDIO_AMPLITUDE_NONE : ((Double) obj).doubleValue();
    }

    public static float dexb(String str) {
        try {
            return Float.parseFloat(str);
        } catch (Exception e) {
            Log.e("Utils", "toFloat: " + e.getMessage());
            return 0.0f;
        }
    }

    public static String dexb() {
        return String.valueOf(Build.TIME / 1000);
    }

    public static boolean dexb(com.wangmai.insightvision.openadsdk.common.f fVar) {
        String strP = fVar.p();
        if (TextUtils.isEmpty(strP)) {
            return true;
        }
        return dexa(strP);
    }

    public static int dexc(INativeAd iNativeAd) {
        if (iNativeAd == null) {
            return -1;
        }
        return ((com.wangmai.insightvision.openadsdk.common.f) iNativeAd).v();
    }

    public static int dexc(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            Log.e("Utils", "toInt: " + e.getMessage());
            return 0;
        }
    }

    public static boolean dexc(com.wangmai.insightvision.openadsdk.common.f fVar) {
        Intent uri;
        String strP = fVar.p();
        if (TextUtils.isEmpty(strP)) {
            return false;
        }
        try {
            uri = Intent.parseUri(strP, 1);
            try {
                uri.setFlags(268435456);
            } catch (Exception e) {
                e = e;
                Log.e("AdUtils", "URISyntaxException " + e.getMessage());
            }
        } catch (Exception e2) {
            e = e2;
            uri = null;
        }
        if (uri != null && FanTiAdSdk.getContext().getPackageManager().resolveActivity(uri, 0) != null) {
            return true;
        }
        Log.e("AdUtils", "forwardToActivity intent is null or not resolveActivity.");
        return false;
    }

    public static ec dexd(INativeAd iNativeAd) {
        String string;
        com.wangmai.insightvision.openadsdk.common.f fVar = (com.wangmai.insightvision.openadsdk.common.f) iNativeAd;
        if (fVar == null || fVar.h() == null) {
            return null;
        }
        ec ecVar = new ec();
        AdInteractInfo adInteractInfoH = fVar.h();
        int i = Calendar.getInstance().get(6);
        if (iNativeAd.getExtraInfo() == null || !iNativeAd.getExtraInfo().containsKey("slot_id")) {
            string = "";
        } else {
            Object obj = iNativeAd.getExtraInfo().get("slot_id");
            Objects.requireNonNull(obj);
            string = obj.toString();
        }
        float fDexb = dexb(adInteractInfoH.getSensitivity());
        String str = string + "_sensitivity_time";
        long j = i;
        if (je.dexa(str) != j && dexc(adInteractInfoH.getFirstSensitivity()) > 0) {
            je.dexa(str, j);
            fDexb = dexb(adInteractInfoH.getFirstSensitivity());
        }
        ecVar.dexa(fDexb);
        ecVar.dexa("1".equals(adInteractInfoH.getTwoWayShake()));
        return ecVar;
    }

    public static int dexe(INativeAd iNativeAd) {
        if (iNativeAd == null) {
            return -1;
        }
        try {
            return Integer.parseInt(((com.wangmai.insightvision.openadsdk.common.f) iNativeAd).y());
        } catch (Exception unused) {
            return -1;
        }
    }

    public static boolean dexf(INativeAd iNativeAd) {
        if (iNativeAd == null) {
            return false;
        }
        return ((com.wangmai.insightvision.openadsdk.common.f) iNativeAd).F();
    }
}

package cj.mobile.wm;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import cj.mobile.wm.appsdkdex.R;
import com.wangmai.insightvision.openadsdk.api.INativeAd;
import com.wangmai.insightvision.openadsdk.entity.insight.AdApkInfo;
import com.wangmai.insightvision.openadsdk.proxy.InsightProxy;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class w1 {
    public static com.wangmai.insightvision.openadsdk.download.n.a dexa(com.wangmai.insightvision.openadsdk.common.f fVar, AdApkInfo adApkInfo) {
        List listM;
        List listL;
        if (fVar != null) {
            listM = fVar.m();
            listL = fVar.l();
        } else {
            listM = null;
            listL = null;
        }
        return new com.wangmai.insightvision.openadsdk.download.n.a(adApkInfo, listM, listL);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002f  */
    public static String dexa(com.wangmai.insightvision.openadsdk.common.f fVar, Context context) {
        Resources resources;
        int i;
        Map extraInfo = fVar.getExtraInfo();
        if (extraInfo == null || extraInfo.isEmpty()) {
            resources = context.getResources();
            i = R.string.fanti_ad_splash_click_detail;
        } else if (fVar.f() != null) {
            resources = context.getResources();
            i = R.string.fanti_ad_splash_click_download;
        } else if (TextUtils.isEmpty(fVar.p())) {
            resources = context.getResources();
            i = R.string.fanti_ad_splash_click_detail;
        } else {
            resources = context.getResources();
            i = R.string.fanti_ad_splash_click_dp;
        }
        return resources.getString(i);
    }

    public static boolean dexa(Context context, Intent intent) {
        return (intent == null || context.getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    public static boolean dexa(Context context, String str, com.wangmai.insightvision.openadsdk.common.f fVar) {
        if (!be.dexc(fVar)) {
            h1.dexa().dexa(fVar, false);
            return false;
        }
        try {
            Intent uri = Intent.parseUri(str, 1);
            uri.setFlags(268435456);
            boolean zDexa = be.dexa(fVar);
            boolean zDexa2 = dexa(context, uri);
            h1.dexa().dexa(fVar, zDexa2);
            if (!zDexa2) {
                return false;
            }
            f1.dexa("ClickProcessor", "forwardToActivity: canDirectJump = " + zDexa);
            if (!zDexa) {
                return dexb(context, uri);
            }
            boolean zDexa3 = v1.dexa(context, uri);
            f1.dexa("ClickProcessor", "forwardToActivity: ClickHelper handleClick = " + zDexa3);
            if (!zDexa3) {
                return dexb(context, uri);
            }
            m1.dexb().dexa();
            return true;
        } catch (URISyntaxException e) {
            Log.e("ClickProcessor", "URISyntaxException " + e.getMessage());
            return false;
        }
    }

    public static boolean dexa(com.wangmai.insightvision.openadsdk.common.f fVar) {
        Map extraInfo;
        if (fVar == null || (extraInfo = fVar.getExtraInfo()) == null) {
            return false;
        }
        Object obj = extraInfo.get("fanti_click_type");
        if (!(obj instanceof Integer)) {
            return false;
        }
        int iIntValue = ((Integer) obj).intValue();
        if (iIntValue == com.wangmai.insightvision.openadsdk.h.e.b.a.b.a()) {
            return !dex03.dexg(fVar);
        }
        return iIntValue == com.wangmai.insightvision.openadsdk.h.e.b.a.d.a() || iIntValue == com.wangmai.insightvision.openadsdk.h.e.b.a.c.a();
    }

    public static boolean dexa(String str) {
        return he.dexd(InsightProxy.getApplication(), str) != null;
    }

    public static boolean dexa(String str, com.wangmai.insightvision.openadsdk.common.f fVar) {
        boolean zDexa = dexa(g1.dexc().dexa(), str, fVar);
        f1.dexa("ClickProcessor", "forwardToDeepLink: forwardSucceed = " + zDexa);
        return zDexa;
    }

    public static void dexb(com.wangmai.insightvision.openadsdk.common.f fVar) {
        if (fVar == null) {
            return;
        }
        Map extraInfo = fVar.getExtraInfo();
        if (extraInfo != null) {
            f1.dexa("ClickProcessor", "processAdvClick: clickType = " + extraInfo.get("fanti_click_type"));
        }
        if (dexc(fVar)) {
            com.wangmai.insightvision.openadsdk.h.e.b.e(fVar);
            return;
        }
        if (dexd(fVar)) {
            com.wangmai.insightvision.openadsdk.h.e.b.e(fVar);
        } else if (dexa(fVar)) {
            f1.dexa("ClickProcessor", "processAdvClick: disableDowngradeH5 = true");
        } else if (dexe(fVar)) {
            com.wangmai.insightvision.openadsdk.h.e.b.e(fVar);
        }
    }

    public static void dexb(com.wangmai.insightvision.openadsdk.common.f fVar, AdApkInfo adApkInfo) {
        try {
            Serializable serializableDexa = dexa(fVar, adApkInfo);
            Bundle bundle = new Bundle();
            bundle.putSerializable("data", serializableDexa);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            intent.setFlags(268435456);
            Application applicationDexa = g1.dexc().dexa();
            intent.setComponent(new ComponentName(applicationDexa, "com.wangmai.insightvision.openadsdk.download.DownloadAppActivity"));
            applicationDexa.startActivity(intent);
        } catch (Exception e) {
            f1.dexb("ClickProcessor", "handleDownloadApk exception: " + e.getMessage());
        }
    }

    public static void dexb(String str) {
        he.dexg(InsightProxy.getApplication(), str);
    }

    public static boolean dexb(Context context, Intent intent) {
        try {
            m1.dexb().dexa();
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void dexc(String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putLong("launchTime", System.currentTimeMillis());
            Intent intent = new Intent();
            intent.putExtras(bundle);
            intent.setFlags(268435456);
            Application applicationDexa = g1.dexc().dexa();
            intent.setComponent(new ComponentName(applicationDexa, "com.wangmai.insightvision.openadsdk.view.web.WebViewActivity"));
            applicationDexa.startActivity(intent);
        } catch (Exception e) {
            f1.dexb("ClickProcessor", "showWebViewActivity exception: " + e.getMessage());
        }
    }

    public static boolean dexc(com.wangmai.insightvision.openadsdk.common.f fVar) {
        String strP = fVar.p();
        if (TextUtils.isEmpty(strP) || !dexa(strP, fVar)) {
            return false;
        }
        h1.dexa().dexc((INativeAd) fVar);
        return true;
    }

    public static boolean dexd(com.wangmai.insightvision.openadsdk.common.f fVar) {
        AdApkInfo adApkInfoF = fVar.f();
        if (adApkInfoF == null) {
            return false;
        }
        String packageName = adApkInfoF.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            return false;
        }
        if (dexa(packageName)) {
            dexb(packageName);
            return true;
        }
        dexb(fVar, adApkInfoF);
        return true;
    }

    public static boolean dexe(com.wangmai.insightvision.openadsdk.common.f fVar) {
        String strS = fVar.s();
        if (TextUtils.isEmpty(strS)) {
            return false;
        }
        dexc(strS);
        h1.dexa().dexb(fVar);
        return true;
    }
}

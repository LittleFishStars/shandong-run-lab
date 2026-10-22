package com.bwt.top.h5;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.bwt.top.AdSdk;
import com.bwt.top.custom_ad.AdapterCustomSplashAdLoader;
import com.bwt.top.util.ALog;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AdSdkH5Helper {
    private static AdapterCustomSplashAdLoader.AdCloseListener sSplashAdListener;

    public static AdapterCustomSplashAdLoader.AdCloseListener getSplashAdListener() {
        return sSplashAdListener;
    }

    public static void releaseSplashAdListener() {
        sSplashAdListener = null;
    }

    public static boolean skipDeeplink(String str, String str2) {
        try {
            Context context = AdSdk.getInstance().getContext();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            if (!TextUtils.isEmpty(str2)) {
                intent.setPackage(str2);
            }
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (listQueryIntentActivities == null || listQueryIntentActivities.size() <= 0) {
                return false;
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            ALog.i("", e.getMessage());
            return false;
        }
    }

    public static boolean skipH5(Context context, String str, boolean z) {
        releaseSplashAdListener();
        return skipH5Activity(context, str, z);
    }

    private static boolean skipH5Activity(Context context, String str, boolean z) {
        Intent intent;
        ALog.i("", "skipH5:" + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (context == null) {
            context = AdSdk.getInstance().getContext();
        }
        if (context != null) {
            try {
                if (str.startsWith("msx://")) {
                    return false;
                }
                if (str.startsWith("http")) {
                    intent = new Intent(context, (Class<?>) AdSdkH5Activity.class);
                    intent.putExtra("url_str", str);
                    intent.putExtra("isDownload", z);
                    intent.addFlags(TTAdConstant.KEY_CLICK_AREA);
                } else {
                    intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                }
                intent.addFlags(268435456);
                context.startActivity(intent);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void skipSplashH5Callback(Context context, String str, boolean z, AdapterCustomSplashAdLoader.AdCloseListener adCloseListener) {
        sSplashAdListener = adCloseListener;
        if (skipH5Activity(context, str, z) || adCloseListener == null) {
            return;
        }
        adCloseListener.onAdClose();
    }
}

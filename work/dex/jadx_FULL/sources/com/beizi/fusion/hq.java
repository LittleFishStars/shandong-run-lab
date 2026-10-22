package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.model.ResponseInfo;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class hq {
    public static String a() {
        try {
            Context contextM = q1.h().m();
            if (contextM == null) {
                return null;
            }
            String openSDKAppId = ResponseInfo.getInstance(contextM).getOpenSDKAppId();
            if (TextUtils.isEmpty(openSDKAppId)) {
                return null;
            }
            return openSDKAppId;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String b() {
        try {
            return a4.j().q() ? String.valueOf(638067200) : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String c() {
        Context contextM;
        IWXAPI iwxapiCreateWXAPI;
        try {
            if (!a4.j().q() || (contextM = q1.h().m()) == null) {
                return null;
            }
            String strA = a();
            if (TextUtils.isEmpty(strA) || (iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(contextM, strA)) == null) {
                return null;
            }
            return String.valueOf(iwxapiCreateWXAPI.getWXAppSupportAPI());
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static boolean d() {
        try {
            return so.a("com.tencent.mm.opensdk.openapi.IWXAPI");
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                if (!a4.j().q()) {
                    return false;
                }
                String strA = a();
                if (TextUtils.isEmpty(strA)) {
                    return false;
                }
                IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(context, strA);
                WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                req.userName = str;
                req.path = str2;
                if (!TextUtils.isEmpty(str3)) {
                    req.extData = str3;
                }
                return iwxapiCreateWXAPI.sendReq(req);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (!a4.j().q()) {
                return false;
            }
            String strA = a();
            if (TextUtils.isEmpty(strA)) {
                return false;
            }
            IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(context, strA);
            WXOpenBusinessView.Req req = new WXOpenBusinessView.Req();
            req.businessType = "nativeOpenAdCanvas";
            req.extInfo = str;
            if (iwxapiCreateWXAPI == null) {
                return false;
            }
            return iwxapiCreateWXAPI.sendReq(req);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}

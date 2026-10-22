package com.alibaba.triver.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.Triver;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.aliyun.tea.logging.DefaultLogger;
import com.aliyun.vod.log.core.AliyunLogCommon;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {
    public static Uri a(Context context, String str, Bundle bundle, Bundle bundle2, JSONObject jSONObject, String str2, String str3) {
        String str4;
        if (TextUtils.isEmpty(str2) || bundle2 == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Uri.Builder builderAppendQueryParameter = Uri.parse("https://m.duanqu.com").buildUpon().appendQueryParameter(TRiverConstants.KEY_APP_ID, str2);
        if (bundle != null && bundle.containsKey(TRiverConstants.KEY_SPM_ORIGIN_URL)) {
            builderAppendQueryParameter.appendQueryParameter(TRiverConstants.KEY_SPM_ORIGIN_URL, bundle.getString(TRiverConstants.KEY_SPM_ORIGIN_URL, ""));
        }
        if (jSONObject != null && !jSONObject.isEmpty()) {
            String string = jSONObject.getString("envVersion");
            if (!TextUtils.isEmpty(string) && !(!bundle2.getBoolean(TRiverConstants.KEY_DELETE_FILE_WHEN_EXIT, false))) {
                if ("develop".equals(string)) {
                    str4 = DefaultLogger.DEBUG;
                } else if ("trial".equals(string)) {
                    str4 = "TRIAL";
                } else {
                    str4 = "examine".equals(string) ? "REVIEW" : "ONLINE";
                }
                String str5 = "ONLINE".equals(str4) ? "online" : AliyunLogCommon.LogLevel.DEBUG;
                String string2 = jSONObject.getString("version");
                builderAppendQueryParameter.appendQueryParameter(AppInfoScene.PARAM_SCENE, str4);
                builderAppendQueryParameter.appendQueryParameter(AppInfoScene.PARAM_SOURCE, str5);
                builderAppendQueryParameter.appendQueryParameter(AppInfoScene.PARAM_SCENE_VERSION, string2);
            }
        }
        Uri uriBuild = builderAppendQueryParameter.build();
        if (TextUtils.isEmpty(str3)) {
            return uriBuild;
        }
        return Uri.parse(uriBuild.toString() + "&query=" + str3);
    }

    public static Bundle a(JSONObject jSONObject, String str, long j, String str2, String str3, String str4, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (jSONObject != null && !jSONObject.isEmpty() && jSONObject.containsKey("param")) {
            bundle2.putAll(JSONUtils.toBundle(jSONObject.getJSONObject("param")));
        }
        bundle2.putString("page", str2);
        bundle2.putString("referAppId", str);
        bundle2.putLong("referToken", j);
        bundle2.putString("transition", str3);
        bundle2.putString(RVStartParams.KEY_SUPER_SPLASH, str4);
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        return bundle2;
    }

    private static boolean a(Context context, String str, long j, Bundle bundle, Bundle bundle2, JSONObject jSONObject, String str2, String str3, String str4, String str5, String str6, String str7, Bundle bundle3) {
        Uri uriA = a(context, str, bundle, bundle2, jSONObject, str2, str4);
        Bundle bundleA = a(jSONObject, str, j, str3, str5, str6, bundle3);
        bundleA.putBundle(TRiverConstants.KEY_OVER_PARAMS, bundle.getBundle(TRiverConstants.KEY_OVER_PARAMS));
        if (!TextUtils.isEmpty(str7)) {
            uriA = Uri.parse(uriA.toString() + "&" + str7);
        }
        Triver.openApp(context, uriA, bundleA);
        return true;
    }

    public static boolean a(Context context, String str, long j, Bundle bundle, Bundle bundle2, JSONObject jSONObject, String str2, String str3, String str4, String str5, JSONObject jSONObject2, String str6, String str7, Bundle bundle3) {
        Bundle bundle4 = bundle3 == null ? new Bundle() : bundle3;
        String str8 = TextUtils.isEmpty(str6) ? "YES" : str6;
        if (!TROrangeController.brandZoneInMainProcess()) {
            bundle4.putString(TRiverConstants.KEY_SUB_PROCESS, "true");
        }
        bundle4.putString(RVStartParams.KEY_CHINFO, TRiverConstants.CHINFO_BRAND_ZONE_PRIVATE);
        if (jSONObject2 != null && !jSONObject2.isEmpty()) {
            String string = jSONObject2.getString("loadingImage");
            String string2 = jSONObject2.getString("loadingLogo");
            Bundle bundle5 = new Bundle();
            bundle5.putString("loadingImage", string);
            bundle5.putString("loadingLogo", string2);
            com.alibaba.triver.container.a.a().a(context, bundle5);
            bundle4.putString("loadingParams", jSONObject2.toJSONString());
        }
        JSONObject jSONObject3 = jSONObject.getJSONObject("extraData");
        if (jSONObject3 != null) {
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("extraData", (Object) jSONObject3);
            jSONObject5.put("appId", (Object) str);
            jSONObject4.put("referrerInfo", (Object) jSONObject5);
            jSONObject.put("param", (Object) jSONObject4);
        }
        return a(context, str, j, bundle, bundle2, jSONObject, str2, str3, str4, str5, str8, str7, bundle4);
    }

    public static boolean a(Context context, String str, String str2, String str3, String str4, JSONObject jSONObject, String str5, String str6, Bundle bundle) {
        if (TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        Uri.Builder builderAppendQueryParameter = Uri.parse("https://m.duanqu.com").buildUpon().appendQueryParameter(TRiverConstants.KEY_APP_ID, str);
        if (!TextUtils.isEmpty(str3)) {
            builderAppendQueryParameter.appendQueryParameter("query", str3);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("page", str2);
        if (TextUtils.isEmpty(str4)) {
            str4 = "drop";
        }
        bundle2.putString("transition", str4);
        if (TextUtils.isEmpty(str5)) {
            str5 = "YES";
        }
        bundle2.putString(RVStartParams.KEY_SUPER_SPLASH, str5);
        bundle2.putString(RVStartParams.KEY_CHINFO, TRiverConstants.CHINFO_BRAND_ZONE_PRIVATE);
        if (!TROrangeController.brandZoneInMainProcess()) {
            bundle2.putString(TRiverConstants.KEY_SUB_PROCESS, "true");
        }
        if (jSONObject != null && !jSONObject.isEmpty()) {
            String string = jSONObject.getString("loadingImage");
            String string2 = jSONObject.getString("loadingLogo");
            Bundle bundle3 = new Bundle();
            bundle3.putString("loadingImage", string);
            bundle3.putString("loadingLogo", string2);
            com.alibaba.triver.container.a.a().a(context, bundle3);
            bundle.putString("loadingParams", jSONObject.toJSONString());
        }
        bundle2.putAll(bundle);
        Uri uriBuild = builderAppendQueryParameter.build();
        if (!TextUtils.isEmpty(str6)) {
            uriBuild = Uri.parse(uriBuild.toString() + "&" + str6);
        }
        Triver.openApp(context, uriBuild, bundle2);
        return true;
    }
}

package com.kwad.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.igexin.assist.util.AssistUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class f {
    private static final Map<String, List<String>> bod;

    static {
        HashMap map = new HashMap();
        bod = map;
        map.put(AssistUtils.BRAND_HW, Arrays.asList("com.huawei.appmarket"));
        map.put("oppo", Arrays.asList("com.oppo.market", "com.heytap.market"));
        map.put("vivo", Arrays.asList("com.bbk.appstore"));
        map.put("xiaomi", Arrays.asList("com.xiaomi.market"));
        map.put("oneplus", Arrays.asList("com.oppo.market"));
        map.put(AssistUtils.BRAND_MZ, Arrays.asList("com.meizu.mstore"));
        map.put("samsung", Arrays.asList("com.sec.android.app.samsungapps"));
        map.put("smartisan", Arrays.asList("com.smartisanos.appstore"));
        map.put("realme", Arrays.asList("com.oppo.market"));
        map.put(AssistUtils.BRAND_HON, Arrays.asList("com.hihonor.appmarket", "com.huawei.appmarket"));
    }

    public static boolean a(Context context, final String str, final AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (bd.Wb() && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.adStyle != 4) {
            if (TextUtils.isEmpty(str)) {
                com.kwad.sdk.commercial.b.a.c(adTemplate, "com.xiaomi.market", 0, 1);
                return false;
            }
            if (com.kwad.sdk.core.download.a.b.a(context, str, new com.kwad.sdk.core.download.a.b.C1280b() { // from class: com.kwad.sdk.utils.f.1
                @Override // com.kwad.sdk.core.download.a.b.C1280b, com.kwad.sdk.core.download.a.b.a
                public final void onError(Throwable th) {
                    super.onError(th);
                    com.kwad.sdk.commercial.b.a.a(adTemplate, str, "com.xiaomi.market", 0, 1, by.y(th));
                }

                @Override // com.kwad.sdk.core.download.a.b.C1280b, com.kwad.sdk.core.download.a.b.a
                public final void onStart() {
                    super.onStart();
                    com.kwad.sdk.commercial.b.a.a(adTemplate, str, "com.xiaomi.market", 0, 1);
                }

                @Override // com.kwad.sdk.core.download.a.b.C1280b, com.kwad.sdk.core.download.a.b.a
                public final void onSuccess() {
                    super.onSuccess();
                    AdTemplate adTemplate2 = adTemplate;
                    adTemplate2.mXiaomiAppStoreDetailViewOpen = true;
                    adTemplate2.mClickOpenAppStore = true;
                    com.kwad.sdk.commercial.b.a.b(adTemplate2, str, "com.xiaomi.market", 0, 1);
                }
            }) == 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(AdTemplate adTemplate, Context context, String str, String str2) {
        String str3;
        int i;
        String str4;
        String str5;
        Map<String, List<String>> map = bod;
        String str6 = Build.BRAND;
        List<String> arrayList = map.get(str6.toLowerCase());
        if (arrayList == null || arrayList.isEmpty()) {
            arrayList = new ArrayList<>();
            str3 = "";
        } else {
            str3 = arrayList.get(0);
        }
        String str7 = str3;
        if (context == null) {
            return false;
        }
        if (TextUtils.isEmpty(str) && adTemplate != null) {
            com.kwad.sdk.commercial.b.a.c(adTemplate, str7, 1, 0);
            return false;
        }
        try {
            if ("samsung".equals(str6)) {
                str = "http://apps.samsung.com/appquery/appDetail.as?appId=" + str2;
            }
            if (adTemplate != null) {
                com.kwad.sdk.commercial.b.a.a(adTemplate, str, str7, 1, 0);
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            for (String str8 : arrayList) {
                PackageInfo packageInfo = aa.getPackageInfo(context, str8, 1);
                if (packageInfo != null && (str5 = packageInfo.packageName) != null && str5.equals(str8)) {
                    intent.setPackage(str5);
                    intent.setFlags(268435456);
                    context.startActivity(intent);
                    if (adTemplate != null) {
                        adTemplate.mClickOpenAppStore = true;
                        com.kwad.sdk.commercial.b.a.b(adTemplate, str, str8, 1, 0);
                    }
                    return true;
                }
                if (adTemplate != null) {
                    com.kwad.sdk.commercial.b.a.a(adTemplate, str4, str7, i, 0, by.y(th));
                }
                return false;
            }
            try {
                context.startActivity(intent);
                if (adTemplate != null) {
                    adTemplate.mClickOpenAppStore = true;
                    com.kwad.sdk.commercial.b.a.b(adTemplate, str, str7, 0, 0);
                }
                return true;
            } catch (Throwable th) {
                th = th;
                str4 = str;
                i = 0;
            }
        } catch (Throwable th2) {
            th = th2;
            i = 1;
            str4 = str;
        }
    }

    public static boolean l(Context context, AdTemplate adTemplate) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        return c(adTemplate, context, com.kwad.sdk.core.response.helper.a.dd(adInfoEO), com.kwad.sdk.core.response.helper.a.aE(adInfoEO));
    }
}

package com.kwad.sdk.a.a;

import android.text.TextUtils;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class d {
    public static String H(AdInfo adInfo) {
        return com.kwad.sdk.core.config.e.Kt().replace("[appname]", adInfo.adBaseInfo.appName).replace("[appsize]", com.kwad.components.core.t.e.a(adInfo.adBaseInfo.packageSize, true)).replace("[appver]", adInfo.adBaseInfo.appVersion);
    }

    public static String Hr() {
        String strKu = com.kwad.sdk.core.config.e.Ku();
        return TextUtils.isEmpty(strKu) ? "安装" : strKu;
    }

    public static String Hs() {
        String strKv = com.kwad.sdk.core.config.e.Kv();
        return TextUtils.isEmpty(strKv) ? OptionsPickerHelper.e : strKv;
    }
}

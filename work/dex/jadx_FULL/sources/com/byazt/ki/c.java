package com.byazt.ki;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.byazt.bv.BaseConstants;
import com.byazt.gq.t;
import com.byazt.i.n;
import com.igexin.push.core.b;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1263, 20})
public class c {
    public static boolean c(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            return false;
        }
        if (t.i().optInt("market_url_opt", 1) == 0) {
            return BaseConstants.SCHEME_MARKET.equals(scheme);
        }
        return BaseConstants.SCHEME_MARKET.equals(scheme) || "appmarket".equals(scheme) || "oaps".equals(scheme) || "oppomarket".equals(scheme) || "mimarket".equals(scheme) || "vivomarket".equals(scheme) || "vivoMarket".equals(scheme) || "gomarket".equals(scheme) || "goMarket".equals(scheme) || "mstore".equals(scheme) || BaseConstants.MARKET_SCHEME_SAMSUNG.equals(scheme) || "honormarket".equals(scheme) || "prizeappcenter".equals(scheme);
    }

    public static String tt(@NonNull Uri uri) {
        String scheme = uri.getScheme();
        List<String> pathSegments = uri.getPathSegments();
        return (t.i().optInt("market_scheme_opt") == 1 && n.sp() && BaseConstants.MARKET_SCHEME_SAMSUNG.equals(scheme) && pathSegments != null && pathSegments.size() == 1) ? pathSegments.get(0) : tt.c(uri.getQueryParameter("id"), uri.getQueryParameter("packagename"), uri.getQueryParameter(b.aC), uri.getQueryParameter("package_name"), uri.getQueryParameter("appId"));
    }

    public static Uri c(Context context, String str) {
        String string = Settings.System.getString(context.getContentResolver(), "persit.sys.tid");
        Uri.Builder builder = new Uri.Builder();
        if (n.nu() && t.i().optInt("enable_honor_market_scheme_opt", 1) == 1) {
            return builder.scheme("honormarket").authority(BaseConstants.MARKET_URI_AUTHORITY_DETAIL).appendQueryParameter("id", str).build();
        }
        if (!TextUtils.isEmpty(string) && t.i().optInt("enable_persit_market_scheme_opt", 1) == 1) {
            return builder.scheme("prizeappcenter").authority(BaseConstants.MARKET_URI_AUTHORITY_DETAIL).appendQueryParameter(b.aC, str).build();
        }
        return Uri.parse(BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)));
    }
}

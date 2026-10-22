package com.zj.adlib;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public class mq1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final su3 f43363a = new su3("CommonUtils", "");

    @NonNull
    @KeepForSdk
    public static String a(@NonNull Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            f43363a.e("CommonUtils", "Exception thrown when trying to get app version ".concat(e.toString()));
            return "";
        }
    }

    @NonNull
    @KeepForSdk
    public static String b(@NonNull Locale locale) {
        if (is6.j()) {
            return locale.toLanguageTag();
        }
        StringBuilder sb = new StringBuilder(locale.getLanguage());
        if (!TextUtils.isEmpty(locale.getCountry())) {
            sb.append(c49.f40900a);
            sb.append(locale.getCountry());
        }
        if (!TextUtils.isEmpty(locale.getVariant())) {
            sb.append(c49.f40900a);
            sb.append(locale.getVariant());
        }
        return sb.toString();
    }
}

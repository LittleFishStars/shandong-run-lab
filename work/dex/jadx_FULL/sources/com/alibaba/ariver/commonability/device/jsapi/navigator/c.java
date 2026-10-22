package com.alibaba.ariver.commonability.device.jsapi.navigator;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23960a = "CommonAbility#SystemNavigatorManager";
    private static Map<String, Class<? extends b>> b = new ArrayMap();
    private Activity c;
    private b d = c();

    public c(Activity activity) {
        this.c = activity;
    }

    private static b c() {
        String str = Build.BRAND;
        String str2 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return new a();
        }
        try {
            if (!TextUtils.isEmpty(str) && b.containsKey(str.toLowerCase())) {
                return b.get(str.toLowerCase()).newInstance();
            }
            if (!TextUtils.isEmpty(str2) && b.containsKey(str2.toLowerCase())) {
                return b.get(str2.toLowerCase()).newInstance();
            }
            return new a();
        } catch (Exception e) {
            RVLogger.e(f23960a, e);
        }
    }

    public boolean a() {
        try {
            this.d.b(this.c);
            return true;
        } catch (Exception e) {
            RVLogger.e("applyCommonPermission", e);
            return false;
        }
    }

    public boolean b() {
        try {
            this.d.a(this.c);
            return true;
        } catch (Exception e) {
            RVLogger.e("openPermissionSetting", e);
            return a();
        }
    }
}

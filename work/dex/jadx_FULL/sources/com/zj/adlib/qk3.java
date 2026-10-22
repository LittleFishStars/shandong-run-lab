package com.zj.adlib;

import android.graphics.Typeface;
import com.huachenjie.common.util.ActivityLifecycleManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class qk3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Typeface> f44229a = new HashMap();

    public static Typeface a(String fontName) {
        return b(fontName);
    }

    public static Typeface b(String fontName) {
        Typeface typeface;
        try {
            Map<String, Typeface> map = f44229a;
            synchronized (map) {
                if (!map.containsKey(fontName)) {
                    map.put(fontName, Typeface.createFromAsset(ActivityLifecycleManager.l().m().getAssets(), fontName));
                }
                typeface = map.get(fontName);
            }
            return typeface;
        } catch (Exception unused) {
            return null;
        }
    }
}

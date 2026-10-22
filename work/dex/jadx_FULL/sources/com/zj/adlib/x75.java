package com.zj.adlib;

import android.content.Context;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.maps.MapsInitializer;
import huachenjie.sdk.map.lib_base.WholeConfig;
import huachenjie.sdk.map.lib_main.HCJMapManager;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class x75 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f45758a = "style2.data";
    public static final String b = "style_extra2.data";

    public static void a(Context context) {
        AMapLocationClient.updatePrivacyAgree(context, true);
        MapsInitializer.updatePrivacyAgree(context, true);
    }

    public static void b(Context context) {
        if (r90.G()) {
            try {
                HCJMapManager.initMap(1);
                WholeConfig.setLocationMockEnable(vl2.a());
                File fileStreamPath = context.getFileStreamPath(f45758a);
                File fileStreamPath2 = context.getFileStreamPath(b);
                if (fileStreamPath == null || !fileStreamPath.exists() || fileStreamPath.length() == 0) {
                    fileStreamPath = wv1.a(context, f45758a);
                }
                if (fileStreamPath2 == null || !fileStreamPath2.exists() || fileStreamPath2.length() == 0) {
                    fileStreamPath2 = wv1.a(context, b);
                }
                try {
                    WholeConfig.setGaodeMapStyle(fileStreamPath.getAbsolutePath(), fileStreamPath2.getAbsolutePath(), null, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void c(Context context) {
        AMapLocationClient.updatePrivacyShow(context, true, true);
        MapsInitializer.updatePrivacyShow(context, true, true);
    }
}

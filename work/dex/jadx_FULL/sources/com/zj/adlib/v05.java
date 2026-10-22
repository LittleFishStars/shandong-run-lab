package com.zj.adlib;

import android.content.Context;
import android.location.LocationManager;
import androidx.core.location.LocationManagerCompat;
import com.alibaba.sdk.android.oss.common.RequestParameters;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class v05 {
    public static boolean a(Context context) {
        return LocationManagerCompat.isLocationEnabled((LocationManager) context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION));
    }
}

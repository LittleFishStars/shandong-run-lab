package com.kwad.sdk.utils;

import android.text.TextUtils;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.internal.api.SplashExtraDataImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class c {
    public static int Ue() {
        String strVl = ai.Vl();
        if (TextUtils.isEmpty(strVl)) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(strVl);
            int iOptInt = jSONObject.optInt("currentDailyCount");
            if (b(jSONObject.optLong("lastShowTimestamp"), System.currentTimeMillis())) {
                return iOptInt;
            }
            return 0;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return 0;
        }
    }

    private static boolean b(long j, long j2) {
        if (j > 0 && j2 > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                return simpleDateFormat.format(new Date(j)).equals(simpleDateFormat.format(new Date(j2)));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
        }
        return false;
    }

    public static StatusInfo.SplashStyleControl f(SceneImpl sceneImpl) {
        StatusInfo.SplashStyleControl splashStyleControl = new StatusInfo.SplashStyleControl();
        if (sceneImpl == null || !h(sceneImpl)) {
            return null;
        }
        SplashExtraDataImpl splashExtraDataImpl = sceneImpl.splashExtraData;
        splashStyleControl.disableShake = splashExtraDataImpl.disableShake;
        splashStyleControl.disableRotate = splashExtraDataImpl.disableRotate;
        splashStyleControl.disableSlide = splashExtraDataImpl.disableSlide;
        return splashStyleControl;
    }

    public static StatusInfo.NativeAdStyleControl g(SceneImpl sceneImpl) {
        NativeAdExtraDataImpl nativeAdExtraDataImpl;
        StatusInfo.NativeAdStyleControl nativeAdStyleControl = new StatusInfo.NativeAdStyleControl();
        if (sceneImpl != null && (nativeAdExtraDataImpl = sceneImpl.nativeAdExtraData) != null) {
            nativeAdStyleControl.enableShake = nativeAdExtraDataImpl.enableShake;
            nativeAdStyleControl.enableRotate = nativeAdExtraDataImpl.enableRotate;
        }
        return nativeAdStyleControl;
    }

    private static boolean h(SceneImpl sceneImpl) {
        return sceneImpl.splashExtraData != null;
    }
}

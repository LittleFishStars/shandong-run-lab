package com.kwad.sdk.core.response.helper;

import androidx.annotation.NonNull;
import androidx.camera.video.AudioStats;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class SlideConvertHelper {

    public enum SlideDirection {
        UP(0),
        DOWN(1),
        LEFT(2),
        RIGHT(3);

        public int value;

        SlideDirection(int i) {
            this.value = i;
        }
    }

    public static boolean a(@NonNull AdTemplate adTemplate, float f, float f2, float f3, float f4) {
        SlideDirection slideDirection;
        AdInfo adInfoEO = e.eO(adTemplate);
        boolean zED = d.eD(adTemplate);
        String strAs = a.as(adInfoEO);
        int iAr = a.ar(adInfoEO);
        double d = f3 - f;
        double d2 = f4 - f2;
        float fPx2dip = com.kwad.sdk.c.a.a.px2dip(ServiceProvider.getContext(), (float) Math.sqrt(Math.pow(d, 2.0d) + Math.pow(d2, 2.0d)));
        if (Math.abs(d) >= Math.abs(d2)) {
            slideDirection = d > AudioStats.AUDIO_AMPLITUDE_NONE ? SlideDirection.RIGHT : SlideDirection.LEFT;
        } else {
            slideDirection = d2 > AudioStats.AUDIO_AMPLITUDE_NONE ? SlideDirection.DOWN : SlideDirection.UP;
        }
        return zED && fPx2dip > ((float) iAr) && strAs.charAt(slideDirection.value) == '1';
    }
}

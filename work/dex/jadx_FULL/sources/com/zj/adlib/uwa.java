package com.zj.adlib;

import androidx.camera.video.AudioStats;
import com.amap.api.maps.model.LatLng;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class uwa {
    public static double a(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d = latLng.latitude;
        double d2 = d - latLng3.latitude;
        double d3 = latLng.longitude;
        return ((d3 - latLng3.longitude) * (d - latLng2.latitude)) - ((d3 - latLng2.longitude) * d2);
    }

    public static boolean b(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4) {
        double dA = a(latLng3, latLng4, latLng);
        double dA2 = a(latLng3, latLng4, latLng2);
        double dA3 = a(latLng, latLng2, latLng3);
        double dA4 = a(latLng, latLng2, latLng4);
        if (((dA > AudioStats.AUDIO_AMPLITUDE_NONE && dA2 < AudioStats.AUDIO_AMPLITUDE_NONE) || (dA < AudioStats.AUDIO_AMPLITUDE_NONE && dA2 > AudioStats.AUDIO_AMPLITUDE_NONE)) && ((dA3 > AudioStats.AUDIO_AMPLITUDE_NONE && dA4 < AudioStats.AUDIO_AMPLITUDE_NONE) || (dA3 < AudioStats.AUDIO_AMPLITUDE_NONE && dA4 > AudioStats.AUDIO_AMPLITUDE_NONE))) {
            return true;
        }
        if (dA == AudioStats.AUDIO_AMPLITUDE_NONE && c(latLng3, latLng4, latLng)) {
            return true;
        }
        if (dA2 == AudioStats.AUDIO_AMPLITUDE_NONE && c(latLng3, latLng4, latLng2)) {
            return true;
        }
        if (dA3 == AudioStats.AUDIO_AMPLITUDE_NONE && c(latLng, latLng2, latLng3)) {
            return true;
        }
        return dA4 == AudioStats.AUDIO_AMPLITUDE_NONE && c(latLng, latLng2, latLng4);
    }

    public static boolean c(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d = latLng.longitude;
        double d2 = latLng2.longitude;
        double d3 = d - d2 > AudioStats.AUDIO_AMPLITUDE_NONE ? d : d2;
        if (d - d2 >= AudioStats.AUDIO_AMPLITUDE_NONE) {
            d = d2;
        }
        double d4 = latLng.latitude;
        double d5 = latLng2.latitude;
        double d6 = d4 - d5 > AudioStats.AUDIO_AMPLITUDE_NONE ? d4 : d5;
        if (d4 - d5 >= AudioStats.AUDIO_AMPLITUDE_NONE) {
            d4 = d5;
        }
        double d7 = latLng3.longitude;
        if (d > d7 || d7 > d3) {
            return false;
        }
        double d8 = latLng3.latitude;
        return d4 <= d8 && d8 <= d6;
    }
}

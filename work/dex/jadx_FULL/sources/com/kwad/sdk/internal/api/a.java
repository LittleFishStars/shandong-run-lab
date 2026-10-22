package com.kwad.sdk.internal.api;

import android.location.Location;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.kwad.sdk.api.KsLocation;
import com.kwad.sdk.core.d.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {
    private double mLatitude = AudioStats.AUDIO_AMPLITUDE_NONE;
    private double mLongitude = AudioStats.AUDIO_AMPLITUDE_NONE;
    private double mAltitude = AudioStats.AUDIO_AMPLITUDE_NONE;
    private float mSpeed = 0.0f;
    private float mBearing = 0.0f;

    @Nullable
    public static a a(Location location) {
        if (location == null) {
            return null;
        }
        a aVar = new a();
        aVar.mLatitude = location.getLatitude();
        aVar.mLongitude = location.getLongitude();
        aVar.mAltitude = location.getAltitude();
        aVar.mSpeed = location.getSpeed();
        aVar.mBearing = location.getBearing();
        return aVar;
    }

    @Nullable
    public static a p(Object obj) {
        try {
            if (!(obj instanceof KsLocation)) {
                return null;
            }
            KsLocation ksLocation = (KsLocation) obj;
            a aVar = new a();
            aVar.mLatitude = ksLocation.getLatitude();
            aVar.mLongitude = ksLocation.getLongitude();
            aVar.mAltitude = ksLocation.getAltitude();
            aVar.mSpeed = ksLocation.getSpeed();
            aVar.mBearing = ksLocation.getBearing();
            return aVar;
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
            return null;
        }
    }

    public final double getLatitude() {
        return this.mLatitude;
    }

    public final double getLongitude() {
        return this.mLongitude;
    }
}

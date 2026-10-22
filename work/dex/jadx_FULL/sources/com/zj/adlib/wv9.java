package com.zj.adlib;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmSession;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class wv9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f45700a = "LicenseDurationRemaining";
    public static final String b = "PlaybackDurationRemaining";

    public static long a(Map<String, String> map, String str) {
        if (map == null) {
            return -9223372036854775807L;
        }
        try {
            String str2 = map.get(str);
            if (str2 != null) {
                return Long.parseLong(str2);
            }
            return -9223372036854775807L;
        } catch (NumberFormatException unused) {
            return -9223372036854775807L;
        }
    }

    @Nullable
    public static Pair<Long, Long> b(DrmSession drmSession) {
        Map<String, String> mapQueryKeyStatus = drmSession.queryKeyStatus();
        if (mapQueryKeyStatus == null) {
            return null;
        }
        return new Pair<>(Long.valueOf(a(mapQueryKeyStatus, "LicenseDurationRemaining")), Long.valueOf(a(mapQueryKeyStatus, "PlaybackDurationRemaining")));
    }
}

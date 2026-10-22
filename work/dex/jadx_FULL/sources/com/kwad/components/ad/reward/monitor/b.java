package com.kwad.components.ad.reward.monitor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b {
    private static String TAG = "LivePlayMonitor";

    public static void a(int i, String str, String str2, Long l, int i2, String str3) {
        if (l == null) {
            l = -1L;
        }
        com.kwad.sdk.commercial.c.b("ad_sdk_live_video_error_monitor", new LivePlayMonitorInfo().setScene(2).setAppId(str).setAuthorId(str2).setUserId(l).setErrorCode(i2).setErrorMsg(str3));
        com.kwad.sdk.core.d.c.d(TAG, "reportAdLiveMonitorError, status:" + i2 + " scene:2 errMsg:" + str3 + " appId:" + str + " authorId" + str2 + " userId" + l);
    }
}

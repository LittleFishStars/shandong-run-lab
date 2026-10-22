package com.kc.openset.hook.web;

import android.net.Uri;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class HapUrlManager {
    public static final String HAP_MARK = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD);
    public static final String HAP_REG_INTERCEPT_END = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS);
    public static final String HAP_REG_INTERCEPT_START = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_DECODE_MS_GAPS);
    public static final String HAP_REG_SPLIT_STR = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_QUERY);
    private static final String TAG = OSETSDKProtected.getString2(1814);
    private static final Set<String> urlSet;
    private static final Set<String> urlWebSet;

    static {
        OSETSDKProtected.interface11(4462);
        urlWebSet = Collections.newSetFromMap(new ConcurrentHashMap());
        urlSet = new FixedSizeSet(200).toSet();
    }

    public static native void addHap(String str);

    public static native void addWebHap(String str);

    private static native boolean checkUrl(Uri uri, Set<String> set);

    public static native void clear();

    public static native void clearWeb();

    public static native boolean contains(String str);

    public static native boolean isQuickAppUrl(String str);

    public static native void remove(String str);
}

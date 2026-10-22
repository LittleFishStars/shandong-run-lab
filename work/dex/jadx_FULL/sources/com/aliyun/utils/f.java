package com.aliyun.utils;

import com.aliyun.dns.DomainProcessor;
import com.aliyun.loader.MediaLoader;
import com.aliyun.loader.VodMediaLoader;
import com.aliyun.player.AliPlayerGlobalSettings;
import com.aliyun.player.HlsKeyGenerator;
import com.aliyun.player.nativeclass.JniListPlayerBase;
import com.aliyun.player.nativeclass.JniSaasListPlayer;
import com.aliyun.player.nativeclass.JniSaasPlayer;
import com.aliyun.player.nativeclass.JniUrlListPlayer;
import com.aliyun.player.nativeclass.JniUrlPlayer;
import com.aliyun.player.nativeclass.NativeExternalPlayer;
import com.aliyun.player.nativeclass.NativePlayerBase;
import com.aliyun.private_service.PrivateService;
import com.aliyun.thumbnail.ThumbnailHelper;
import com.cicada.player.utils.Logger;
import com.cicada.player.utils.ass.AssUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f25870a = false;
    private static boolean b = false;

    public static synchronized void a() {
        b();
        if (b) {
            return;
        }
        try {
            b = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized void b() {
        if (f25870a) {
            return;
        }
        f25870a = true;
        JniUrlPlayer.loadClass();
        JniSaasPlayer.loadClass();
        JniListPlayerBase.loadClass();
        JniUrlListPlayer.loadClass();
        JniSaasListPlayer.loadClass();
        PrivateService.loadClass();
        DomainProcessor.loadClass();
        MediaLoader.loadClass();
        VodMediaLoader.loadClass();
        AliPlayerGlobalSettings.loadClass();
        HlsKeyGenerator.loadClass();
        NativeExternalPlayer.loadClass();
        NativePlayerBase.loadClass();
        ThumbnailHelper.loadClass();
        DeviceInfoUtils.loadClass();
        Logger.loadClass();
        AssUtils.loadClass();
        try {
            System.loadLibrary(com.aliyun.svideosdk.nativeload.a.SHARED_LIBRARY_FFMPEG_NAME);
            System.loadLibrary("all_in_one");
        } catch (Exception e) {
            e.printStackTrace();
            f25870a = false;
        }
    }
}

package com.kc.openset.hook.dl;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.bean.a;
import com.kc.openset.bridge.common.OSETHttpCallback;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class DeepLinkHttpUtils {
    private static final String POST_APP_KEY = OSETSDKProtected.getString2(464);
    private static final String POST_DEVICE_ID = OSETSDKProtected.getString2(468);
    private static final String POST_DEVICE_TYPE = OSETSDKProtected.getString2(1775);
    private static final String POST_SIGN = OSETSDKProtected.getString2(45);
    private static final String RESULT_DATA = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME);
    private static final String RESULT_DATA_CLK = OSETSDKProtected.getString2(1073);
    private static final String RESULT_DATA_DEEP_LINK = OSETSDKProtected.getString2(1772);
    private static final String RESULT_DATA_OP = OSETSDKProtected.getString2(1115);
    private static final String RESULT_DATA_REG = OSETSDKProtected.getString2(1379);
    private static final String RESULT_DATA_URLS = OSETSDKProtected.getString2(1773);
    private static final String RESULT_TIME_OUT = OSETSDKProtected.getString2(1771);
    private static final String SECRET_KEY = OSETSDKProtected.getString2(1780);
    private static final String TAG = OSETSDKProtected.getString2(1769);
    private static volatile DeepLinkHttpUtils instance;

    /* JADX INFO: renamed from: com.kc.openset.hook.dl.DeepLinkHttpUtils$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements OSETHttpCallback {
        final DeepLinkHttpUtils this$0;
        final ICallBack val$iCallBack;

        static {
            OSETSDKProtected.interface11(4450);
        }

        public AnonymousClass1(DeepLinkHttpUtils deepLinkHttpUtils, ICallBack iCallBack) {
            this.this$0 = deepLinkHttpUtils;
            this.val$iCallBack = iCallBack;
        }

        @Override // com.kc.openset.bridge.common.OSETHttpCallback
        public native void onFailure(int i, String str);

        @Override // com.kc.openset.bridge.common.OSETHttpCallback
        public native void onSuccess(int i, String str);
    }

    @Keep
    public interface ICallBack {
        void onLoadFail(String str, String str2);

        void onSuccess(a aVar);
    }

    static {
        OSETSDKProtected.interface11(4452);
    }

    private DeepLinkHttpUtils() {
    }

    public static native DeepLinkHttpUtils getInstance();

    public native void getDeepLinkConfig(ICallBack iCallBack);
}

package com.kc.openset.common.glide_v4;

import android.content.Context;
import android.widget.ImageView;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.utils.LogUtilsBridge;
import com.kc.openset.bridge.common.BaseImageLoaderBridge;
import com.kc.openset.util.OSETImageLoader;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class GlideBridge implements BaseImageLoaderBridge {
    private static final String TAG = OSETSDKProtected.getString2(1469);
    private boolean isAvailable;
    private GlideReflector mGlideReflector;

    static {
        OSETSDKProtected.interface11(4375);
    }

    public GlideBridge() {
        String string2 = OSETSDKProtected.getString2(1469);
        try {
            Class.forName(OSETSDKProtected.getString2("1470"));
            Class.forName(OSETSDKProtected.getString2("1471"));
            this.isAvailable = true;
            this.mGlideReflector = GlideReflector.getInstance();
            LogUtilsBridge.d(string2, OSETSDKProtected.getString2("1472"));
        } catch (Exception unused) {
            LogUtilsBridge.e(string2, OSETSDKProtected.getString2(1473));
            this.isAvailable = false;
        }
    }

    @Override // com.kc.openset.bridge.common.BaseImageLoaderBridge
    public native void getBitmap(Context context, String str, int i, OSETImageLoader.BitmapCallback bitmapCallback);

    @Override // com.kc.openset.bridge.common.BaseImageLoaderBridge
    public native void getDrawable(Context context, String str, int i, OSETImageLoader.DrawableCallback drawableCallback);

    @Override // com.kc.openset.bridge.common.BaseCommonBridge
    public native boolean isAvailable();

    @Override // com.kc.openset.bridge.common.BaseImageLoaderBridge
    public native void loadImage(Context context, String str, ImageView imageView, int i);
}

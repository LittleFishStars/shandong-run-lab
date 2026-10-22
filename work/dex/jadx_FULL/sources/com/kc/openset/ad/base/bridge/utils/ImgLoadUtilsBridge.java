package com.kc.openset.ad.base.bridge.utils;

import android.content.Context;
import android.widget.ImageView;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.util.LoadDrawableListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class ImgLoadUtilsBridge {
    static {
        OSETSDKProtected.interface11(3789);
    }

    public static native void getDrawable(Context context, String str, int i, LoadDrawableListener loadDrawableListener);

    public static native void getDrawable(Context context, String str, LoadDrawableListener loadDrawableListener);

    public static native void loadImage(Context context, String str, ImageView imageView);

    public static native void loadImage(Context context, String str, ImageView imageView, int i);
}

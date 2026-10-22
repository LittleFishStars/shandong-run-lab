package com.kc.openset.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class n {

    @Keep
    public class a implements OSETImageLoader.DrawableCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final LoadDrawableListener f39979a;

        static {
            OSETSDKProtected.interface11(5022);
        }

        public a(LoadDrawableListener loadDrawableListener) {
            this.f39979a = loadDrawableListener;
        }

        @Override // com.kc.openset.util.OSETImageLoader.DrawableCallback
        public native void onDrawableLoaded(Drawable drawable);
    }

    static {
        OSETSDKProtected.interface11(5023);
    }

    public static native void a(Context context, String str, int i, LoadDrawableListener loadDrawableListener);

    public static native void a(Context context, String str, ImageView imageView);

    public static native void a(Context context, String str, ImageView imageView, int i);
}

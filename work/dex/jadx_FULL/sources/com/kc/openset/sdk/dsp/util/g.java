package com.kc.openset.sdk.dsp.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.util.LoadBitmapListener;
import com.kc.openset.util.OSETImageLoader;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class g {

    @Keep
    public class a implements OSETImageLoader.BitmapCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ImageView f39931a;
        final LoadBitmapListener b;

        static {
            OSETSDKProtected.interface11(4907);
        }

        public a(ImageView imageView, LoadBitmapListener loadBitmapListener) {
            this.f39931a = imageView;
            this.b = loadBitmapListener;
        }

        @Override // com.kc.openset.util.OSETImageLoader.BitmapCallback
        public native void onBitmapLoaded(Bitmap bitmap);
    }

    static {
        OSETSDKProtected.interface11(4908);
    }

    public static native void a(Context context, ImageView imageView, String str, LoadBitmapListener loadBitmapListener);

    public static native void a(Context context, String str, ImageView imageView);
}

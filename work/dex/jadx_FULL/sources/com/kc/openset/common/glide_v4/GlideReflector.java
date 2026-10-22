package com.kc.openset.common.glide_v4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.util.OSETImageLoader;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class GlideReflector {
    private static final String CLASS_NAME_DRAWABLE_TYPE_REQUEST = OSETSDKProtected.getString2(1474);
    private static final String CLASS_NAME_GLIDE = OSETSDKProtected.getString2(1470);
    private static final String CLASS_NAME_REQUEST_BUILDER = OSETSDKProtected.getString2(1471);
    private static final String CLASS_NAME_REQUEST_MANAGER = OSETSDKProtected.getString2(1475);
    private static final String CLASS_NAME_REQUEST_OPTIONS = OSETSDKProtected.getString2(1476);
    private static final String CLASS_NAME_ROUNDED_CORNERS = OSETSDKProtected.getString2(1477);
    private static final String KEY_DRAWABLE_TYPE_REQUEST = OSETSDKProtected.getString2(1478);
    private static final String KEY_GLIDE = OSETSDKProtected.getString2(1479);
    private static final String KEY_REQUEST_BUILDER = OSETSDKProtected.getString2(1480);
    private static final String KEY_REQUEST_MANAGER = OSETSDKProtected.getString2(1481);
    private static final String KEY_REQUEST_OPTIONS = OSETSDKProtected.getString2(1482);
    private static final String KEY_ROUNDED_CORNERS = OSETSDKProtected.getString2(1483);
    private static final String TAG = OSETSDKProtected.getString2(1484);
    private static volatile GlideReflector instance;

    /* JADX INFO: renamed from: com.kc.openset.common.glide_v4.GlideReflector$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 extends CustomTarget<Bitmap> {
        final GlideReflector this$0;
        final OSETImageLoader.BitmapCallback val$callback;

        static {
            OSETSDKProtected.interface11(4376);
        }

        public AnonymousClass1(GlideReflector glideReflector, OSETImageLoader.BitmapCallback bitmapCallback) {
            this.this$0 = glideReflector;
            this.val$callback = bitmapCallback;
        }

        @Override // com.bumptech.glide.request.target.Target
        public native void onLoadCleared(Drawable drawable);

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public native void onLoadFailed(Drawable drawable);

        public native void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition);

        @Override // com.bumptech.glide.request.target.Target
        public native /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition);
    }

    /* JADX INFO: renamed from: com.kc.openset.common.glide_v4.GlideReflector$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 extends CustomTarget<Drawable> {
        final GlideReflector this$0;
        final OSETImageLoader.DrawableCallback val$callback;

        static {
            OSETSDKProtected.interface11(4377);
        }

        public AnonymousClass2(GlideReflector glideReflector, OSETImageLoader.DrawableCallback drawableCallback) {
            this.this$0 = glideReflector;
            this.val$callback = drawableCallback;
        }

        @Override // com.bumptech.glide.request.target.Target
        public native void onLoadCleared(Drawable drawable);

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public native void onLoadFailed(Drawable drawable);

        public native void onResourceReady(Drawable drawable, Transition<? super Drawable> transition);

        @Override // com.bumptech.glide.request.target.Target
        public native /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition);
    }

    static {
        OSETSDKProtected.interface11(4378);
        instance = null;
    }

    private GlideReflector() {
    }

    public static native GlideReflector getInstance();

    private native void loadWithGlideV4(Context context, String str, ImageView imageView, int i);

    public native void loadBitmapV4(Context context, String str, int i, OSETImageLoader.BitmapCallback bitmapCallback);

    public native void loadDrawableV4(Context context, String str, int i, OSETImageLoader.DrawableCallback drawableCallback);

    public native void loadImage(Context context, String str, ImageView imageView, int i);
}

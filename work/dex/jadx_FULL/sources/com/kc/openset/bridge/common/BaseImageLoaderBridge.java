package com.kc.openset.bridge.common;

import android.content.Context;
import android.widget.ImageView;
import com.kc.openset.util.OSETImageLoader;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface BaseImageLoaderBridge extends BaseCommonBridge {
    void getBitmap(Context context, String str, int i, OSETImageLoader.BitmapCallback bitmapCallback);

    void getDrawable(Context context, String str, int i, OSETImageLoader.DrawableCallback drawableCallback);

    void loadImage(Context context, String str, ImageView imageView, int i);
}

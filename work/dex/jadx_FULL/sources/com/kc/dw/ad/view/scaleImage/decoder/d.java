package com.kc.dw.ad.view.scaleImage.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface d {
    Bitmap a(Rect rect, int i);

    Point a(Context context, Uri uri) throws Exception;

    boolean a();

    void b();
}

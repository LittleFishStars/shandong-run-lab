package com.czhj.sdk.common.network;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import com.czhj.sdk.common.utils.DeviceUtils;
import com.czhj.volley.RequestQueue;
import com.czhj.volley.toolbox.ImageLoader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
class MaxWidthImageLoader extends ImageLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29411a;

    public MaxWidthImageLoader(RequestQueue requestQueue, Context context, ImageLoader.ImageCache imageCache) {
        int iMin;
        super(requestQueue, imageCache);
        Display display = DeviceUtils.getDisplay(context);
        if (display == null) {
            iMin = 320;
        } else {
            Point point = new Point();
            display.getSize(point);
            iMin = Math.min(point.x, point.y);
        }
        this.f29411a = iMin;
    }

    @Override // com.czhj.volley.toolbox.ImageLoader
    public ImageLoader.ImageContainer get(String str, ImageLoader.ImageListener imageListener) {
        return super.get(str, imageListener, this.f29411a, 0);
    }
}

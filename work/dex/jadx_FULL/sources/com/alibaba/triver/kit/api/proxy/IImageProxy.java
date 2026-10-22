package com.alibaba.triver.kit.api.proxy;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IImageProxy extends Proxiable {

    public interface ImageListener {
        void onImageFinish(Drawable drawable);
    }

    public static class ImageStrategy {
        public int blurRadius;
        public boolean isSharpen;
        public int roundCornerRadius;
        public String sizeLimitType;
    }

    void loadImage(String str, ImageStrategy imageStrategy, ImageListener imageListener);

    void setImageUrl(ImageView imageView, String str, ImageStrategy imageStrategy);
}

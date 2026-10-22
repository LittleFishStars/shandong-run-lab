package cn.hzjizhun.admin.image;

import android.widget.ImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ImageLoader {
    void loadImage(String str, ImageView imageView);

    void loadImage(String str, ImageView imageView, ImageLoaderCallback imageLoaderCallback);

    void preLoadImage(String str);

    void preLoadImage(String str, ImageLoaderCallback imageLoaderCallback);
}

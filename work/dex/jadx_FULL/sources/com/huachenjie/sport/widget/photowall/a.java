package com.huachenjie.sport.widget.photowall;

import android.graphics.Bitmap;
import androidx.coroutines.BindingAdapter;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class a {
    @BindingAdapter(requireAll = false, value = {"onItemClick"})
    public static void a(PhotoWall photoWall, PhotoWall.OnItemClickListener onItemClickListener) {
        photoWall.setOnItemClickListener(onItemClickListener);
    }

    @BindingAdapter(requireAll = false, value = {"bitmapImages", "size", "between", "radius"})
    public static void b(PhotoWall photoWall, List<Bitmap> list, int i, int i2, int i3) {
        if (i > 0) {
            photoWall.setMaxItem(i);
        }
        if (i2 > 0) {
            photoWall.setSpaceBetween(i2);
        }
        if (i3 > 0) {
            photoWall.setRadius(i3);
        }
        photoWall.setBitmapImages(list);
    }
}

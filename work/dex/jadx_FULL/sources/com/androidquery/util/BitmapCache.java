package com.androidquery.util;

import android.graphics.Bitmap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BitmapCache extends LinkedHashMap<String, Bitmap> {
    private static final long serialVersionUID = 1;
    private int maxCount;
    private int maxPixels;
    private int maxTotalPixels;
    private int pixels;

    public BitmapCache(int i, int i2, int i3) {
        super(8, 0.75f, true);
        this.maxCount = i;
        this.maxPixels = i2;
        this.maxTotalPixels = i3;
    }

    private int pixels(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth() * bitmap.getHeight();
    }

    private void shrink() {
        if (this.pixels > this.maxTotalPixels) {
            Iterator<String> it = keySet().iterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
                if (this.pixels <= this.maxTotalPixels) {
                    return;
                }
            }
        }
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        super.clear();
        this.pixels = 0;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, Bitmap> entry) {
        if (this.pixels > this.maxTotalPixels || size() > this.maxCount) {
            remove((Object) entry.getKey());
        }
        shrink();
        return false;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Bitmap put(String str, Bitmap bitmap) {
        int iPixels = pixels(bitmap);
        if (iPixels > this.maxPixels) {
            return null;
        }
        this.pixels += iPixels;
        Bitmap bitmap2 = (Bitmap) super.put(str, bitmap);
        if (bitmap2 == null) {
            return bitmap2;
        }
        this.pixels -= pixels(bitmap2);
        return bitmap2;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Bitmap remove(Object obj) {
        Bitmap bitmap = (Bitmap) super.remove(obj);
        if (bitmap != null) {
            this.pixels -= pixels(bitmap);
        }
        return bitmap;
    }
}

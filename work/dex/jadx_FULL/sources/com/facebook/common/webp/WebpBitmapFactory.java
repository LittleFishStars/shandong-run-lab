package com.facebook.common.webp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import java.io.FileDescriptor;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface WebpBitmapFactory {
    Bitmap a(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options);

    Bitmap b(String str, BitmapFactory.Options options);

    Bitmap c(InputStream inputStream, Rect rect, BitmapFactory.Options options);

    Bitmap d(byte[] bArr, int i, int i2, BitmapFactory.Options options);
}

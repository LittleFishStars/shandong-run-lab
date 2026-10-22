package com.huachenjie.base.aliyun.detect_face.util;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface TakePhotoCallback {
    void a(@NonNull Bitmap bitmap);

    void onError(String errorMessage);
}

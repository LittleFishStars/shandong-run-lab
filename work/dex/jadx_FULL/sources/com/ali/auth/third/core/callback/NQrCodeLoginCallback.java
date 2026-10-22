package com.ali.auth.third.core.callback;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface NQrCodeLoginCallback extends LoginCallback {

    public interface NQrCodeLoginController {
        void cancle();
    }

    void onQrImageLoaded(String str, Bitmap bitmap, NQrCodeLoginController nQrCodeLoginController);

    void onQrImageStatusChanged(String str, int i);
}

package com.aliyun.svideosdk.multirecorder;

import android.graphics.Bitmap;
import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public interface OnPictureCallback {
    void onPicture(Bitmap bitmap);

    void onPicture(byte[] bArr);
}

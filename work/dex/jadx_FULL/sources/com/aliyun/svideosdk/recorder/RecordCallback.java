package com.aliyun.svideosdk.recorder;

import android.graphics.Bitmap;
import com.aliyun.Visible;
import com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@Visible
@Deprecated
public interface RecordCallback extends OnRecordCallback {
    @Deprecated
    void onPictureBack(Bitmap bitmap);

    @Deprecated
    void onPictureDataBack(byte[] bArr);
}

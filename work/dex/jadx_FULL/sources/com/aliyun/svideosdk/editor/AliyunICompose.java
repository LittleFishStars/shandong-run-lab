package com.aliyun.svideosdk.editor;

import android.content.Context;
import com.alibaba.sdk.android.vod.upload.model.SvideoInfo;
import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
@Deprecated
public interface AliyunICompose extends AliyunIBaseCompose {

    @Visible
    @Deprecated
    public interface AliyunIUploadCallBack {
        void onSTSTokenExpired();

        void onUploadFailed(String str, String str2);

        void onUploadProgress(long j, long j2);

        void onUploadRetry(String str, String str2);

        void onUploadRetryResume();

        void onUploadSucceed(String str, String str2);
    }

    int cancelUpload();

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    int init(Context context);

    void pauseUpload();

    int refreshSTSToken(String str, String str2, String str3, String str4);

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    void release();

    void resumeUpload();

    void setUploadRetryAndTimeout(int i, int i2, int i3);

    int uploadWithVideoAndImg(String str, String str2, String str3, String str4, String str5, SvideoInfo svideoInfo, boolean z, String str6, String str7, AliyunIUploadCallBack aliyunIUploadCallBack);
}

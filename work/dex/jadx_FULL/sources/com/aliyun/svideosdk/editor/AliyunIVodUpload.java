package com.aliyun.svideosdk.editor;

import android.content.Context;
import com.alibaba.sdk.android.vod.upload.model.FilePartInfo;
import com.aliyun.Visible;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public interface AliyunIVodUpload {

    @Visible
    public interface AliyunIVodUploadCallBack {
        void onUploadFailed(String str, String str2);

        void onUploadProgress(long j, long j2);

        void onUploadRetry(String str, String str2);

        void onUploadRetryResume();

        void onUploadSucceed();

        void onUploadTokenExpired();
    }

    int cancelUpload();

    int init(Context context, AliyunIVodUploadCallBack aliyunIVodUploadCallBack);

    int init(Context context, AliyunIVodUploadCallBack aliyunIVodUploadCallBack, boolean z);

    int pauseUpload();

    int refreshWithUploadAuth(String str);

    void release();

    int resumeUpload();

    void updatePartInfoList(String str, List<FilePartInfo> list, boolean z);

    int uploadImageWithVod(String str, String str2, String str3);

    int uploadVideoWithVod(String str, String str2, String str3);

    int uploadVideoWithVod(String str, String str2, String str3, List<FilePartInfo> list);
}

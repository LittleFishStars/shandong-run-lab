package com.aliyun.svideosdk.editor;

import android.content.Context;
import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public interface AliyunIVodCompose extends AliyunIBaseCompose {

    @Visible
    public enum AliyunComposeState {
        STATE_IDLE,
        STATE_IMAGE_UPLOADING,
        STATE_VIDEO_UPLOADING
    }

    @Visible
    public enum AliyunComposeUploadState {
        STATE_IDLE,
        STATE_GET_UPLOAD_AUTH,
        STATE_GET_UPLOAD_AUTH_SUCCEED,
        STATE_VIDEO_UPLOADING
    }

    @Visible
    public interface AliyunIVodUploadCallBack extends AliyunIVodUpload.AliyunIVodUploadCallBack {
    }

    int cancelUpload();

    int composeAndUpload(String str, String str2, ComposeAndUploadCallBack composeAndUploadCallBack);

    AliyunComposeState getState();

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    @Visible
    int init(Context context);

    @Visible
    int init(Context context, boolean z);

    int pauseUpload();

    int refreshWithUploadAuth(String str);

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    void release();

    int resumeUpload();

    int uploadImageWithVod(String str, String str2, String str3, AliyunIVodUploadCallBack aliyunIVodUploadCallBack);

    int uploadVideoWithVod(String str, String str2, String str3, AliyunIVodUploadCallBack aliyunIVodUploadCallBack);
}

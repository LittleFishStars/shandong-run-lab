package com.aliyun.svideosdk.editor;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public abstract class ComposeAndUploadCallBack implements AliyunIComposeCallBack, AliyunIVodCompose.AliyunIVodUploadCallBack {

    @Visible
    public interface VideoUploadAuthCallBack {
        void onFailure(int i, String str);

        void onSuccess(String str, String str2, String str3);
    }

    public abstract void getVideoUploadAuth(VideoUploadAuthCallBack videoUploadAuthCallBack);
}

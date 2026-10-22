package com.alibaba.sdk.android.vod.upload.internal;

import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.vod.upload.model.OSSConfig;
import com.alibaba.sdk.android.vod.upload.model.UploadFileInfo;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface OSSUploader {
    void cancel();

    void init(OSSConfig oSSConfig, OSSUploadListener oSSUploadListener);

    void pause();

    void resume();

    void setOSSClientConfiguration(ClientConfiguration clientConfiguration);

    void setRecordUploadProgressEnabled(boolean z);

    void start(UploadFileInfo uploadFileInfo) throws FileNotFoundException;
}

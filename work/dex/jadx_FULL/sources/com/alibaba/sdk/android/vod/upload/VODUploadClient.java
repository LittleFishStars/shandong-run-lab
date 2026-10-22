package com.alibaba.sdk.android.vod.upload;

import com.alibaba.sdk.android.vod.upload.common.VodUploadStateType;
import com.alibaba.sdk.android.vod.upload.model.FilePartInfo;
import com.alibaba.sdk.android.vod.upload.model.UploadFileInfo;
import com.alibaba.sdk.android.vod.upload.model.VodInfo;
import com.alibaba.sdk.android.vod.upload.session.VodHttpClientConfig;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface VODUploadClient {
    void addFile(String str, VodInfo vodInfo);

    void addFile(String str, VodInfo vodInfo, List<FilePartInfo> list);

    void addFile(String str, String str2, String str3, String str4);

    void addFile(String str, String str2, String str3, String str4, VodInfo vodInfo);

    void cancelFile(int i);

    void clearFiles();

    void deleteFile(int i);

    VodUploadStateType getStatus();

    void init(VODUploadCallback vODUploadCallback);

    void init(String str, String str2, VODUploadCallback vODUploadCallback);

    void init(String str, String str2, String str3, String str4, VODUploadCallback vODUploadCallback);

    List<UploadFileInfo> listFiles();

    void pause();

    void resume();

    void resumeFile(int i);

    void resumeWithAuth(String str);

    void resumeWithToken(String str, String str2, String str3, String str4);

    void setAppId(String str);

    void setDisableMultiPart(boolean z);

    void setPartSize(long j);

    void setRecordUploadProgressEnabled(boolean z);

    void setRegion(String str);

    void setStorageLocation(String str);

    void setTemplateGroupId(String str);

    void setTranscodeMode(boolean z);

    void setUploadAuthAndAddress(UploadFileInfo uploadFileInfo, String str, String str2);

    void setVodHttpClientConfig(VodHttpClientConfig vodHttpClientConfig);

    void setWorkflowId(String str);

    void start();

    void stop();
}

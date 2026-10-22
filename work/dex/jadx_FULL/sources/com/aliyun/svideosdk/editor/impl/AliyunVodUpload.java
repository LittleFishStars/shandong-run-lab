package com.aliyun.svideosdk.editor.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.sdk.android.vod.upload.VODUploadCallback;
import com.alibaba.sdk.android.vod.upload.VODUploadClient;
import com.alibaba.sdk.android.vod.upload.VODUploadClientImpl;
import com.alibaba.sdk.android.vod.upload.common.UploadStateType;
import com.alibaba.sdk.android.vod.upload.model.FilePartInfo;
import com.alibaba.sdk.android.vod.upload.model.UploadFileInfo;
import com.alibaba.sdk.android.vod.upload.model.VodUploadResult;
import com.alibaba.sdk.android.vod.upload.session.VodHttpClientConfig;
import com.aliyun.Visible;
import com.aliyun.svideosdk.editor.AliyunIVodUpload;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class AliyunVodUpload implements AliyunIVodUpload {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private VODUploadClient f25733a;
    private Map<String, String> b = new HashMap();
    private Map<String, String> c = new HashMap();

    @Visible
    public final class VodUploadCallbackImpl extends VODUploadCallback {
        AliyunIVodUpload.AliyunIVodUploadCallBack mAliyunIVodUploadCallBack;

        public VodUploadCallbackImpl(AliyunIVodUpload.AliyunIVodUploadCallBack aliyunIVodUploadCallBack) {
            this.mAliyunIVodUploadCallBack = aliyunIVodUploadCallBack;
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODUploadCallback
        public void onUploadFailed(UploadFileInfo uploadFileInfo, String str, String str2) {
            super.onUploadFailed(uploadFileInfo, str, str2);
            Log.d("AliYunLog", "Bucket:" + uploadFileInfo.getBucket() + "\nObjectKey:" + uploadFileInfo.getObject());
            Log.d("AliYunLog", "onUploadFailed");
            AliyunIVodUpload.AliyunIVodUploadCallBack aliyunIVodUploadCallBack = this.mAliyunIVodUploadCallBack;
            if (aliyunIVodUploadCallBack != null) {
                aliyunIVodUploadCallBack.onUploadFailed(str, str2);
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODUploadCallback
        public void onUploadProgress(UploadFileInfo uploadFileInfo, long j, long j2) {
            super.onUploadProgress(uploadFileInfo, j, j2);
            Log.d("AliYunLog", "onUploadProgress:uploadedSize:" + j + "\ntotalSize:" + j2);
            AliyunIVodUpload.AliyunIVodUploadCallBack aliyunIVodUploadCallBack = this.mAliyunIVodUploadCallBack;
            if (aliyunIVodUploadCallBack != null) {
                aliyunIVodUploadCallBack.onUploadProgress(j, j2);
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODUploadCallback
        public void onUploadRetry(String str, String str2) {
            super.onUploadRetry(str, str2);
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODUploadCallback
        public void onUploadRetryResume() {
            super.onUploadRetryResume();
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODUploadCallback
        public void onUploadStarted(UploadFileInfo uploadFileInfo) {
            super.onUploadStarted(uploadFileInfo);
            Log.d("AliYunLog", "onUploadStarted:" + com.aliyun.common.utils.k.a(uploadFileInfo.getFilePath()));
            String str = (String) AliyunVodUpload.this.c.get(com.aliyun.common.utils.k.a(uploadFileInfo.getFilePath()));
            String str2 = (String) AliyunVodUpload.this.b.get(com.aliyun.common.utils.k.a(uploadFileInfo.getFilePath()));
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                throw new RuntimeException("upload status error!");
            }
            AliyunVodUpload.this.f25733a.setUploadAuthAndAddress(uploadFileInfo, str, str2);
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODUploadCallback
        public void onUploadSucceed(UploadFileInfo uploadFileInfo) {
            super.onUploadSucceed(uploadFileInfo);
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODUploadCallback
        public void onUploadSucceed(UploadFileInfo uploadFileInfo, VodUploadResult vodUploadResult) {
            Log.d("AliYunLog", "Bucket:" + uploadFileInfo.getBucket() + "\nObjectKey:" + uploadFileInfo.getObject());
            AliyunIVodUpload.AliyunIVodUploadCallBack aliyunIVodUploadCallBack = this.mAliyunIVodUploadCallBack;
            if (aliyunIVodUploadCallBack != null) {
                aliyunIVodUploadCallBack.onUploadSucceed();
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODUploadCallback
        public void onUploadTokenExpired() {
            super.onUploadTokenExpired();
            Log.d("AliYunLog", "OnUploadTokenExpired");
            AliyunIVodUpload.AliyunIVodUploadCallBack aliyunIVodUploadCallBack = this.mAliyunIVodUploadCallBack;
            if (aliyunIVodUploadCallBack != null) {
                aliyunIVodUploadCallBack.onUploadTokenExpired();
            }
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload
    public int cancelUpload() {
        VODUploadClient vODUploadClient = this.f25733a;
        if (vODUploadClient == null) {
            return 0;
        }
        vODUploadClient.stop();
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload
    public int init(Context context, AliyunIVodUpload.AliyunIVodUploadCallBack aliyunIVodUploadCallBack) {
        if (this.f25733a == null) {
            this.f25733a = new VODUploadClientImpl(context);
        }
        this.f25733a.init(new VodUploadCallbackImpl(aliyunIVodUploadCallBack));
        this.f25733a.setPartSize(1048576L);
        this.f25733a.setRecordUploadProgressEnabled(false);
        this.f25733a.setVodHttpClientConfig(VodHttpClientConfig.builder().setMaxRetryCount(Integer.MAX_VALUE).setConnectionTimeout(15000).setSocketTimeout(15000).build());
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload
    public int init(Context context, AliyunIVodUpload.AliyunIVodUploadCallBack aliyunIVodUploadCallBack, boolean z) {
        if (this.f25733a == null) {
            this.f25733a = new VODUploadClientImpl(context);
        }
        ((VODUploadClientImpl) this.f25733a).setReportEnabled(z);
        this.f25733a.init(new VodUploadCallbackImpl(aliyunIVodUploadCallBack));
        this.f25733a.setPartSize(1048576L);
        this.f25733a.setRecordUploadProgressEnabled(false);
        this.f25733a.setVodHttpClientConfig(VodHttpClientConfig.builder().setMaxRetryCount(Integer.MAX_VALUE).setConnectionTimeout(15000).setSocketTimeout(15000).build());
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload
    public int pauseUpload() {
        VODUploadClient vODUploadClient = this.f25733a;
        if (vODUploadClient == null) {
            return 0;
        }
        vODUploadClient.pause();
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload
    public int refreshWithUploadAuth(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e("AliYunLog", "ImagePath can not null!");
            return -20003001;
        }
        this.f25733a.resumeWithAuth(str);
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload
    public void release() {
        VODUploadClient vODUploadClient = this.f25733a;
        if (vODUploadClient != null) {
            vODUploadClient.stop();
            this.f25733a = null;
        }
        this.b.clear();
        this.c.clear();
        this.b = null;
        this.c = null;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload
    public int resumeUpload() {
        VODUploadClient vODUploadClient = this.f25733a;
        if (vODUploadClient == null) {
            return 0;
        }
        vODUploadClient.resume();
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload
    public void updatePartInfoList(String str, List<FilePartInfo> list, boolean z) {
        for (UploadFileInfo uploadFileInfo : new ArrayList(this.f25733a.listFiles())) {
            if (uploadFileInfo.getFilePath().equals(str)) {
                if (uploadFileInfo.getPartInfoList().size() < list.size()) {
                    uploadFileInfo.getPartInfoList().addAll(list.subList(uploadFileInfo.getPartInfoList().size(), list.size()));
                }
                if (z) {
                    FilePartInfo filePartInfo = uploadFileInfo.getPartInfoList().get(uploadFileInfo.getPartInfoList().size() - 1);
                    uploadFileInfo.setFileLength(filePartInfo.getSeek() + filePartInfo.getSize());
                }
                if (uploadFileInfo.getStatus() == UploadStateType.PAUSED || uploadFileInfo.getStatus() == UploadStateType.PAUSING) {
                    this.f25733a.pause();
                    this.f25733a.resume();
                    return;
                }
                return;
            }
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload
    public int uploadImageWithVod(String str, String str2, String str3) {
        if (!new File(str).exists()) {
            Log.e("AliYunLog", "imagePath not exists!");
            return -20003005;
        }
        Log.e("AliYunLog", "uploadImageWithVod:" + String.valueOf(str));
        this.b.put(com.aliyun.common.utils.k.a(str), str2);
        this.c.put(com.aliyun.common.utils.k.a(str), str3);
        this.f25733a.addFile(str, null);
        this.f25733a.start();
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload
    public int uploadVideoWithVod(String str, String str2, String str3) {
        if (!new File(str).exists()) {
            Log.e("AliYunLog", "videoPath not exists!");
            return -20003005;
        }
        Log.e("AliYunLog", "uploadVideoWithVod:" + String.valueOf(str));
        this.b.put(com.aliyun.common.utils.k.a(str), str2);
        this.c.put(com.aliyun.common.utils.k.a(str), str3);
        this.f25733a.addFile(str, null);
        this.f25733a.start();
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload
    public int uploadVideoWithVod(String str, String str2, String str3, List<FilePartInfo> list) {
        if (!new File(str).exists()) {
            Log.e("AliYunLog", "videoPath not exists!");
            return -20003005;
        }
        this.b.put(com.aliyun.common.utils.k.a(str), str2);
        this.c.put(com.aliyun.common.utils.k.a(str), str3);
        this.f25733a.addFile(str, null, list);
        this.f25733a.start();
        return 0;
    }
}

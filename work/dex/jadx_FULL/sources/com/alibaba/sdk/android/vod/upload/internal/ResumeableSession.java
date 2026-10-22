package com.alibaba.sdk.android.vod.upload.internal;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.vod.upload.common.utils.MD5;
import com.alibaba.sdk.android.vod.upload.common.utils.SharedPreferencesUtil;
import com.alibaba.sdk.android.vod.upload.model.OSSUploadInfo;
import com.alibaba.sdk.android.vod.upload.model.UploadFileInfo;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ResumeableSession {
    private static final String OSSUPLOAD_INFO = "OSS_UPLOAD_INFO";
    public static final String SHAREDPREFS_OSSUPLOAD = "OSS_UPLOAD_CONFIG";
    private WeakReference<Context> context;
    private boolean enabled = true;

    public ResumeableSession(Context context) {
        this.context = new WeakReference<>(context);
    }

    public synchronized boolean deleteResumeableFileInfo(String str) {
        if (!this.enabled) {
            return true;
        }
        OSSUploadInfo uploadInfo = SharedPreferencesUtil.getUploadInfo(this.context.get(), SHAREDPREFS_OSSUPLOAD, str);
        if (uploadInfo == null || !MD5.checkMD5(this.context.get(), uploadInfo.getMd5(), str)) {
            return false;
        }
        return SharedPreferencesUtil.clearUploadInfo(this.context.get(), SHAREDPREFS_OSSUPLOAD, str);
    }

    public synchronized UploadFileInfo getResumeableFileInfo(UploadFileInfo uploadFileInfo, String str) {
        if (!this.enabled) {
            return uploadFileInfo;
        }
        OSSUploadInfo uploadInfo = SharedPreferencesUtil.getUploadInfo(this.context.get(), SHAREDPREFS_OSSUPLOAD, uploadFileInfo.getFilePath());
        if (TextUtils.isEmpty(str)) {
            OSSLog.logDebug("videoId cannot be null");
        } else {
            uploadFileInfo.setBucket(uploadInfo.getBucket());
            uploadFileInfo.setObject(uploadInfo.getObject());
            uploadFileInfo.setEndpoint(uploadInfo.getEndpoint());
        }
        return uploadFileInfo;
    }

    public synchronized String getResumeableFileVideoID(String str) {
        if (!this.enabled) {
            return null;
        }
        OSSUploadInfo uploadInfo = SharedPreferencesUtil.getUploadInfo(this.context.get(), SHAREDPREFS_OSSUPLOAD, str);
        OSSLog.logDebug("getResumeableFileInfo1" + uploadInfo);
        if (uploadInfo == null || !MD5.checkMD5(this.context.get(), uploadInfo.getMd5(), str)) {
            return null;
        }
        return uploadInfo.getVideoID();
    }

    public synchronized void saveResumeableFileInfo(UploadFileInfo uploadFileInfo, String str) {
        OSSUploadInfo oSSUploadInfo = new OSSUploadInfo();
        oSSUploadInfo.setBucket(uploadFileInfo.getBucket());
        oSSUploadInfo.setEndpoint(uploadFileInfo.getEndpoint());
        oSSUploadInfo.setObject(uploadFileInfo.getObject());
        oSSUploadInfo.setMd5(MD5.calculateMD5(this.context.get(), uploadFileInfo.getFilePath()));
        oSSUploadInfo.setVideoID(str);
        try {
            OSSLog.logDebug("saveUploadInfo" + oSSUploadInfo, toString());
            SharedPreferencesUtil.saveUploadInfp(this.context.get(), SHAREDPREFS_OSSUPLOAD, uploadFileInfo.getFilePath(), oSSUploadInfo);
        } catch (Exception e) {
            e.printStackTrace();
            OSSLog.logDebug("saveUploadInfo error");
        }
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public synchronized boolean deleteResumeableFileInfo(String str, boolean z) {
        OSSUploadInfo uploadInfo;
        if (!z) {
            if (!this.enabled) {
                return true;
            }
            uploadInfo = SharedPreferencesUtil.getUploadInfo(this.context.get(), SHAREDPREFS_OSSUPLOAD, str);
            if (uploadInfo != null || !MD5.checkMD5(this.context.get(), uploadInfo.getMd5(), str)) {
                return false;
            }
            return SharedPreferencesUtil.clearUploadInfo(this.context.get(), SHAREDPREFS_OSSUPLOAD, str);
        }
        uploadInfo = SharedPreferencesUtil.getUploadInfo(this.context.get(), SHAREDPREFS_OSSUPLOAD, str);
        if (uploadInfo != null) {
        }
        return false;
        throw th;
    }
}

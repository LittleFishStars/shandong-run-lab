package com.alibaba.sdk.android.vod.upload;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth;
import com.alibaba.sdk.android.vod.upload.common.RequestIDSession;
import com.alibaba.sdk.android.vod.upload.common.UploadStateType;
import com.alibaba.sdk.android.vod.upload.common.utils.MD5;
import com.alibaba.sdk.android.vod.upload.common.utils.SharedPreferencesUtil;
import com.alibaba.sdk.android.vod.upload.common.utils.StringUtil;
import com.alibaba.sdk.android.vod.upload.common.utils.VideoInfoUtil;
import com.alibaba.sdk.android.vod.upload.exception.VODClientException;
import com.alibaba.sdk.android.vod.upload.exception.VODErrorCode;
import com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl;
import com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener;
import com.alibaba.sdk.android.vod.upload.internal.OSSUploader;
import com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl;
import com.alibaba.sdk.android.vod.upload.internal.ResumeableSession;
import com.alibaba.sdk.android.vod.upload.model.OSSConfig;
import com.alibaba.sdk.android.vod.upload.model.OSSUploadInfo;
import com.alibaba.sdk.android.vod.upload.model.SVideoConfig;
import com.alibaba.sdk.android.vod.upload.model.UploadFileInfo;
import com.alibaba.sdk.android.vod.upload.model.UserData;
import com.alibaba.sdk.android.vod.upload.model.VodInfo;
import com.alibaba.sdk.android.vod.upload.session.VodSessionCreateInfo;
import com.aliyun.auth.common.AliyunVodUploadType;
import com.aliyun.auth.core.AliyunVodErrorCode;
import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.auth.model.CreateImageForm;
import com.aliyun.auth.model.CreateVideoForm;
import com.aliyun.vod.common.httpfinal.QupaiHttpFinal;
import com.aliyun.vod.jasonparse.JSONSupport;
import com.aliyun.vod.jasonparse.JSONSupportImpl;
import com.aliyun.vod.log.core.AliyunLogger;
import com.aliyun.vod.log.core.AliyunLoggerManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VODSVideoUploadClientImpl implements VODSVideoUploadClient {
    private static final String TAG = "VOD_UPLOAD";
    private static final int VOD_GENERATE_IMAGE = 1;
    private static final int VOD_GENERATE_VIDEO = 1;
    private AliyunVodAuth aliyunVodAuth;
    private ClientConfiguration configuration;
    private WeakReference<Context> context;
    private String domainRegion;
    private List<UploadFileInfo> fileList;
    private long imageSize;
    private JSONSupport jsonSupport;
    private OSSConfig ossConfig;
    private boolean reportEnabled = true;
    private RequestIDSession requestIDSession;
    private ResumeableSession resumeableSession;
    private SVideoConfig sVideoConfig;
    private AliyunVodUploadStatus status;
    private AliyunVodUploadStep step;
    private String uploadAddress;
    private String uploadAuth;
    private OSSUploader uploader;
    private long videoSize;
    private VODSVideoUploadCallback videoUploadCallback;

    public class AliyunAuthCallback implements AliyunVodAuth.VodAuthCallBack {
        public AliyunAuthCallback() {
        }

        @Override // com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.VodAuthCallBack
        public void onCreateUploadImaged(CreateImageForm createImageForm) {
            OSSLog.logDebug(VODSVideoUploadClientImpl.TAG, "[VODSVideoUploader]: stepVODSVideoStepCreateImageFinish");
            VODSVideoUploadClientImpl.this.step = AliyunVodUploadStep.VODSVideoStepCreateImageFinish;
            SVideoConfig sVideoConfig = VODSVideoUploadClientImpl.this.sVideoConfig;
            VODSVideoUploadClientImpl vODSVideoUploadClientImpl = VODSVideoUploadClientImpl.this;
            sVideoConfig.setVodInfo(vODSVideoUploadClientImpl.generateVodInfo(1, vODSVideoUploadClientImpl.sVideoConfig, createImageForm.getImageURL()));
            VODSVideoUploadClientImpl.this.uploadAuth = createImageForm.getUploadAuth();
            VODSVideoUploadClientImpl.this.uploadAddress = createImageForm.getUploadAddress();
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode(VODSVideoUploadClientImpl.this.uploadAuth, 0)));
                String strOptString = jSONObject.optString("Region");
                String strOptString2 = jSONObject.optString("ExpireUTCTime");
                OSSLog.logDebug(VODSVideoUploadClientImpl.TAG, "region : " + strOptString + ", expUTC : " + strOptString2);
                if (!TextUtils.isEmpty(strOptString2)) {
                    VODSVideoUploadClientImpl.this.sVideoConfig.setExpriedTime(strOptString2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            VODSVideoUploadClientImpl vODSVideoUploadClientImpl2 = VODSVideoUploadClientImpl.this;
            vODSVideoUploadClientImpl2.startUpload(vODSVideoUploadClientImpl2.uploadAuth, VODSVideoUploadClientImpl.this.uploadAddress, VODSVideoUploadClientImpl.this.sVideoConfig);
        }

        @Override // com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.VodAuthCallBack
        public void onCreateUploadVideoed(CreateVideoForm createVideoForm, String str) {
            OSSLog.logDebug(VODSVideoUploadClientImpl.TAG, "VODSVideoStepCreateVideoFinish");
            VODSVideoUploadClientImpl.this.step = AliyunVodUploadStep.VODSVideoStepCreateVideoFinish;
            OSSLog.logDebug(VODSVideoUploadClientImpl.TAG, "[VODSVideoUploader]: step" + VODSVideoUploadClientImpl.this.step);
            SVideoConfig sVideoConfig = VODSVideoUploadClientImpl.this.sVideoConfig;
            VODSVideoUploadClientImpl vODSVideoUploadClientImpl = VODSVideoUploadClientImpl.this;
            sVideoConfig.setVodInfo(vODSVideoUploadClientImpl.generateVodInfo(1, vODSVideoUploadClientImpl.sVideoConfig, str));
            VODSVideoUploadClientImpl.this.sVideoConfig.setVideoId(createVideoForm.getVideoId());
            VODSVideoUploadClientImpl.this.uploadAuth = createVideoForm.getUploadAuth();
            VODSVideoUploadClientImpl.this.uploadAddress = createVideoForm.getUploadAddress();
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode(VODSVideoUploadClientImpl.this.uploadAuth, 0)));
                String strOptString = jSONObject.optString("Region");
                String strOptString2 = jSONObject.optString("ExpireUTCTime");
                OSSLog.logDebug(VODSVideoUploadClientImpl.TAG, "region : " + strOptString + ", expUTC : " + strOptString2);
                if (!TextUtils.isEmpty(strOptString)) {
                    if (VODSVideoUploadClientImpl.this.aliyunVodAuth == null && VODSVideoUploadClientImpl.this.aliyunVodAuth == null) {
                        VODSVideoUploadClientImpl vODSVideoUploadClientImpl2 = VODSVideoUploadClientImpl.this;
                        vODSVideoUploadClientImpl2.aliyunVodAuth = new AliyunVodAuth(vODSVideoUploadClientImpl2.new AliyunAuthCallback());
                    }
                    VODSVideoUploadClientImpl.this.aliyunVodAuth.setDomainRegion(VODSVideoUploadClientImpl.this.domainRegion);
                    VODSVideoUploadClientImpl.this.domainRegion = strOptString;
                }
                if (!TextUtils.isEmpty(strOptString2)) {
                    VODSVideoUploadClientImpl.this.sVideoConfig.setExpriedTime(strOptString2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            VODSVideoUploadClientImpl vODSVideoUploadClientImpl3 = VODSVideoUploadClientImpl.this;
            vODSVideoUploadClientImpl3.startUpload(vODSVideoUploadClientImpl3.uploadAuth, VODSVideoUploadClientImpl.this.uploadAddress, VODSVideoUploadClientImpl.this.sVideoConfig);
        }

        @Override // com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.VodAuthCallBack
        public void onError(String str, String str2) {
            String videoPath;
            OSSLog.logDebug(VODSVideoUploadClientImpl.TAG, "[VODSVideoUploader]: onCreateAuthErrorcode" + str + "message" + str2);
            if (AliyunVodErrorCode.VODERRORCODE_INVALIDVIDEO.equals(str) && VODSVideoUploadClientImpl.this.resumeableSession != null) {
                if (VODSVideoUploadClientImpl.this.step == AliyunVodUploadStep.VODSVideoStepCreateImage) {
                    videoPath = VODSVideoUploadClientImpl.this.sVideoConfig.getImagePath();
                } else {
                    videoPath = VODSVideoUploadClientImpl.this.step == AliyunVodUploadStep.VODSVideoStepCreateVideo ? VODSVideoUploadClientImpl.this.sVideoConfig.getVideoPath() : null;
                }
                VODSVideoUploadClientImpl.this.resumeableSession.deleteResumeableFileInfo(videoPath);
                if (VODSVideoUploadClientImpl.this.step == AliyunVodUploadStep.VODSVideoStepCreateVideo) {
                    VODSVideoUploadClientImpl.this.refreshSTStoken();
                    return;
                }
            }
            if (VODSVideoUploadClientImpl.this.videoUploadCallback != null) {
                VODSVideoUploadClientImpl.this.videoUploadCallback.onUploadFailed(str, str2);
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.VodAuthCallBack
        public void onSTSExpired(AliyunVodUploadType aliyunVodUploadType) {
            OSSLog.logDebug(VODSVideoUploadClientImpl.TAG, "[VODSVideoUploader]: statusonSTSExpired");
            if (VODSVideoUploadClientImpl.this.videoUploadCallback != null) {
                VODSVideoUploadClientImpl.this.videoUploadCallback.onSTSTokenExpried();
            }
        }
    }

    public enum AliyunVodUploadStatus {
        VODSVideoStatusIdle,
        VODSVideoStatusResume,
        VODSVideoStatusPause,
        VODSVideoStatusCancel,
        VODSVideoStatusRelease
    }

    public enum AliyunVodUploadStep {
        VODSVideoStepIdle,
        VODSVideoStepCreateImage,
        VODSVideoStepCreateImageFinish,
        VODSVideoStepUploadImage,
        VODSVideoStepUploadImageFinish,
        VODSVideoStepCreateVideo,
        VODSVideoStepCreateVideoFinish,
        VODSVideoStepUploadVideo,
        VODSVideoStepFinish
    }

    public class OSSUploadCallback implements OSSUploadListener {
        public OSSUploadCallback() {
        }

        @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener
        public void onUploadFailed(String str, String str2) {
            OSSLog.logDebug(VODSVideoUploadClientImpl.TAG, "[OSSUploader]:code:" + str + "message" + str2);
            if (VODSVideoUploadClientImpl.this.videoUploadCallback != null) {
                VODSVideoUploadClientImpl.this.videoUploadCallback.onUploadFailed(str, str2);
                VODSVideoUploadClientImpl.this.cancel();
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener
        public void onUploadProgress(Object obj, long j, long j2) {
            OSSLog.logDebug(VODSVideoUploadClientImpl.TAG, "[OSSUploader]:uploadedSize" + j + "totalSize" + j2);
            if (VODSVideoUploadClientImpl.this.videoUploadCallback != null) {
                if (VODSVideoUploadClientImpl.this.step == AliyunVodUploadStep.VODSVideoStepUploadImage) {
                    VODSVideoUploadClientImpl.this.videoUploadCallback.onUploadProgress(j, j2 + VODSVideoUploadClientImpl.this.videoSize);
                } else if (VODSVideoUploadClientImpl.this.step == AliyunVodUploadStep.VODSVideoStepUploadVideo) {
                    VODSVideoUploadClientImpl.this.videoUploadCallback.onUploadProgress(j + VODSVideoUploadClientImpl.this.imageSize, j2 + VODSVideoUploadClientImpl.this.imageSize);
                }
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener
        public void onUploadRetry(String str, String str2) {
            OSSLog.logDebug(VODSVideoUploadClientImpl.TAG, "[OSSUploader]:onUploadRetry");
            if (VODSVideoUploadClientImpl.this.videoUploadCallback != null) {
                VODSVideoUploadClientImpl.this.videoUploadCallback.onUploadRetry(str, str2);
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener
        public void onUploadRetryResume() {
            if (VODSVideoUploadClientImpl.this.videoUploadCallback != null) {
                VODSVideoUploadClientImpl.this.videoUploadCallback.onUploadRetryResume();
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener
        public void onUploadSucceed() {
            if (VODSVideoUploadClientImpl.this.step == AliyunVodUploadStep.VODSVideoStepUploadVideo) {
                OSSLog.logDebug(VODSVideoUploadClientImpl.TAG, "[VODSVideoUploader]: stepVODSVideoStepUploadVideoFinish");
                if (VODSVideoUploadClientImpl.this.resumeableSession != null && VODSVideoUploadClientImpl.this.sVideoConfig != null) {
                    VODSVideoUploadClientImpl.this.resumeableSession.deleteResumeableFileInfo(VODSVideoUploadClientImpl.this.sVideoConfig.getVideoPath());
                }
                if (VODSVideoUploadClientImpl.this.videoUploadCallback != null && VODSVideoUploadClientImpl.this.sVideoConfig != null && VODSVideoUploadClientImpl.this.sVideoConfig.getVodInfo() != null) {
                    VODSVideoUploadClientImpl.this.videoUploadCallback.onUploadSucceed(VODSVideoUploadClientImpl.this.sVideoConfig.getVideoId(), VODSVideoUploadClientImpl.this.sVideoConfig.getVodInfo().getCoverUrl());
                }
                VODSVideoUploadClientImpl.this.step = AliyunVodUploadStep.VODSVideoStepFinish;
                return;
            }
            if (VODSVideoUploadClientImpl.this.step == AliyunVodUploadStep.VODSVideoStepUploadImage) {
                VODSVideoUploadClientImpl.this.step = AliyunVodUploadStep.VODSVideoStepUploadImageFinish;
                if (VODSVideoUploadClientImpl.this.resumeableSession != null && VODSVideoUploadClientImpl.this.sVideoConfig != null) {
                    VODSVideoUploadClientImpl.this.resumeableSession.deleteResumeableFileInfo(VODSVideoUploadClientImpl.this.sVideoConfig.getImagePath());
                }
                OSSLog.logDebug(VODSVideoUploadClientImpl.TAG, "[VODSVideoUploader]: stepVODSVideoStepUploadImageFinish");
                String resumeableFileVideoID = VODSVideoUploadClientImpl.this.resumeableSession.getResumeableFileVideoID(VODSVideoUploadClientImpl.this.sVideoConfig.getVideoPath());
                if (TextUtils.isEmpty(resumeableFileVideoID)) {
                    VODSVideoUploadClientImpl.this.aliyunVodAuth.createUploadVideo(VODSVideoUploadClientImpl.this.sVideoConfig.getAccessKeyId(), VODSVideoUploadClientImpl.this.sVideoConfig.getAccessKeySecret(), VODSVideoUploadClientImpl.this.sVideoConfig.getSecrityToken(), VODSVideoUploadClientImpl.this.sVideoConfig.getVodInfo(), VODSVideoUploadClientImpl.this.sVideoConfig.isTranscode(), VODSVideoUploadClientImpl.this.sVideoConfig.getTemplateGroupId(), VODSVideoUploadClientImpl.this.sVideoConfig.getStorageLocation(), VODSVideoUploadClientImpl.this.sVideoConfig.getWorkFlowId(), VODSVideoUploadClientImpl.this.sVideoConfig.getAppId(), VODSVideoUploadClientImpl.this.sVideoConfig.getRequestId() == null ? VODSVideoUploadClientImpl.this.requestIDSession.getRequestID() : VODSVideoUploadClientImpl.this.sVideoConfig.getRequestId());
                } else {
                    VODSVideoUploadClientImpl.this.aliyunVodAuth.refreshUploadVideo(VODSVideoUploadClientImpl.this.sVideoConfig.getAccessKeyId(), VODSVideoUploadClientImpl.this.sVideoConfig.getAccessKeySecret(), VODSVideoUploadClientImpl.this.sVideoConfig.getSecrityToken(), resumeableFileVideoID, VODSVideoUploadClientImpl.this.sVideoConfig.getVodInfo().getCoverUrl(), VODSVideoUploadClientImpl.this.requestIDSession.getRequestID());
                }
                VODSVideoUploadClientImpl.this.step = AliyunVodUploadStep.VODSVideoStepCreateVideo;
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener
        public void onUploadTokenExpired() {
            OSSLog.logDebug(VODSVideoUploadClientImpl.TAG, "[OSSUploader]:onUploadTokenExpired");
            if (VODSVideoUploadClientImpl.this.videoUploadCallback != null) {
                VODSVideoUploadClientImpl.this.videoUploadCallback.onSTSTokenExpried();
            }
        }
    }

    public VODSVideoUploadClientImpl(Context context) {
        this.context = new WeakReference<>(context);
        QupaiHttpFinal.getInstance().initOkHttpFinal();
        this.fileList = Collections.synchronizedList(new ArrayList());
        this.ossConfig = new OSSConfig();
        this.resumeableSession = new ResumeableSession(context.getApplicationContext());
        this.requestIDSession = new RequestIDSession();
        this.sVideoConfig = new SVideoConfig();
        AliyunLoggerManager.createLogger(context.getApplicationContext(), VODUploadClientImpl.class.getName());
    }

    private void addFile(VodInfo vodInfo) {
        UploadFileInfo uploadFileInfo = new UploadFileInfo();
        uploadFileInfo.setFilePath(this.sVideoConfig.getImagePath());
        uploadFileInfo.setFileType(0);
        uploadFileInfo.setVodInfo(vodInfo);
        UploadStateType uploadStateType = UploadStateType.INIT;
        uploadFileInfo.setStatus(uploadStateType);
        this.fileList.add(uploadFileInfo);
        UploadFileInfo uploadFileInfo2 = new UploadFileInfo();
        uploadFileInfo2.setFilePath(this.sVideoConfig.getVideoPath());
        uploadFileInfo.setFileType(1);
        uploadFileInfo2.setVodInfo(vodInfo);
        uploadFileInfo2.setStatus(uploadStateType);
        this.fileList.add(uploadFileInfo2);
    }

    private void createUploadImage() {
        AliyunVodAuth aliyunVodAuth;
        if (this.sVideoConfig.getAccessKeyId() == null || this.sVideoConfig.getAccessKeySecret() == null || this.sVideoConfig.getSecrityToken() == null || (aliyunVodAuth = this.aliyunVodAuth) == null) {
            return;
        }
        this.step = AliyunVodUploadStep.VODSVideoStepCreateImage;
        aliyunVodAuth.createUploadImage(this.sVideoConfig.getAccessKeyId(), this.sVideoConfig.getAccessKeySecret(), this.sVideoConfig.getSecrityToken(), this.sVideoConfig.getVodInfo(), this.sVideoConfig.getStorageLocation(), this.sVideoConfig.getAppId(), this.sVideoConfig.getRequestId() == null ? this.requestIDSession.getRequestID() : this.sVideoConfig.getRequestId(), true);
        OSSLog.logDebug(TAG, "VODSVideoStepCreateImage");
        OSSLog.logDebug(TAG, "[VODSVideoUploader] - status:  VODSVideoStepCreateImage");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VodInfo generateVodInfo(int i, SVideoConfig sVideoConfig, String str) throws Throwable {
        VodInfo vodInfo = new VodInfo();
        vodInfo.setTitle(sVideoConfig.getVodInfo().getTitle());
        vodInfo.setDesc(sVideoConfig.getVodInfo().getDesc());
        if (i == 1) {
            vodInfo.setFileName(new File(sVideoConfig.getVideoPath()).getName());
            try {
                UserData videoBitrate = VideoInfoUtil.getVideoBitrate(this.context.get(), sVideoConfig.getVideoPath());
                String userData = sVideoConfig.getUserData();
                String strWriteValue = this.jsonSupport.writeValue(videoBitrate);
                OSSLog.logDebug("[VODSVideoUploadClientImpl] - userdata-custom : " + userData);
                OSSLog.logDebug("[VODSVideoUploadClientImpl] - userdata-video : " + strWriteValue);
                if (!TextUtils.isEmpty(strWriteValue)) {
                    vodInfo.setUserData(strWriteValue);
                }
                if (!TextUtils.isEmpty(userData)) {
                    vodInfo.setUserData(userData);
                }
                if (!TextUtils.isEmpty(strWriteValue) && !TextUtils.isEmpty(userData)) {
                    JSONObject jSONObject = new JSONObject(strWriteValue);
                    JSONObject jSONObject2 = new JSONObject(userData);
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        Iterator<String> itKeys = jSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            jSONObject3.put(next, jSONObject.get(next));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    try {
                        Iterator<String> itKeys2 = jSONObject2.keys();
                        while (itKeys2.hasNext()) {
                            String next2 = itKeys2.next();
                            jSONObject3.put(next2, jSONObject2.get(next2));
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    OSSLog.logDebug("[VODSVideoUploadClientImpl] - userdata : " + jSONObject3.toString());
                    vodInfo.setUserData(jSONObject3.toString());
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                vodInfo.setUserData(null);
            }
            vodInfo.setFileSize(String.valueOf(new File(sVideoConfig.getVideoPath()).length()));
            vodInfo.setIsProcess(sVideoConfig.getVodInfo().getIsProcess());
            vodInfo.setPriority(sVideoConfig.getVodInfo().getPriority());
            vodInfo.setIsShowWaterMark(sVideoConfig.getVodInfo().getIsShowWaterMark());
        } else {
            vodInfo.setFileName(new File(sVideoConfig.getImagePath()).getName());
        }
        vodInfo.setCateId(sVideoConfig.getVodInfo().getCateId());
        if (str != null) {
            vodInfo.setCoverUrl(str);
        }
        vodInfo.setTags(sVideoConfig.getVodInfo().getTags());
        return vodInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshSTStoken() {
        OSSLog.logDebug(TAG, "[VODSVideoUploader]:  RefreshSTStoken");
        AliyunVodUploadStatus aliyunVodUploadStatus = this.status;
        if (aliyunVodUploadStatus == AliyunVodUploadStatus.VODSVideoStatusPause || aliyunVodUploadStatus == AliyunVodUploadStatus.VODSVideoStatusCancel) {
            OSSLog.logDebug(TAG, "[VODSVideoUploader] - status: " + this.status + " cann't be refreshSTStoken!");
            return;
        }
        AliyunVodUploadStep aliyunVodUploadStep = this.step;
        if (aliyunVodUploadStep == AliyunVodUploadStep.VODSVideoStepUploadVideo || aliyunVodUploadStep == AliyunVodUploadStep.VODSVideoStepUploadImage) {
            OSSUploader oSSUploader = this.uploader;
            if (oSSUploader != null) {
                oSSUploader.resume();
                return;
            }
            return;
        }
        if (aliyunVodUploadStep == AliyunVodUploadStep.VODSVideoStepCreateImage) {
            this.aliyunVodAuth.createUploadImage(this.sVideoConfig.getAccessKeyId(), this.sVideoConfig.getAccessKeySecret(), this.sVideoConfig.getSecrityToken(), this.sVideoConfig.getVodInfo(), this.sVideoConfig.getStorageLocation(), this.sVideoConfig.getAppId(), this.sVideoConfig.getRequestId() == null ? this.requestIDSession.getRequestID() : this.sVideoConfig.getRequestId(), true);
            return;
        }
        if (aliyunVodUploadStep == AliyunVodUploadStep.VODSVideoStepCreateVideoFinish) {
            this.aliyunVodAuth.refreshUploadVideo(this.sVideoConfig.getAccessKeyId(), this.sVideoConfig.getAccessKeySecret(), this.sVideoConfig.getSecrityToken(), this.sVideoConfig.getVideoId(), this.sVideoConfig.getVodInfo().getCoverUrl(), this.sVideoConfig.getRequestId() == null ? this.requestIDSession.getRequestID() : this.sVideoConfig.getRequestId());
            return;
        }
        if (aliyunVodUploadStep == AliyunVodUploadStep.VODSVideoStepCreateVideo) {
            String resumeableFileVideoID = this.resumeableSession.getResumeableFileVideoID(this.sVideoConfig.getVideoPath());
            if (TextUtils.isEmpty(resumeableFileVideoID)) {
                this.aliyunVodAuth.createUploadVideo(this.sVideoConfig.getAccessKeyId(), this.sVideoConfig.getAccessKeySecret(), this.sVideoConfig.getSecrityToken(), this.sVideoConfig.getVodInfo(), this.sVideoConfig.isTranscode(), this.sVideoConfig.getTemplateGroupId(), this.sVideoConfig.getStorageLocation(), this.sVideoConfig.getWorkFlowId(), this.sVideoConfig.getAppId(), this.sVideoConfig.getRequestId() == null ? this.requestIDSession.getRequestID() : this.sVideoConfig.getRequestId());
            } else {
                this.aliyunVodAuth.refreshUploadVideo(this.sVideoConfig.getAccessKeyId(), this.sVideoConfig.getAccessKeySecret(), this.sVideoConfig.getSecrityToken(), resumeableFileVideoID, this.sVideoConfig.getVodInfo().getCoverUrl(), this.requestIDSession.getRequestID());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUpload(String str, String str2, SVideoConfig sVideoConfig) {
        try {
            AliyunVodUploadStep aliyunVodUploadStep = this.step;
            if (aliyunVodUploadStep == AliyunVodUploadStep.VODSVideoStepCreateImageFinish) {
                OSSLog.logDebug(TAG, "[VODSVIDEOUploader]:step:" + this.step);
                this.step = AliyunVodUploadStep.VODSVideoStepUploadImage;
            } else if (aliyunVodUploadStep == AliyunVodUploadStep.VODSVideoStepCreateVideoFinish) {
                OSSLog.logDebug(TAG, "[VODSVIDEOUploader]:step:" + this.step);
                this.step = AliyunVodUploadStep.VODSVideoStepUploadVideo;
            }
            UploadFileInfo uploadFileInfo = new UploadFileInfo();
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode(str, 0)));
                this.ossConfig.setAccessKeyId(jSONObject.optString(AliyunVodKey.KEY_VOD_COMMON_ACCESSKEYID));
                this.ossConfig.setAccessKeySecret(jSONObject.optString("AccessKeySecret"));
                this.ossConfig.setSecrityToken(jSONObject.optString(AliyunVodKey.KEY_VOD_COMMON_SECURITY_TOKEN));
                this.ossConfig.setExpireTime(jSONObject.optString("Expiration"));
                String strOptString = jSONObject.optString("ExpireUTCTime");
                if (!TextUtils.isEmpty(strOptString)) {
                    this.ossConfig.setExpireTime(strOptString);
                }
                AliyunVodUploadStep aliyunVodUploadStep2 = this.step;
                AliyunVodUploadStep aliyunVodUploadStep3 = AliyunVodUploadStep.VODSVideoStepUploadVideo;
                if (aliyunVodUploadStep2 == aliyunVodUploadStep3) {
                    this.ossConfig.setVideoId(sVideoConfig.getVideoId());
                }
                this.ossConfig.setUploadAddress(str2);
                JSONObject jSONObject2 = new JSONObject(new String(Base64.decode(str2, 0)));
                uploadFileInfo.setEndpoint(jSONObject2.optString("Endpoint"));
                uploadFileInfo.setBucket(jSONObject2.optString("Bucket"));
                uploadFileInfo.setObject(jSONObject2.optString(AliyunVodKey.KEY_VOD_FILENAME));
                AliyunVodUploadStep aliyunVodUploadStep4 = this.step;
                if (aliyunVodUploadStep4 == AliyunVodUploadStep.VODSVideoStepUploadImage) {
                    uploadFileInfo.setFilePath(sVideoConfig.getImagePath());
                    uploadFileInfo.setFileType(0);
                } else if (aliyunVodUploadStep4 == aliyunVodUploadStep3) {
                    uploadFileInfo.setFilePath(sVideoConfig.getVideoPath());
                    uploadFileInfo.setFileType(1);
                }
                uploadFileInfo.setVodInfo(sVideoConfig.getVodInfo());
                uploadFileInfo.setStatus(UploadStateType.INIT);
                OSSUploadInfo uploadInfo = SharedPreferencesUtil.getUploadInfo(this.context.get(), ResumeableSession.SHAREDPREFS_OSSUPLOAD, uploadFileInfo.getFilePath());
                if (uploadInfo == null || !MD5.checkMD5(this.context.get(), uploadInfo.getMd5(), uploadFileInfo.getFilePath())) {
                    this.resumeableSession.saveResumeableFileInfo(uploadFileInfo, sVideoConfig.getVideoId());
                } else {
                    uploadFileInfo = this.resumeableSession.getResumeableFileInfo(uploadFileInfo, sVideoConfig.getVideoId());
                }
                startUpload(uploadFileInfo);
            } catch (JSONException unused) {
                throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"uploadAuth\" format is error");
            }
        } catch (JSONException unused2) {
            throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"uploadAddress\" format is error");
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadClient
    public void cancel() {
        OSSLog.logDebug(TAG, "[VODSVideoUploader]: cancel");
        this.status = AliyunVodUploadStatus.VODSVideoStatusIdle;
        this.step = AliyunVodUploadStep.VODSVideoStepIdle;
        OSSUploader oSSUploader = this.uploader;
        if (oSSUploader != null) {
            oSSUploader.cancel();
            this.fileList.clear();
            this.videoUploadCallback = null;
        }
        AliyunVodAuth aliyunVodAuth = this.aliyunVodAuth;
        if (aliyunVodAuth != null) {
            aliyunVodAuth.cancel();
            this.aliyunVodAuth = null;
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadClient
    public void init() {
        this.jsonSupport = new JSONSupportImpl();
        this.step = AliyunVodUploadStep.VODSVideoStepIdle;
        this.status = AliyunVodUploadStatus.VODSVideoStatusIdle;
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadClient
    public void pause() {
        OSSLog.logDebug(TAG, "[VODSVideoUploader]:  pause");
        AliyunVodUploadStatus aliyunVodUploadStatus = this.status;
        if (aliyunVodUploadStatus == AliyunVodUploadStatus.VODSVideoStatusIdle || aliyunVodUploadStatus == AliyunVodUploadStatus.VODSVideoStatusResume) {
            OSSUploader oSSUploader = this.uploader;
            if (oSSUploader != null) {
                oSSUploader.pause();
            }
            this.status = AliyunVodUploadStatus.VODSVideoStatusPause;
            return;
        }
        OSSLog.logDebug("[VODSVideoUploadClientImpl] - status: " + this.status + " cann't be pause!");
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadClient
    public void refreshSTSToken(String str, String str2, String str3, String str4) {
        if (StringUtil.isEmpty(str)) {
            throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"accessKeyId\" cannot be null");
        }
        if (StringUtil.isEmpty(str2)) {
            throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"accessKeySecret\" cannot be null");
        }
        if (StringUtil.isEmpty(str3)) {
            throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"accessToken\" cannot be null");
        }
        if (StringUtil.isEmpty(str4)) {
            throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"expriedTime\" cannot be null");
        }
        this.sVideoConfig.setAccessKeyId(str);
        this.sVideoConfig.setAccessKeySecret(str2);
        this.sVideoConfig.setSecrityToken(str3);
        this.sVideoConfig.setExpriedTime(str4);
        this.ossConfig.setAccessKeyId(this.sVideoConfig.getAccessKeyId());
        this.ossConfig.setAccessKeySecret(this.sVideoConfig.getAccessKeySecret());
        this.ossConfig.setSecrityToken(this.sVideoConfig.getSecrityToken());
        this.ossConfig.setExpireTime(this.sVideoConfig.getExpriedTime());
        refreshSTStoken();
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadClient
    public void release() {
        if (this.sVideoConfig != null) {
            this.sVideoConfig = null;
        }
        if (this.aliyunVodAuth != null) {
            this.aliyunVodAuth = null;
        }
        if (this.uploader != null) {
            this.uploader = null;
        }
        if (this.videoUploadCallback != null) {
            this.videoUploadCallback = null;
        }
        this.status = AliyunVodUploadStatus.VODSVideoStatusRelease;
        this.step = AliyunVodUploadStep.VODSVideoStepIdle;
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadClient
    public void resume() {
        OSSUploader oSSUploader;
        OSSLog.logDebug(TAG, "[VODSVideoUploader]:  resume");
        AliyunVodUploadStatus aliyunVodUploadStatus = AliyunVodUploadStatus.VODSVideoStatusPause;
        AliyunVodUploadStatus aliyunVodUploadStatus2 = this.status;
        if (aliyunVodUploadStatus != aliyunVodUploadStatus2 && AliyunVodUploadStatus.VODSVideoStatusIdle != aliyunVodUploadStatus2) {
            OSSLog.logDebug("[VODSVideoUploadClientImpl] - status: " + this.status + " cann't be resume!");
            return;
        }
        if (aliyunVodUploadStatus2 == aliyunVodUploadStatus) {
            AliyunVodUploadStep aliyunVodUploadStep = this.step;
            if (aliyunVodUploadStep == AliyunVodUploadStep.VODSVideoStepIdle || aliyunVodUploadStep == AliyunVodUploadStep.VODSVideoStepCreateImage || aliyunVodUploadStep == AliyunVodUploadStep.VODSVideoStepCreateImageFinish || aliyunVodUploadStep == AliyunVodUploadStep.VODSVideoStepCreateVideo) {
                createUploadImage();
            } else if (aliyunVodUploadStep != AliyunVodUploadStep.VODSVideoStepFinish && (oSSUploader = this.uploader) != null) {
                oSSUploader.resume();
            }
            this.status = AliyunVodUploadStatus.VODSVideoStatusResume;
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadClient
    public void setAppVersion(String str) {
        AliyunLogger logger = AliyunLoggerManager.getLogger(VODUploadClientImpl.class.getName());
        if (logger != null) {
            logger.setAppVersion(str);
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadClient
    public void setRecordUploadProgressEnabled(boolean z) {
        ResumeableSession resumeableSession = this.resumeableSession;
        if (resumeableSession != null) {
            resumeableSession.setEnabled(z);
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadClient
    public void setRegion(String str) {
        this.domainRegion = str;
    }

    public void setReportEnabled(boolean z) {
        this.reportEnabled = z;
        AliyunLoggerManager.toggleLogger(z);
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadClient
    public void uploadWithVideoAndImg(VodSessionCreateInfo vodSessionCreateInfo, VODSVideoUploadCallback vODSVideoUploadCallback) {
        if (StringUtil.isEmpty(vodSessionCreateInfo.getAccessKeyId())) {
            throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"accessKeyId\" cannot be null");
        }
        if (StringUtil.isEmpty(vodSessionCreateInfo.getAccessKeySecret())) {
            throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"accessKeySecret\" cannot be null");
        }
        if (StringUtil.isEmpty(vodSessionCreateInfo.getSecurityToken())) {
            throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"securityToken\" cannot be null");
        }
        if (StringUtil.isEmpty(vodSessionCreateInfo.getExpriedTime())) {
            throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"expriedTime\" cannot be null");
        }
        if (!new File(vodSessionCreateInfo.getVideoPath()).exists()) {
            throw new VODClientException(VODErrorCode.FILE_NOT_EXIST, "The specified parameter \"videoPath\" file not exists");
        }
        if (!new File(vodSessionCreateInfo.getImagePath()).exists()) {
            throw new VODClientException(VODErrorCode.FILE_NOT_EXIST, "The specified parameter \"imagePath\" file not exists");
        }
        if (vODSVideoUploadCallback == null) {
            throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"callback\" cannot be null");
        }
        this.videoUploadCallback = vODSVideoUploadCallback;
        if (this.aliyunVodAuth == null) {
            this.aliyunVodAuth = new AliyunVodAuth(new AliyunAuthCallback());
        }
        this.aliyunVodAuth.setDomainRegion(this.domainRegion);
        AliyunVodUploadStatus aliyunVodUploadStatus = AliyunVodUploadStatus.VODSVideoStatusPause;
        AliyunVodUploadStatus aliyunVodUploadStatus2 = this.status;
        if (aliyunVodUploadStatus == aliyunVodUploadStatus2 || AliyunVodUploadStatus.VODSVideoStatusRelease == aliyunVodUploadStatus2) {
            OSSLog.logDebug("[VODSVideoUploadClientImpl] - status: " + this.status + " cann't be start upload!");
            return;
        }
        AliyunLogger logger = AliyunLoggerManager.getLogger(VODUploadClientImpl.class.getName());
        if (logger != null) {
            logger.setRequestID(vodSessionCreateInfo.getRequestID(), false);
            logger.setProductSVideo(true);
        }
        this.sVideoConfig.setAccessKeyId(vodSessionCreateInfo.getAccessKeyId());
        this.sVideoConfig.setAccessKeySecret(vodSessionCreateInfo.getAccessKeySecret());
        this.sVideoConfig.setSecrityToken(vodSessionCreateInfo.getSecurityToken());
        this.sVideoConfig.setExpriedTime(vodSessionCreateInfo.getExpriedTime());
        this.sVideoConfig.setVideoPath(vodSessionCreateInfo.getVideoPath());
        this.sVideoConfig.setImagePath(vodSessionCreateInfo.getImagePath());
        this.sVideoConfig.setTranscode(vodSessionCreateInfo.isTranscode());
        this.sVideoConfig.setPartSize(vodSessionCreateInfo.getPartSize());
        this.sVideoConfig.setRequestId(vodSessionCreateInfo.getRequestID());
        this.sVideoConfig.setTemplateGroupId(vodSessionCreateInfo.getTemplateGroupId());
        this.sVideoConfig.setStorageLocation(vodSessionCreateInfo.getStorageLocation());
        this.sVideoConfig.setWorkFlowId(vodSessionCreateInfo.getWorkFlowId());
        this.sVideoConfig.setAppId(vodSessionCreateInfo.getAppId());
        this.sVideoConfig.setUserData(vodSessionCreateInfo.getSvideoInfo().getUserData());
        this.imageSize = new File(vodSessionCreateInfo.getImagePath()).length();
        this.videoSize = new File(vodSessionCreateInfo.getVideoPath()).length();
        this.ossConfig.setAccessKeyId(this.sVideoConfig.getAccessKeyId());
        this.ossConfig.setAccessKeySecret(this.sVideoConfig.getAccessKeySecret());
        this.ossConfig.setSecrityToken(this.sVideoConfig.getSecrityToken());
        this.ossConfig.setExpireTime(this.sVideoConfig.getExpriedTime());
        this.ossConfig.setPartSize(this.sVideoConfig.getPartSize());
        VodInfo vodInfo = new VodInfo();
        vodInfo.setTitle(vodSessionCreateInfo.getSvideoInfo().getTitle());
        vodInfo.setDesc(vodSessionCreateInfo.getSvideoInfo().getDesc());
        vodInfo.setCateId(vodSessionCreateInfo.getSvideoInfo().getCateId());
        vodInfo.setTags(vodSessionCreateInfo.getSvideoInfo().getTags());
        vodInfo.setIsProcess(Boolean.valueOf(vodSessionCreateInfo.getSvideoInfo().isProcess()));
        vodInfo.setIsShowWaterMark(Boolean.valueOf(vodSessionCreateInfo.getSvideoInfo().isShowWaterMark()));
        vodInfo.setPriority(Integer.valueOf(vodSessionCreateInfo.getSvideoInfo().getPriority()));
        vodInfo.setUserData(vodSessionCreateInfo.getSvideoInfo().getUserData());
        this.sVideoConfig.setVodInfo(vodInfo);
        addFile(this.sVideoConfig.getVodInfo());
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        this.configuration = clientConfiguration;
        clientConfiguration.setMaxErrorRetry(vodSessionCreateInfo.getVodHttpClientConfig().getMaxRetryCount());
        this.configuration.setConnectionTimeout(vodSessionCreateInfo.getVodHttpClientConfig().getConnectionTimeout());
        this.configuration.setSocketTimeout(vodSessionCreateInfo.getVodHttpClientConfig().getSocketTimeout());
        createUploadImage();
    }

    private void startUpload(UploadFileInfo uploadFileInfo) {
        if (new File(uploadFileInfo.getFilePath()).length() < 102400) {
            this.uploader = null;
            OSSPutUploaderImpl oSSPutUploaderImpl = new OSSPutUploaderImpl(this.context.get());
            this.uploader = oSSPutUploaderImpl;
            oSSPutUploaderImpl.init(this.ossConfig, new OSSUploadCallback());
            this.uploader.setOSSClientConfiguration(this.configuration);
            try {
                this.uploader.start(uploadFileInfo);
                return;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                this.videoUploadCallback.onUploadFailed(VODErrorCode.FILE_NOT_EXIST, "The file \"" + uploadFileInfo.getFilePath() + "\" is not exist!");
                return;
            }
        }
        this.uploader = null;
        ResumableUploaderImpl resumableUploaderImpl = new ResumableUploaderImpl(this.context.get());
        this.uploader = resumableUploaderImpl;
        resumableUploaderImpl.setDomainRegion(this.domainRegion);
        this.uploader.init(this.ossConfig, new OSSUploadCallback());
        this.uploader.setOSSClientConfiguration(this.configuration);
        try {
            this.uploader.start(uploadFileInfo);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            this.videoUploadCallback.onUploadFailed(VODErrorCode.FILE_NOT_EXIST, "The file \"" + uploadFileInfo.getFilePath() + "\" is not exist!");
        }
    }
}

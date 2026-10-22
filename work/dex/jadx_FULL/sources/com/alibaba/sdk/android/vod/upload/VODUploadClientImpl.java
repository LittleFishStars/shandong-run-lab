package com.alibaba.sdk.android.vod.upload;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth;
import com.alibaba.sdk.android.vod.upload.common.RequestIDSession;
import com.alibaba.sdk.android.vod.upload.common.UploadStateType;
import com.alibaba.sdk.android.vod.upload.common.VodUploadStateType;
import com.alibaba.sdk.android.vod.upload.common.utils.MD5;
import com.alibaba.sdk.android.vod.upload.common.utils.SharedPreferencesUtil;
import com.alibaba.sdk.android.vod.upload.common.utils.StringUtil;
import com.alibaba.sdk.android.vod.upload.common.utils.VideoInfoUtil;
import com.alibaba.sdk.android.vod.upload.exception.VODClientException;
import com.alibaba.sdk.android.vod.upload.exception.VODErrorCode;
import com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl;
import com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener;
import com.alibaba.sdk.android.vod.upload.internal.OSSUploader;
import com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl;
import com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl;
import com.alibaba.sdk.android.vod.upload.internal.ResumeableSession;
import com.alibaba.sdk.android.vod.upload.model.FilePartInfo;
import com.alibaba.sdk.android.vod.upload.model.OSSConfig;
import com.alibaba.sdk.android.vod.upload.model.OSSUploadInfo;
import com.alibaba.sdk.android.vod.upload.model.UploadFileInfo;
import com.alibaba.sdk.android.vod.upload.model.UserData;
import com.alibaba.sdk.android.vod.upload.model.VodInfo;
import com.alibaba.sdk.android.vod.upload.model.VodUploadResult;
import com.alibaba.sdk.android.vod.upload.session.VodHttpClientConfig;
import com.aliyun.auth.common.AliyunVodHttpCommon;
import com.aliyun.auth.common.AliyunVodUploadType;
import com.aliyun.auth.core.AliyunVodErrorCode;
import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.auth.model.CreateImageForm;
import com.aliyun.auth.model.CreateVideoForm;
import com.aliyun.vod.common.httpfinal.QupaiHttpFinal;
import com.aliyun.vod.common.utils.FileUtils;
import com.aliyun.vod.common.utils.StringUtils;
import com.aliyun.vod.jasonparse.JSONSupport;
import com.aliyun.vod.jasonparse.JSONSupportImpl;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.aliyun.vod.log.core.AliyunLogger;
import com.aliyun.vod.log.core.AliyunLoggerManager;
import com.aliyun.vod.log.core.LogService;
import com.aliyun.vod.log.struct.AliyunLogKey;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VODUploadClientImpl implements OSSUploadListener, VODUploadClient {
    private AliyunVodAuth aliyunVodAuth;
    private String appId;
    private VODUploadCallback callback;
    private ClientConfiguration configuration;
    private WeakReference<Context> context;
    private UploadFileInfo curFileInfo;
    private List<UploadFileInfo> fileList;
    private JSONSupport jsonSupport;
    private OSSConfig ossConfig;
    private RequestIDSession requestIDSession;
    private VodUploadResult resultInfo;
    private ResumeableSession resumeableSession;
    private VodUploadStateType status;
    private String storageLocation;
    private String templateGroupId;
    private OSSUploader upload;
    private String workflowId;
    private boolean isTranscode = true;
    private boolean recordUploadProgressEnabled = true;
    private String domainRegion = null;
    private boolean mDisableMultiPart = false;
    private boolean isVODAuthMode = false;
    private boolean reportEnabled = true;
    private Handler mMainHandler = new Handler(Looper.getMainLooper());

    public class AliyunAuthCallback implements AliyunVodAuth.VodAuthCallBack {
        public AliyunAuthCallback() {
        }

        @Override // com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.VodAuthCallBack
        public void onCreateUploadImaged(CreateImageForm createImageForm) {
            VODUploadClientImpl.this.status = VodUploadStateType.STARTED;
            VODUploadClientImpl vODUploadClientImpl = VODUploadClientImpl.this;
            vODUploadClientImpl.setUploadAuthAndAddress(vODUploadClientImpl.curFileInfo, createImageForm.getUploadAuth(), createImageForm.getUploadAddress());
            VODUploadClientImpl.this.resultInfo.setImageUrl(createImageForm.getImageURL());
            VODUploadClientImpl vODUploadClientImpl2 = VODUploadClientImpl.this;
            vODUploadClientImpl2.startUpload(vODUploadClientImpl2.curFileInfo);
        }

        @Override // com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.VodAuthCallBack
        public void onCreateUploadVideoed(CreateVideoForm createVideoForm, String str) {
            VODUploadClientImpl.this.status = VodUploadStateType.STARTED;
            Log.d("VodUpload", createVideoForm.getVideoId());
            VODUploadClientImpl.this.resultInfo.setVideoid(createVideoForm.getVideoId());
            VODUploadClientImpl.this.ossConfig.setVideoId(createVideoForm.getVideoId());
            VODUploadClientImpl.this.ossConfig.setUploadAddress(createVideoForm.getUploadAddress());
            VODUploadClientImpl vODUploadClientImpl = VODUploadClientImpl.this;
            vODUploadClientImpl.setUploadAuthAndAddress(vODUploadClientImpl.curFileInfo, createVideoForm.getUploadAuth(), createVideoForm.getUploadAddress());
            VodUploadResult vodUploadResult = new VodUploadResult();
            vodUploadResult.setVideoid(VODUploadClientImpl.this.resultInfo.getVideoid());
            VODUploadClientImpl.this.curFileInfo.result = vodUploadResult;
            VODUploadClientImpl vODUploadClientImpl2 = VODUploadClientImpl.this;
            vODUploadClientImpl2.startUpload(vODUploadClientImpl2.curFileInfo);
        }

        @Override // com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.VodAuthCallBack
        public void onError(String str, String str2) throws Throwable {
            if (!AliyunVodErrorCode.VODERRORCODE_INVALIDVIDEO.equals(str) || VODUploadClientImpl.this.resumeableSession == null) {
                VODUploadClientImpl.this.status = VodUploadStateType.FAIlURE;
                VODUploadClientImpl.this.callback.onUploadFailed(VODUploadClientImpl.this.curFileInfo, str, str2);
            } else {
                VODUploadClientImpl.this.resumeableSession.deleteResumeableFileInfo(VODUploadClientImpl.this.curFileInfo.getFilePath());
                VODUploadClientImpl.this.needCreateVODUploadAuth();
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.VodAuthCallBack
        public void onSTSExpired(AliyunVodUploadType aliyunVodUploadType) {
            VODUploadClientImpl.this.callback.onUploadTokenExpired();
        }
    }

    public VODUploadClientImpl(Context context) {
        QupaiHttpFinal.getInstance().initOkHttpFinal();
        this.context = new WeakReference<>(context);
        this.ossConfig = new OSSConfig();
        this.resultInfo = new VodUploadResult();
        this.resumeableSession = new ResumeableSession(context.getApplicationContext());
        this.requestIDSession = RequestIDSession.getInstance();
        this.aliyunVodAuth = new AliyunVodAuth(new AliyunAuthCallback());
        this.fileList = Collections.synchronizedList(new ArrayList());
        AliyunLoggerManager.createLogger(this.context.get(), VODUploadClientImpl.class.getName());
    }

    private void addFilesLogger() {
        LogService logService;
        final AliyunLogger logger = AliyunLoggerManager.getLogger(VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.1
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put(AliyunLogKey.KEY_QUEUE_LENGHT, String.valueOf(VODUploadClientImpl.this.listFiles().size()));
                logger.pushLog(map, "upload", AliyunLogCommon.LogLevel.DEBUG, AliyunLogCommon.Module.UPLOADER, "upload", 20001, "upload", VODUploadClientImpl.this.requestIDSession.getRequestID());
            }
        });
    }

    private boolean isSTSMode(UploadFileInfo uploadFileInfo) {
        return uploadFileInfo.getBucket() == null || uploadFileInfo.getEndpoint() == null || uploadFileInfo.getObject() == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needCreateVODUploadAuth() throws Throwable {
        OSSLog.logDebug("[VODUploadClientImpl] - needCreateVODUploadAuth");
        if (!isSTSMode(this.curFileInfo) || this.isVODAuthMode) {
            return false;
        }
        try {
            OSSLog.logDebug("[VODUploadClientImpl] filePath : " + this.curFileInfo.getFilePath());
            String type = StringUtils.isUriPath(this.curFileInfo.getFilePath()) ? this.context.get().getContentResolver().getType(Uri.parse(this.curFileInfo.getFilePath())) : FileUtils.getMimeType(FileUtils.percentEncode(this.curFileInfo.getFilePath()));
            OSSLog.logDebug("[VODUploadClientImpl] file mimeType : " + type);
            if (TextUtils.isEmpty(type)) {
                VODUploadCallback vODUploadCallback = this.callback;
                if (vODUploadCallback != null) {
                    this.status = VodUploadStateType.FAIlURE;
                    vODUploadCallback.onUploadFailed(this.curFileInfo, VODErrorCode.FILE_NOT_EXIST, "The file mimeType\"" + this.curFileInfo.getFilePath() + "\" is not recognized!");
                }
                return true;
            }
            this.status = VodUploadStateType.GETVODAUTH;
            if (type.substring(0, type.lastIndexOf(WVNativeCallbackUtil.SEPERATER)).equals("video") || type.substring(0, type.lastIndexOf(WVNativeCallbackUtil.SEPERATER)).equals("audio")) {
                if (!StringUtils.isUriPath(this.curFileInfo.getFilePath())) {
                    this.curFileInfo.getVodInfo().setFileName(new File(this.curFileInfo.getFilePath()).getName());
                } else if (this.context.get() != null) {
                    this.curFileInfo.getVodInfo().setFileName(FileUtils.getFileNameByUri(this.context.get(), Uri.parse(this.curFileInfo.getFilePath())));
                } else {
                    VODUploadCallback vODUploadCallback2 = this.callback;
                    if (vODUploadCallback2 != null) {
                        this.status = VodUploadStateType.FAIlURE;
                        vODUploadCallback2.onUploadFailed(this.curFileInfo, VODErrorCode.MISSING_ARGUMENT, "VODUploadClientImpl context is null!");
                    }
                }
                String resumeableFileVideoID = this.resumeableSession.getResumeableFileVideoID(this.curFileInfo.getFilePath());
                try {
                    UserData videoBitrate = VideoInfoUtil.getVideoBitrate(this.context.get(), this.curFileInfo.getFilePath());
                    String userData = this.curFileInfo.getVodInfo().getUserData();
                    String strWriteValue = this.jsonSupport.writeValue(videoBitrate);
                    if (!TextUtils.isEmpty(strWriteValue)) {
                        this.curFileInfo.getVodInfo().setUserData(strWriteValue);
                    }
                    if (!TextUtils.isEmpty(userData)) {
                        this.curFileInfo.getVodInfo().setUserData(userData);
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
                        this.curFileInfo.getVodInfo().setUserData(jSONObject3.toString());
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    this.curFileInfo.getVodInfo().setUserData(null);
                }
                if (TextUtils.isEmpty(resumeableFileVideoID)) {
                    this.aliyunVodAuth.createUploadVideo(this.ossConfig.getAccessKeyIdToVOD(), this.ossConfig.getAccessKeySecretToVOD(), this.ossConfig.getSecrityTokenToVOD(), this.curFileInfo.getVodInfo(), this.isTranscode, this.templateGroupId, this.storageLocation, this.workflowId, this.appId, this.requestIDSession.getRequestID());
                } else {
                    this.aliyunVodAuth.refreshUploadVideo(this.ossConfig.getAccessKeyIdToVOD(), this.ossConfig.getAccessKeySecretToVOD(), this.ossConfig.getSecrityTokenToVOD(), resumeableFileVideoID, this.resultInfo.getImageUrl(), this.requestIDSession.getRequestID());
                }
            } else if (type.substring(0, type.lastIndexOf(WVNativeCallbackUtil.SEPERATER)).equals("image")) {
                this.aliyunVodAuth.createUploadImage(this.ossConfig.getAccessKeyIdToVOD(), this.ossConfig.getAccessKeySecretToVOD(), this.ossConfig.getSecrityTokenToVOD(), this.curFileInfo.getVodInfo(), this.workflowId, this.appId, this.requestIDSession.getRequestID(), TextUtils.equals(AliyunVodHttpCommon.ImageType.IMAGETYPE_COVER, this.curFileInfo.getVodInfo().getImageType()));
            }
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            VODUploadCallback vODUploadCallback3 = this.callback;
            if (vODUploadCallback3 != null) {
                this.status = VodUploadStateType.FAIlURE;
                vODUploadCallback3.onUploadFailed(this.curFileInfo, VODErrorCode.FILE_NOT_EXIST, "The file \"" + this.curFileInfo.getFilePath() + "\" is not exist!");
            }
            return true;
        }
    }

    private boolean next() {
        VodUploadStateType vodUploadStateType = this.status;
        if (vodUploadStateType != VodUploadStateType.PAUSED && vodUploadStateType != VodUploadStateType.STOPED) {
            for (int i = 0; i < this.fileList.size(); i++) {
                if (this.fileList.get(i).getStatus() == UploadStateType.INIT) {
                    this.curFileInfo = this.fileList.get(i);
                    if (needCreateVODUploadAuth()) {
                        return false;
                    }
                    VODUploadCallback vODUploadCallback = this.callback;
                    if (vODUploadCallback != null) {
                        vODUploadCallback.onUploadStarted(this.curFileInfo);
                    }
                    startUpload(this.curFileInfo);
                    return true;
                }
            }
            this.status = VodUploadStateType.FINISHED;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUpload(UploadFileInfo uploadFileInfo) {
        if (uploadFileInfo.isMultipart()) {
            this.upload = null;
            OSSUploaderImpl oSSUploaderImpl = new OSSUploaderImpl(this.context.get());
            this.upload = oSSUploaderImpl;
            oSSUploaderImpl.init(this.ossConfig, this);
            this.upload.setOSSClientConfiguration(this.configuration);
            try {
                this.upload.start(uploadFileInfo);
                return;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                this.status = VodUploadStateType.FAIlURE;
                this.callback.onUploadFailed(this.curFileInfo, VODErrorCode.FILE_NOT_EXIST, "The file \"" + this.curFileInfo.getFilePath() + "\" is not exist!");
                return;
            }
        }
        if (!this.mDisableMultiPart && FileUtils.getFileLength(this.context.get(), uploadFileInfo.getFilePath()) >= 102400) {
            this.upload = null;
            ResumableUploaderImpl resumableUploaderImpl = new ResumableUploaderImpl(this.context.get());
            this.upload = resumableUploaderImpl;
            resumableUploaderImpl.setDomainRegion(this.domainRegion);
            this.upload.init(this.ossConfig, this);
            this.upload.setOSSClientConfiguration(this.configuration);
            try {
                this.upload.start(uploadFileInfo);
                return;
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                this.status = VodUploadStateType.FAIlURE;
                this.callback.onUploadFailed(this.curFileInfo, VODErrorCode.FILE_NOT_EXIST, "The file \"" + this.curFileInfo.getFilePath() + "\" is not exist!");
                return;
            }
        }
        this.upload = null;
        OSSPutUploaderImpl oSSPutUploaderImpl = new OSSPutUploaderImpl(this.context.get());
        this.upload = oSSPutUploaderImpl;
        oSSPutUploaderImpl.init(this.ossConfig, this);
        this.upload.setOSSClientConfiguration(this.configuration);
        try {
            this.upload.start(uploadFileInfo);
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
            VODUploadCallback vODUploadCallback = this.callback;
            if (vODUploadCallback != null) {
                this.status = VodUploadStateType.FAIlURE;
                vODUploadCallback.onUploadFailed(this.curFileInfo, VODErrorCode.FILE_NOT_EXIST, "The file \"" + this.curFileInfo.getFilePath() + "\" is not exist!");
            }
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void addFile(String str, VodInfo vodInfo, List<FilePartInfo> list) {
        UploadFileInfo uploadFileInfo = new UploadFileInfo();
        uploadFileInfo.setMultipart(true);
        uploadFileInfo.setPartInfoList(new ArrayList(list));
        uploadFileInfo.setFilePath(str);
        uploadFileInfo.setVodInfo(vodInfo);
        uploadFileInfo.setStatus(UploadStateType.INIT);
        this.fileList.add(uploadFileInfo);
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void cancelFile(int i) {
        ResumeableSession resumeableSession;
        OSSLog.logDebug("[VODUploadClientImpl] - cancelFile called status: " + this.status);
        if (i < 0 || i >= this.fileList.size()) {
            throw new VODClientException(VODErrorCode.INVALID_ARGUMENT, "index out of range");
        }
        UploadFileInfo uploadFileInfo = this.fileList.get(i);
        if (uploadFileInfo != null) {
            UploadStateType status = uploadFileInfo.getStatus();
            UploadStateType uploadStateType = UploadStateType.CANCELED;
            if (status == uploadStateType) {
                OSSLog.logDebug("The file \"" + uploadFileInfo.getFilePath() + "\" is already canceled!");
                return;
            }
            if (uploadFileInfo.getStatus() == UploadStateType.UPLOADING) {
                OSSUploader oSSUploader = this.upload;
                if (oSSUploader != null) {
                    oSSUploader.cancel();
                }
            } else {
                uploadFileInfo.setStatus(uploadStateType);
            }
            if (this.recordUploadProgressEnabled || (resumeableSession = this.resumeableSession) == null) {
                return;
            }
            resumeableSession.deleteResumeableFileInfo(uploadFileInfo.getFilePath(), true);
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void clearFiles() {
        ResumeableSession resumeableSession;
        List<UploadFileInfo> list = this.fileList;
        if (list != null && list.size() > 0) {
            for (UploadFileInfo uploadFileInfo : this.fileList) {
                if (uploadFileInfo != null && (resumeableSession = this.resumeableSession) != null) {
                    resumeableSession.deleteResumeableFileInfo(uploadFileInfo.getFilePath());
                }
            }
        }
        this.fileList.clear();
        OSSUploader oSSUploader = this.upload;
        if (oSSUploader != null) {
            oSSUploader.cancel();
        }
        this.status = VodUploadStateType.INIT;
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void deleteFile(int i) {
        OSSUploader oSSUploader;
        if (i < 0 || i >= this.fileList.size()) {
            throw new VODClientException(VODErrorCode.INVALID_ARGUMENT, "index out of range");
        }
        UploadFileInfo uploadFileInfo = this.fileList.get(i);
        if (uploadFileInfo != null) {
            if (uploadFileInfo.getStatus() == UploadStateType.UPLOADING && (oSSUploader = this.upload) != null) {
                oSSUploader.pause();
            }
            ResumeableSession resumeableSession = this.resumeableSession;
            if (resumeableSession != null) {
                resumeableSession.deleteResumeableFileInfo(uploadFileInfo.getFilePath());
            }
        }
        this.fileList.remove(i);
        this.status = VodUploadStateType.INIT;
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public VodUploadStateType getStatus() {
        return this.status;
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void init(VODUploadCallback vODUploadCallback) {
        if (vODUploadCallback == null) {
            throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"callback\" cannot be null");
        }
        this.jsonSupport = new JSONSupportImpl();
        this.callback = vODUploadCallback;
        this.status = VodUploadStateType.INIT;
        this.isVODAuthMode = true;
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public List<UploadFileInfo> listFiles() {
        return this.fileList;
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener
    public void onUploadFailed(String str, String str2) {
        OSSLog.logDebug("[VODUploadClientImpl] - onUploadFailed: " + str + str2);
        if (str.equals(UploadStateType.CANCELED.toString())) {
            OSSLog.logDebug("[VODUploadClientImpl] - onUploadFailed Canceled");
            VodUploadStateType vodUploadStateType = this.status;
            if (vodUploadStateType == VodUploadStateType.STARTED) {
                next();
                return;
            } else {
                if (vodUploadStateType == VodUploadStateType.STOPED) {
                    this.curFileInfo.setStatus(UploadStateType.INIT);
                    return;
                }
                return;
            }
        }
        OSSLog.logDebug("[VODUploadClientImpl] - onUploadFailed Callback " + this.callback);
        VODUploadCallback vODUploadCallback = this.callback;
        if (vODUploadCallback != null) {
            this.status = VodUploadStateType.FAIlURE;
            vODUploadCallback.onUploadFailed(this.curFileInfo, str, str2);
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener
    public void onUploadProgress(Object obj, long j, long j2) {
        VODUploadCallback vODUploadCallback = this.callback;
        if (vODUploadCallback != null) {
            vODUploadCallback.onUploadProgress(this.curFileInfo, j, j2);
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener
    public void onUploadRetry(String str, String str2) {
        VODUploadCallback vODUploadCallback = this.callback;
        if (vODUploadCallback != null) {
            vODUploadCallback.onUploadRetry(str, str2);
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener
    public void onUploadRetryResume() {
        VODUploadCallback vODUploadCallback = this.callback;
        if (vODUploadCallback != null) {
            vODUploadCallback.onUploadRetryResume();
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener
    public void onUploadSucceed() {
        UploadFileInfo uploadFileInfo;
        VODUploadCallback vODUploadCallback = this.callback;
        if (vODUploadCallback != null) {
            vODUploadCallback.onUploadSucceed(this.curFileInfo, this.resultInfo);
        }
        ResumeableSession resumeableSession = this.resumeableSession;
        if (resumeableSession != null && (uploadFileInfo = this.curFileInfo) != null) {
            resumeableSession.deleteResumeableFileInfo(uploadFileInfo.getFilePath());
        }
        next();
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener
    public void onUploadTokenExpired() {
        OSSLog.logDebug("[VODUploadClientImpl] - onUploadTokenExpired");
        this.status = VodUploadStateType.PAUSED;
        this.mMainHandler.post(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.2
            @Override // java.lang.Runnable
            public void run() {
                if (VODUploadClientImpl.this.callback != null) {
                    VODUploadClientImpl.this.callback.onUploadTokenExpired();
                }
            }
        });
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void pause() {
        OSSUploader oSSUploader;
        OSSLog.logDebug("[VODUploadClientImpl] - pause called status: " + this.status);
        if (VodUploadStateType.STARTED != this.status) {
            OSSLog.logDebug("[VODUploadClientImpl] - status: " + this.status + " cann't be pause!");
            return;
        }
        UploadFileInfo uploadFileInfo = this.curFileInfo;
        if (uploadFileInfo == null) {
            return;
        }
        if (uploadFileInfo.getStatus() == UploadStateType.UPLOADING && (oSSUploader = this.upload) != null) {
            oSSUploader.pause();
        }
        this.status = VodUploadStateType.PAUSED;
        OSSLog.logDebug("[VODUploadClientImpl] - pause called. status: " + this.status + "");
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void resume() {
        OSSLog.logDebug("[VODUploadClientImpl] - resume called status: " + this.status);
        if (VodUploadStateType.PAUSED != this.status) {
            OSSLog.logDebug("[VODUploadClientImpl] - status: " + this.status + " cann't be resume!");
            return;
        }
        this.status = VodUploadStateType.STARTED;
        OSSLog.logDebug("[VODUploadClientImpl] - resume called. status: " + this.status + "");
        if (this.curFileInfo.getStatus() == UploadStateType.PAUSED || this.curFileInfo.getStatus() == UploadStateType.PAUSING) {
            OSSUploader oSSUploader = this.upload;
            if (oSSUploader != null) {
                oSSUploader.resume();
                return;
            }
            return;
        }
        if (this.curFileInfo.getStatus() == UploadStateType.CANCELED || this.curFileInfo.getStatus() == UploadStateType.SUCCESS || this.curFileInfo.getStatus() == UploadStateType.FAIlURE) {
            next();
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void resumeFile(int i) {
        UploadFileInfo uploadFileInfo;
        OSSLog.logDebug("[VODUploadClientImpl] - resumeFile called status: " + this.status);
        if (i < 0 || i >= this.fileList.size()) {
            throw new VODClientException(VODErrorCode.INVALID_ARGUMENT, "index out of range");
        }
        UploadFileInfo uploadFileInfo2 = this.fileList.get(i);
        if (uploadFileInfo2.getStatus() == UploadStateType.FAIlURE || uploadFileInfo2.getStatus() == UploadStateType.CANCELED) {
            uploadFileInfo2.setStatus(UploadStateType.INIT);
        }
        if (this.status != VodUploadStateType.STARTED || (uploadFileInfo = this.curFileInfo) == null || uploadFileInfo.getStatus() == UploadStateType.UPLOADING) {
            return;
        }
        next();
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void resumeWithAuth(String str) throws Throwable {
        OSSLog.logDebug("[VODUploadClientImpl] - resumeWithAuth called status: " + this.status);
        if (StringUtil.isEmpty(str)) {
            throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"uploadAuth\" cannot be null");
        }
        try {
            String str2 = new String(Base64.decode(str, 0));
            JSONObject jSONObject = new JSONObject(str2);
            String strOptString = jSONObject.optString("Expiration");
            String strOptString2 = jSONObject.optString("ExpireUTCTime");
            if (!TextUtils.isEmpty(strOptString2)) {
                strOptString = strOptString2;
            }
            OSSLog.logDebug("[VODUploadClientImpl] resumeWithAuth : " + str2);
            resumeWithToken(jSONObject.optString(AliyunVodKey.KEY_VOD_COMMON_ACCESSKEYID), jSONObject.optString("AccessKeySecret"), jSONObject.optString(AliyunVodKey.KEY_VOD_COMMON_SECURITY_TOKEN), strOptString);
        } catch (JSONException unused) {
            throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"uploadAuth\" format is error");
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void resumeWithToken(String str, String str2, String str3, String str4) throws Throwable {
        OSSLog.logDebug("[VODUploadClientImpl] - resumeWithToken called status: " + this.status);
        VodUploadStateType vodUploadStateType = VodUploadStateType.PAUSED;
        VodUploadStateType vodUploadStateType2 = this.status;
        if (vodUploadStateType != vodUploadStateType2 && VodUploadStateType.FAIlURE != vodUploadStateType2 && VodUploadStateType.GETVODAUTH != vodUploadStateType2) {
            OSSLog.logDebug("[VODUploadClientImpl] - status: " + this.status + " cann't be resume with token!");
            return;
        }
        this.ossConfig.setAccessKeyIdToVOD(str);
        this.ossConfig.setAccessKeySecretToVOD(str2);
        this.ossConfig.setSecrityTokenToVOD(str3);
        this.ossConfig.setExpireTimeToVOD(str4);
        this.ossConfig.setAccessKeyId(str);
        this.ossConfig.setAccessKeySecret(str2);
        this.ossConfig.setSecrityToken(str3);
        this.ossConfig.setExpireTime(str4);
        if (this.status == VodUploadStateType.GETVODAUTH) {
            needCreateVODUploadAuth();
            return;
        }
        this.status = VodUploadStateType.STARTED;
        OSSUploader oSSUploader = this.upload;
        if (oSSUploader != null) {
            oSSUploader.resume();
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void setAppId(String str) {
        this.appId = str;
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void setDisableMultiPart(boolean z) {
        this.mDisableMultiPart = z;
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void setPartSize(long j) {
        OSSConfig oSSConfig = this.ossConfig;
        if (oSSConfig != null) {
            oSSConfig.setPartSize(j);
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void setRecordUploadProgressEnabled(boolean z) {
        this.recordUploadProgressEnabled = z;
        ResumeableSession resumeableSession = this.resumeableSession;
        if (resumeableSession != null) {
            resumeableSession.setEnabled(z);
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void setRegion(String str) {
        if (this.aliyunVodAuth == null) {
            this.aliyunVodAuth = new AliyunVodAuth(new AliyunAuthCallback());
        }
        this.aliyunVodAuth.setDomainRegion(str);
        this.domainRegion = str;
    }

    public void setReportEnabled(boolean z) {
        this.reportEnabled = z;
        AliyunLoggerManager.toggleLogger(z);
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void setStorageLocation(String str) {
        this.storageLocation = str;
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void setTemplateGroupId(String str) {
        this.templateGroupId = str;
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void setTranscodeMode(boolean z) {
        this.isTranscode = z;
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void setUploadAuthAndAddress(UploadFileInfo uploadFileInfo, String str, String str2) {
        UploadFileInfo uploadFileInfo2;
        if (uploadFileInfo == null) {
            throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"uploadFileInfo\" cannot be null");
        }
        if (StringUtil.isEmpty(str)) {
            throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"uploadAuth\" cannot be null");
        }
        if (StringUtil.isEmpty(str2)) {
            throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"uploadAddress\" cannot be null");
        }
        int i = 0;
        while (true) {
            if (i >= this.fileList.size()) {
                uploadFileInfo2 = null;
                break;
            }
            if (this.fileList.get(i).getFilePath().equals(uploadFileInfo.getFilePath())) {
                UploadStateType status = this.fileList.get(i).getStatus();
                UploadStateType uploadStateType = UploadStateType.INIT;
                if (status == uploadStateType) {
                    this.fileList.get(i).setStatus(uploadStateType);
                    uploadFileInfo2 = this.fileList.get(i);
                    break;
                }
            }
            i++;
        }
        if (uploadFileInfo2 == null) {
            throw new VODClientException(VODErrorCode.INVALID_ARGUMENT, "The specified parameter \"uploadFileInfo\" is invalid");
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(Base64.decode(str, 0)));
            this.ossConfig.setAccessKeyId(jSONObject.optString(AliyunVodKey.KEY_VOD_COMMON_ACCESSKEYID));
            this.ossConfig.setAccessKeySecret(jSONObject.optString("AccessKeySecret"));
            this.ossConfig.setSecrityToken(jSONObject.optString(AliyunVodKey.KEY_VOD_COMMON_SECURITY_TOKEN));
            this.ossConfig.setExpireTime(jSONObject.optString("Expiration"));
            String strOptString = jSONObject.optString("Region");
            OSSLog.logDebug("VODSTS", "region : " + strOptString);
            if (!TextUtils.isEmpty(strOptString)) {
                if (this.aliyunVodAuth == null) {
                    this.aliyunVodAuth = new AliyunVodAuth(new AliyunAuthCallback());
                }
                this.aliyunVodAuth.setDomainRegion(strOptString);
                this.domainRegion = strOptString;
            }
            String strOptString2 = jSONObject.optString("ExpireUTCTime");
            OSSLog.logDebug("VODSTS", "expirationUTCTime : " + strOptString2);
            if (!TextUtils.isEmpty(strOptString2)) {
                this.ossConfig.setExpireTime(strOptString2);
            }
            try {
                JSONObject jSONObject2 = new JSONObject(new String(Base64.decode(str2, 0)));
                uploadFileInfo2.setEndpoint(jSONObject2.optString("Endpoint"));
                uploadFileInfo2.setBucket(jSONObject2.optString("Bucket"));
                uploadFileInfo2.setObject(jSONObject2.optString(AliyunVodKey.KEY_VOD_FILENAME));
                this.curFileInfo = uploadFileInfo2;
                OSSUploadInfo uploadInfo = SharedPreferencesUtil.getUploadInfo(this.context.get(), ResumeableSession.SHAREDPREFS_OSSUPLOAD, this.curFileInfo.getFilePath());
                if (uploadInfo == null || !MD5.checkMD5(this.context.get(), uploadInfo.getMd5(), this.curFileInfo.getFilePath())) {
                    this.resumeableSession.saveResumeableFileInfo(this.curFileInfo, this.resultInfo.getVideoid());
                } else {
                    this.curFileInfo = this.resumeableSession.getResumeableFileInfo(this.curFileInfo, this.resultInfo.getVideoid());
                }
                this.ossConfig.setUploadAddress(str2);
            } catch (JSONException unused) {
                throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"uploadAddress\" format is error");
            }
        } catch (JSONException unused2) {
            throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"uploadAuth\" format is error");
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void setVodHttpClientConfig(VodHttpClientConfig vodHttpClientConfig) {
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        this.configuration = clientConfiguration;
        clientConfiguration.setMaxErrorRetry(vodHttpClientConfig.getMaxRetryCount());
        this.configuration.setConnectionTimeout(vodHttpClientConfig.getConnectionTimeout());
        this.configuration.setSocketTimeout(vodHttpClientConfig.getSocketTimeout());
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void setWorkflowId(String str) {
        this.workflowId = str;
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public synchronized void start() {
        OSSLog.logDebug("[VODUploadClientImpl] - start called status: " + this.status);
        VodUploadStateType vodUploadStateType = VodUploadStateType.STARTED;
        VodUploadStateType vodUploadStateType2 = this.status;
        if (vodUploadStateType == vodUploadStateType2 || VodUploadStateType.PAUSED == vodUploadStateType2) {
            OSSLog.logDebug("[VODUploadClientImpl] - status: " + this.status + " cann't be start!");
        } else {
            this.status = vodUploadStateType;
            addFilesLogger();
            next();
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void stop() {
        UploadFileInfo uploadFileInfo;
        OSSLog.logDebug("[VODUploadClientImpl] - stop called status: " + this.status);
        VodUploadStateType vodUploadStateType = VodUploadStateType.STARTED;
        VodUploadStateType vodUploadStateType2 = this.status;
        if (vodUploadStateType != vodUploadStateType2 && VodUploadStateType.PAUSED != vodUploadStateType2) {
            OSSLog.logDebug("[VODUploadClientImpl] - status: " + this.status + " cann't be stop!");
            return;
        }
        this.status = VodUploadStateType.STOPED;
        if (this.upload == null || (uploadFileInfo = this.curFileInfo) == null) {
            return;
        }
        if (uploadFileInfo.getStatus() == UploadStateType.UPLOADING || (this.curFileInfo.isMultipart() && this.curFileInfo.getStatus() == UploadStateType.PAUSED)) {
            this.upload.cancel();
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void init(String str, String str2, VODUploadCallback vODUploadCallback) {
        if (!StringUtil.isEmpty(str)) {
            if (StringUtil.isEmpty(str2)) {
                throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"accessKeySecret\" cannot be null");
            }
            if (vODUploadCallback != null) {
                this.jsonSupport = new JSONSupportImpl();
                this.ossConfig.setAccessKeyId(str);
                this.ossConfig.setAccessKeySecret(str2);
                this.callback = vODUploadCallback;
                this.status = VodUploadStateType.INIT;
                return;
            }
            throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"callback\" cannot be null");
        }
        throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"accessKeyId\" cannot be null");
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void addFile(String str, VodInfo vodInfo) {
        UploadFileInfo uploadFileInfo = new UploadFileInfo();
        uploadFileInfo.setFilePath(str);
        uploadFileInfo.setVodInfo(vodInfo);
        uploadFileInfo.setStatus(UploadStateType.INIT);
        this.fileList.add(uploadFileInfo);
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void addFile(String str, String str2, String str3, String str4) {
        if (!StringUtil.isEmpty(str)) {
            if (!StringUtil.isEmpty(str2)) {
                if (!StringUtil.isEmpty(str2)) {
                    if (!StringUtil.isEmpty(str4)) {
                        UploadFileInfo uploadFileInfo = new UploadFileInfo();
                        uploadFileInfo.setFilePath(str);
                        uploadFileInfo.setEndpoint(str2);
                        uploadFileInfo.setBucket(str3);
                        uploadFileInfo.setObject(str4);
                        uploadFileInfo.setStatus(UploadStateType.INIT);
                        this.fileList.add(uploadFileInfo);
                        return;
                    }
                    throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"object\" cannot be null");
                }
                throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"bucket\" cannot be null");
            }
            throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"endpoint\" cannot be null");
        }
        throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"localFilePath\" cannot be null");
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void init(String str, String str2, String str3, String str4, VODUploadCallback vODUploadCallback) {
        if (!StringUtil.isEmpty(str)) {
            if (!StringUtil.isEmpty(str2)) {
                if ((StringUtil.isEmpty(str3) && !StringUtil.isEmpty(str4)) || (!StringUtil.isEmpty(str3) && StringUtil.isEmpty(str4))) {
                    throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"secrityToken\" and \"expireTime\" cannot be null");
                }
                if (vODUploadCallback != null) {
                    OSSLog.logDebug("VODUpload", "init:STS:\n\nAccessKeyId:" + str + "\nAccessKeySecret:" + str2 + "\nSecrityToken:" + str3 + "\nexpireTime:" + str4);
                    this.jsonSupport = new JSONSupportImpl();
                    this.ossConfig.setAccessKeyIdToVOD(str);
                    this.ossConfig.setAccessKeySecretToVOD(str2);
                    this.ossConfig.setSecrityTokenToVOD(str3);
                    this.ossConfig.setExpireTimeToVOD(str4);
                    this.ossConfig.setAccessKeyId(str);
                    this.ossConfig.setAccessKeySecret(str2);
                    this.ossConfig.setSecrityToken(str3);
                    this.ossConfig.setExpireTime(str4);
                    this.callback = vODUploadCallback;
                    this.status = VodUploadStateType.INIT;
                    return;
                }
                throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"callback\" cannot be null");
            }
            throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"accessKeySecret\" cannot be null");
        }
        throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"accessKeyId\" cannot be null");
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void addFile(String str, String str2, String str3, String str4, VodInfo vodInfo) {
        if (!StringUtil.isEmpty(str)) {
            if (!StringUtil.isEmpty(str2)) {
                if (!StringUtil.isEmpty(str2)) {
                    if (!StringUtil.isEmpty(str4)) {
                        UploadFileInfo uploadFileInfo = new UploadFileInfo();
                        uploadFileInfo.setFilePath(str);
                        uploadFileInfo.setEndpoint(str2);
                        uploadFileInfo.setBucket(str3);
                        uploadFileInfo.setObject(str4);
                        uploadFileInfo.setVodInfo(vodInfo);
                        uploadFileInfo.setStatus(UploadStateType.INIT);
                        this.fileList.add(uploadFileInfo);
                        return;
                    }
                    throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"object\" cannot be null");
                }
                throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"bucket\" cannot be null");
            }
            throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"endpoint\" cannot be null");
        }
        throw new VODClientException(VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"localFilePath\" cannot be null");
    }
}

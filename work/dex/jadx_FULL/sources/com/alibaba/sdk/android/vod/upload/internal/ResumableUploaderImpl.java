package com.alibaba.sdk.android.vod.upload.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.OSSResult;
import com.alibaba.sdk.android.oss.model.ResumableUploadRequest;
import com.alibaba.sdk.android.oss.model.ResumableUploadResult;
import com.alibaba.sdk.android.vod.upload.VODUploadClientImpl;
import com.alibaba.sdk.android.vod.upload.common.RequestIDSession;
import com.alibaba.sdk.android.vod.upload.common.UploadStateType;
import com.alibaba.sdk.android.vod.upload.common.utils.MD5;
import com.alibaba.sdk.android.vod.upload.common.utils.StringUtil;
import com.alibaba.sdk.android.vod.upload.exception.VODErrorCode;
import com.alibaba.sdk.android.vod.upload.model.OSSConfig;
import com.alibaba.sdk.android.vod.upload.model.UploadFileInfo;
import com.aliyun.auth.core.VodThreadService;
import com.aliyun.vod.common.httpfinal.QupaiHttpFinal;
import com.aliyun.vod.common.utils.FileUtils;
import com.aliyun.vod.common.utils.StringUtils;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.aliyun.vod.log.core.AliyunLogParam;
import com.aliyun.vod.log.core.AliyunLogger;
import com.aliyun.vod.log.core.AliyunLoggerManager;
import com.aliyun.vod.log.core.LogService;
import com.aliyun.vod.log.report.AliyunUploadProgressReporter;
import com.aliyun.vod.log.struct.AliyunLogKey;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ResumableUploaderImpl implements OSSUploader {
    private static final int DEFAULT_PART_SIZE = 1048576;
    private ClientConfiguration clientConfig;
    private OSSConfig config;
    private WeakReference<Context> context;
    private OSSUploadListener listener;
    private OSS oss;
    private OSSRequest ossRequest;
    private OSSProgressCallback<ResumableUploadRequest> progressCallback;
    private RequestIDSession requestIDSession;
    private OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> resumableCallback;
    private OSSAsyncTask rusumebleTask;
    private UploadFileInfo uploadFileInfo;
    private AliyunUploadProgressReporter uploadProgressReporter;
    private VodThreadService vodThreadService;
    private String domainRegion = null;
    private boolean recoredUploadProgressEnabled = true;
    private String recordDirectory = getRecordDirectory();

    public class OSSProgressCallbackImpl implements OSSProgressCallback {
        public OSSProgressCallbackImpl() {
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSProgressCallback
        public void onProgress(Object obj, long j, long j2) {
            OSSLog.logDebug("[OSSUploader] - onProgress..." + ((100 * j) / j2));
            ResumableUploaderImpl.this.listener.onUploadProgress(obj, j, j2);
            if (ResumableUploaderImpl.this.uploadProgressReporter != null) {
                ResumableUploaderImpl.this.uploadProgressReporter.setAuthTimestamp(String.valueOf(System.currentTimeMillis()));
                ResumableUploaderImpl.this.uploadProgressReporter.setAuthInfo();
                ResumableUploaderImpl.this.uploadProgressReporter.setUploadRatio(Float.valueOf((j * 1.0f) / j2));
                if (obj instanceof ResumableUploadRequest) {
                    ResumableUploaderImpl.this.uploadProgressReporter.setUploadId(((ResumableUploadRequest) obj).getUploadId());
                    ResumableUploaderImpl.this.uploadProgressReporter.setDonePartsCount(Integer.valueOf((int) (j / (ResumableUploaderImpl.this.config.getPartSize() == 0 ? 1048576L : ResumableUploaderImpl.this.config.getPartSize()))));
                }
                if (ResumableUploaderImpl.this.uploadFileInfo.getFileType() != 0) {
                    ResumableUploaderImpl.this.uploadProgressReporter.pushUploadProgress(ResumableUploaderImpl.this.config.getAccessKeySecret());
                }
            }
        }
    }

    public class ResumableCompletedCallbackImpl implements OSSCompletedCallback {
        public ResumableCompletedCallbackImpl() {
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        public void onFailure(OSSRequest oSSRequest, ClientException clientException, ServiceException serviceException) {
            OSSLog.logDebug("[OSSUploader] - onFailure Enter");
            if (clientException != null) {
                OSSLog.logDebug("[OSSUploader] - onFailure ClientException");
                if (clientException.isCanceledException().booleanValue()) {
                    OSSLog.logDebug("[OSSUploader] - onFailure ClientException isCanceledException");
                    if (ResumableUploaderImpl.this.uploadFileInfo.getStatus() != UploadStateType.CANCELED) {
                        ResumableUploaderImpl.this.uploadFileInfo.setStatus(UploadStateType.PAUSED);
                        return;
                    }
                    return;
                }
                OSSLog.logDebug("[OSSUploader] - onFailure..." + clientException.getMessage());
                ResumableUploaderImpl.this.uploadFileInfo.setStatus(UploadStateType.FAIlURE);
                ResumableUploaderImpl.this.listener.onUploadFailed(UploaderErrorCode.CLIENT_EXCEPTION, clientException.toString());
                ResumableUploaderImpl.this.uploadFailedLogger(UploaderErrorCode.CLIENT_EXCEPTION, clientException.toString());
                ResumableUploaderImpl.this.uploadPartFailedLogger(UploaderErrorCode.CLIENT_EXCEPTION, clientException.toString());
                return;
            }
            if (serviceException != null) {
                OSSLog.logDebug("[OSSUploader] - onFailure ServiceException " + serviceException.getStatusCode());
                if (ResumableUploaderImpl.this.config != null) {
                    OSSLog.logDebug("[OSSUploader] - onFailure ServiceException token" + ResumableUploaderImpl.this.config.getSecrityToken());
                    OSSLog.logDebug("[OSSUploader] - onFailure ServiceException id" + ResumableUploaderImpl.this.config.getAccessKeyId());
                    OSSLog.logDebug("[OSSUploader] - onFailure ServiceException secret" + ResumableUploaderImpl.this.config.getAccessKeySecret());
                }
                if (serviceException.getStatusCode() != 403 || StringUtil.isEmpty(ResumableUploaderImpl.this.config.getSecrityToken())) {
                    OSSLog.logDebug("[OSSUploader] - onFailure ServiceException onUploadFailed");
                    OSSLog.logDebug("[OSSUploader] - onFailure..." + serviceException.getErrorCode() + serviceException.getMessage());
                    ResumableUploaderImpl.this.listener.onUploadFailed(serviceException.getErrorCode(), serviceException.getMessage());
                } else {
                    OSSLog.logDebug("[OSSUploader] - onFailure ServiceException onUploadTokenExpired");
                    ResumableUploaderImpl.this.listener.onUploadTokenExpired();
                }
                OSSLog.logDebug("[OSSUploader] - onFailure ServiceException Done");
                ResumableUploaderImpl.this.uploadPartFailedLogger(serviceException.getErrorCode(), serviceException.toString());
                ResumableUploaderImpl.this.uploadFailedLogger(serviceException.getErrorCode(), serviceException.toString());
            }
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        public void onSuccess(OSSRequest oSSRequest, OSSResult oSSResult) {
            ResumableUploaderImpl.this.rusumebleTask.isCompleted();
            ResumableUploaderImpl.this.uploadFileInfo.setStatus(UploadStateType.SUCCESS);
            ResumableUploaderImpl.this.listener.onUploadSucceed();
            ResumableUploaderImpl.this.uploadSuccessedLogger();
        }
    }

    public ResumableUploaderImpl(Context context) {
        this.context = new WeakReference<>(context);
        OSSLog.logDebug("OSS_RECORD : " + this.recordDirectory);
        if (AliyunLoggerManager.isLoggerOpen()) {
            this.uploadProgressReporter = new AliyunUploadProgressReporter(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asycResumableUpload(UploadFileInfo uploadFileInfo) {
        OSSLog.logDebug("VODSTS", "OSS:\n\nAccessKeyId:" + this.config.getAccessKeyId() + "\nAccessKeySecret:" + this.config.getAccessKeySecret() + "\nSecrityToken:" + this.config.getSecrityToken());
        this.oss = new OSSClient(this.context.get(), uploadFileInfo.getEndpoint(), this.config.getProvider(), this.clientConfig);
        OSSLog.logDebug("ResumeableUplaod", "BucketName:" + uploadFileInfo.getBucket() + "\nobject:" + uploadFileInfo.getObject() + "\nobject:" + uploadFileInfo.getFilePath());
        if (StringUtils.isUriPath(uploadFileInfo.getFilePath())) {
            this.ossRequest = new ResumableUploadRequest(uploadFileInfo.getBucket(), uploadFileInfo.getObject(), Uri.parse(uploadFileInfo.getFilePath()), this.recordDirectory);
        } else {
            this.ossRequest = new ResumableUploadRequest(uploadFileInfo.getBucket(), uploadFileInfo.getObject(), uploadFileInfo.getFilePath(), this.recordDirectory);
        }
        ((ResumableUploadRequest) this.ossRequest).setDeleteUploadOnCancelling(Boolean.valueOf(!this.recoredUploadProgressEnabled));
        ((ResumableUploadRequest) this.ossRequest).setProgressCallback(this.progressCallback);
        long partSize = this.config.getPartSize() == 0 ? 1048576L : this.config.getPartSize();
        File file = new File(uploadFileInfo.getFilePath());
        long fileLength = FileUtils.getFileLength(this.context.get(), uploadFileInfo.getFilePath());
        if (fileLength / partSize > 5000) {
            partSize = fileLength / 4999;
        }
        ((ResumableUploadRequest) this.ossRequest).setPartSize(partSize);
        AliyunUploadProgressReporter aliyunUploadProgressReporter = this.uploadProgressReporter;
        if (aliyunUploadProgressReporter != null) {
            aliyunUploadProgressReporter.setDomainRegion(this.domainRegion);
            this.uploadProgressReporter.setFileName(file.getName());
            this.uploadProgressReporter.setFileSize(Long.valueOf(file.length()));
            this.uploadProgressReporter.setFileCreateTime(AliyunLogParam.generateTimestamp(file.lastModified()));
            this.uploadProgressReporter.setFileHash(MD5.calculateMD5(this.context.get(), uploadFileInfo.getFilePath()));
            this.uploadProgressReporter.setPartSize(Long.valueOf(partSize));
            this.uploadProgressReporter.setTotalPart(Integer.valueOf((int) (fileLength / partSize)));
            this.uploadProgressReporter.setVideoId(this.config.getVideoId());
            this.uploadProgressReporter.setUploadAddress(this.config.getUploadAddress());
        }
        this.rusumebleTask = this.oss.asyncResumableUpload((ResumableUploadRequest) this.ossRequest, this.resumableCallback);
        this.uploadFileInfo.setStatus(UploadStateType.UPLOADING);
        startUploadLogger(uploadFileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getPartNum(String str) {
        long length = new File(str).length() / (this.config.getPartSize() == 0 ? 1048576L : this.config.getPartSize());
        if (length > 5000) {
            return 4999L;
        }
        return length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getPartSize(UploadFileInfo uploadFileInfo) {
        long partSize = this.config.getPartSize() == 0 ? 1048576L : this.config.getPartSize();
        long length = new File(uploadFileInfo.getFilePath()).length();
        return length / partSize > 5000 ? length / 4999 : partSize;
    }

    private String getRecordDirectory() {
        return (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) ? this.context.get().getApplicationContext().getExternalCacheDir().getPath() : this.context.get().getCacheDir().getPath()) + File.separator + "oss_record";
    }

    private void startUploadLogger(final UploadFileInfo uploadFileInfo) {
        final AliyunLogger logger = AliyunLoggerManager.getLogger(VODUploadClientImpl.class.getName());
        if (logger != null) {
            logger.updateRequestID();
            LogService logService = logger.getLogService();
            if (logService != null) {
                logService.execute(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.5
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap videoSize = ResumableUploaderImpl.this.uploadFileInfo.getFileType() == 1 ? FileUtils.getVideoSize(uploadFileInfo.getFilePath()) : null;
                        HashMap map = new HashMap();
                        map.put(AliyunLogKey.KEY_FILE_TYPE, FileUtils.getMimeType(uploadFileInfo.getFilePath()));
                        map.put("fs", String.valueOf(new File(uploadFileInfo.getFilePath()).length()));
                        map.put(AliyunLogKey.KEY_FILE_WIDTH, videoSize == null ? "" : String.valueOf(videoSize.getWidth()));
                        map.put(AliyunLogKey.KEY_FILE_HEIGHT, videoSize != null ? String.valueOf(videoSize.getHeight()) : "");
                        map.put("fm", FileUtils.getMd5OfFile(uploadFileInfo.getFilePath()));
                        map.put("ps", String.valueOf(ResumableUploaderImpl.this.getPartSize(uploadFileInfo)));
                        map.put(AliyunLogKey.KEY_BUCKET, uploadFileInfo.getBucket());
                        map.put("ok", uploadFileInfo.getObject());
                        logger.pushLog(map, "upload", AliyunLogCommon.LogLevel.DEBUG, "upload", "upload", 20002, "upload", ResumableUploaderImpl.this.requestIDSession.getRequestID());
                    }
                });
            }
        }
    }

    private void startUploadPartLogger(final String str, final String str2, final boolean z) {
        LogService logService;
        final AliyunLogger logger = AliyunLoggerManager.getLogger(VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.6
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put("ui", str);
                map.put(AliyunLogKey.KEY_PART_NUMBER, String.valueOf(ResumableUploaderImpl.this.getPartNum(str2)));
                map.put("pr", z ? "0" : "1");
                logger.pushLog(map, "upload", AliyunLogCommon.LogLevel.DEBUG, "upload", "upload", 20005, "upload", ResumableUploaderImpl.this.requestIDSession.getRequestID());
            }
        });
    }

    private void uploadCancelLogger() {
        LogService logService;
        final AliyunLogger logger = AliyunLoggerManager.getLogger(VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.9
            @Override // java.lang.Runnable
            public void run() {
                logger.pushLog(null, "upload", AliyunLogCommon.LogLevel.DEBUG, "upload", "upload", 20008, "upload", ResumableUploaderImpl.this.requestIDSession.getRequestID());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadFailedLogger(final String str, final String str2) {
        LogService logService;
        final AliyunLogger logger = AliyunLoggerManager.getLogger(VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.10
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put(AliyunLogKey.KEY_UPLOAD_PART_FAILED_CODE, str);
                map.put(AliyunLogKey.KEY_UPLOAD_PART_FAILED_MESSAGE, str2);
                logger.pushLog(map, "upload", AliyunLogCommon.LogLevel.DEBUG, "upload", "upload", 20004, "upload", ResumableUploaderImpl.this.requestIDSession.getRequestID());
            }
        });
    }

    private void uploadPartCompletedLogger() {
        LogService logService;
        final AliyunLogger logger = AliyunLoggerManager.getLogger(VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.7
            @Override // java.lang.Runnable
            public void run() {
                logger.pushLog(null, "upload", AliyunLogCommon.LogLevel.DEBUG, "upload", "upload", 20007, "upload", ResumableUploaderImpl.this.requestIDSession.getRequestID());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadPartFailedLogger(final String str, final String str2) {
        LogService logService;
        final AliyunLogger logger = AliyunLoggerManager.getLogger(VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.11
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put(AliyunLogKey.KEY_UPLOAD_PART_FAILED_CODE, str);
                map.put(AliyunLogKey.KEY_UPLOAD_PART_FAILED_MESSAGE, str2);
                logger.pushLog(map, "upload", AliyunLogCommon.LogLevel.DEBUG, "upload", "upload", 20006, "upload", ResumableUploaderImpl.this.requestIDSession.getRequestID());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadSuccessedLogger() {
        LogService logService;
        final AliyunLogger logger = AliyunLoggerManager.getLogger(VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.8
            @Override // java.lang.Runnable
            public void run() {
                logger.pushLog(null, "upload", AliyunLogCommon.LogLevel.DEBUG, "upload", "upload", 20003, "upload", ResumableUploaderImpl.this.requestIDSession.getRequestID());
            }
        });
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void cancel() {
        if (this.oss == null || this.ossRequest == null) {
            return;
        }
        OSSLog.logDebug(ResumableUploaderImpl.class.getClass().getName(), "Resumeable Uploader Cancel");
        this.vodThreadService.execute(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.4
            @Override // java.lang.Runnable
            public void run() {
                ResumableUploaderImpl.this.rusumebleTask.cancel();
                ResumableUploaderImpl.this.uploadFileInfo.setStatus(UploadStateType.CANCELED);
            }
        });
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void init(OSSConfig oSSConfig, OSSUploadListener oSSUploadListener) {
        this.config = oSSConfig;
        this.listener = oSSUploadListener;
        QupaiHttpFinal.getInstance().initOkHttpFinal();
        this.progressCallback = new OSSProgressCallbackImpl();
        this.resumableCallback = new ResumableCompletedCallbackImpl();
        this.requestIDSession = RequestIDSession.getInstance();
        this.vodThreadService = new VodThreadService(String.valueOf(System.currentTimeMillis()));
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void pause() {
        UploadFileInfo uploadFileInfo = this.uploadFileInfo;
        if (uploadFileInfo == null) {
            return;
        }
        UploadStateType status = uploadFileInfo.getStatus();
        if (UploadStateType.UPLOADING.equals(status)) {
            OSSLog.logDebug("[OSSUploader] - pause...");
            this.uploadFileInfo.setStatus(UploadStateType.PAUSING);
            OSSLog.logDebug(ResumableUploaderImpl.class.getClass().getName(), "Resumeable Uploader Pause");
            this.vodThreadService.execute(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    ResumableUploaderImpl.this.rusumebleTask.cancel();
                }
            });
            return;
        }
        OSSLog.logDebug("[OSSUploader] - status: " + status + " cann't be pause!");
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void resume() {
        OSSLog.logDebug(ResumableUploaderImpl.class.getClass().getName(), "Resumeable Uploader Resume");
        this.uploadFileInfo.setStatus(UploadStateType.UPLOADING);
        this.vodThreadService.execute(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ResumableUploaderImpl resumableUploaderImpl = ResumableUploaderImpl.this;
                    resumableUploaderImpl.start(resumableUploaderImpl.uploadFileInfo);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setDomainRegion(String str) {
        this.domainRegion = str;
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void setOSSClientConfiguration(ClientConfiguration clientConfiguration) {
        ClientConfiguration clientConfiguration2 = new ClientConfiguration();
        this.clientConfig = clientConfiguration2;
        if (clientConfiguration == null) {
            clientConfiguration2.setMaxErrorRetry(3);
            this.clientConfig.setSocketTimeout(ClientConfiguration.getDefaultConf().getSocketTimeout());
            this.clientConfig.setConnectionTimeout(ClientConfiguration.getDefaultConf().getSocketTimeout());
        } else {
            clientConfiguration2.setMaxErrorRetry(clientConfiguration.getMaxErrorRetry());
            this.clientConfig.setSocketTimeout(clientConfiguration.getSocketTimeout());
            this.clientConfig.setConnectionTimeout(clientConfiguration.getConnectionTimeout());
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void setRecordUploadProgressEnabled(boolean z) {
        this.recoredUploadProgressEnabled = z;
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void start(UploadFileInfo uploadFileInfo) throws FileNotFoundException {
        File file = new File(this.recordDirectory);
        if (!file.exists() && !file.mkdirs()) {
            this.listener.onUploadFailed(VODErrorCode.PERMISSION_DENIED, "Create RecordDir Failed! Please Check Permission WRITE_EXTERNAL_STORAGE!");
            return;
        }
        UploadFileInfo uploadFileInfo2 = this.uploadFileInfo;
        if (uploadFileInfo2 != null && !uploadFileInfo.equals(uploadFileInfo2)) {
            uploadFileInfo.setStatus(UploadStateType.INIT);
        }
        this.uploadFileInfo = uploadFileInfo;
        this.vodThreadService.execute(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.1
            @Override // java.lang.Runnable
            public void run() {
                ResumableUploaderImpl resumableUploaderImpl = ResumableUploaderImpl.this;
                resumableUploaderImpl.asycResumableUpload(resumableUploaderImpl.uploadFileInfo);
            }
        });
    }
}

package com.alibaba.sdk.android.vod.upload.internal;

import android.content.Context;
import android.net.Uri;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.alibaba.sdk.android.vod.upload.VODUploadClientImpl;
import com.alibaba.sdk.android.vod.upload.common.RequestIDSession;
import com.alibaba.sdk.android.vod.upload.common.UploadStateType;
import com.alibaba.sdk.android.vod.upload.common.utils.StringUtil;
import com.alibaba.sdk.android.vod.upload.model.OSSConfig;
import com.alibaba.sdk.android.vod.upload.model.UploadFileInfo;
import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.auth.core.VodThreadService;
import com.aliyun.vod.common.utils.StringUtils;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.aliyun.vod.log.core.AliyunLogger;
import com.aliyun.vod.log.core.AliyunLoggerManager;
import com.aliyun.vod.log.core.LogService;
import com.aliyun.vod.log.struct.AliyunLogKey;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OSSPutUploaderImpl implements OSSUploader {
    private ClientConfiguration clientConfig;
    private OSSConfig config;
    private WeakReference<Context> context;
    private OSSUploadListener listener;
    private OSS oss;
    private RequestIDSession requestIDSession;
    private OSSAsyncTask task;
    private UploadFileInfo uploadFileInfo;
    private VodThreadService vodThreadService;

    public OSSPutUploaderImpl(Context context) {
        this.context = new WeakReference<>(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadFailedLogger(final String str, final String str2) {
        LogService logService;
        final AliyunLogger logger = AliyunLoggerManager.getLogger(VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.7
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put(AliyunLogKey.KEY_UPLOAD_PART_FAILED_CODE, str);
                map.put(AliyunLogKey.KEY_UPLOAD_PART_FAILED_MESSAGE, str2);
                logger.pushLog(map, "upload", AliyunLogCommon.LogLevel.DEBUG, "upload", "upload", 20004, "upload", OSSPutUploaderImpl.this.requestIDSession.getRequestID());
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
        logService.execute(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.8
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put(AliyunLogKey.KEY_UPLOAD_PART_FAILED_CODE, str);
                map.put(AliyunLogKey.KEY_UPLOAD_PART_FAILED_MESSAGE, str2);
                logger.pushLog(map, "upload", AliyunLogCommon.LogLevel.DEBUG, "upload", "upload", 20006, "upload", OSSPutUploaderImpl.this.requestIDSession.getRequestID());
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
        logService.execute(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.9
            @Override // java.lang.Runnable
            public void run() {
                logger.pushLog(null, "upload", AliyunLogCommon.LogLevel.DEBUG, "upload", "upload", 20003, "upload", OSSPutUploaderImpl.this.requestIDSession.getRequestID());
            }
        });
    }

    public void asyncPutObjectFromLocalFile(String str, String str2, String str3) {
        PutObjectRequest putObjectRequest = StringUtils.isUriPath(str3) ? new PutObjectRequest(str, str2, Uri.parse(str3)) : new PutObjectRequest(str, str2, str3);
        putObjectRequest.setProgressCallback(new OSSProgressCallback<PutObjectRequest>() { // from class: com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.2
            @Override // com.alibaba.sdk.android.oss.callback.OSSProgressCallback
            public void onProgress(PutObjectRequest putObjectRequest2, long j, long j2) {
                OSSPutUploaderImpl.this.listener.onUploadProgress(putObjectRequest2, j, j2);
            }
        });
        this.task = this.oss.asyncPutObject(putObjectRequest, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() { // from class: com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.3
            @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
            public void onFailure(PutObjectRequest putObjectRequest2, ClientException clientException, ServiceException serviceException) {
                if (clientException != null) {
                    if (clientException.getMessage().equals("multipart cancel\n[ErrorMessage]: multipart cancel\n[ErrorMessage]: com.alibaba.sdk.android.oss.ClientException: multipart cancel\n[ErrorMessage]: multipart cancel")) {
                        if (OSSPutUploaderImpl.this.uploadFileInfo.getStatus() != UploadStateType.CANCELED) {
                            OSSPutUploaderImpl.this.uploadFileInfo.setStatus(UploadStateType.PAUSED);
                            return;
                        }
                        return;
                    }
                    OSSLog.logDebug("[OSSUploader] - onFailure..." + clientException.getMessage());
                    OSSPutUploaderImpl.this.uploadFileInfo.setStatus(UploadStateType.FAIlURE);
                    OSSPutUploaderImpl.this.listener.onUploadFailed(UploaderErrorCode.CLIENT_EXCEPTION, clientException.toString());
                    OSSPutUploaderImpl.this.uploadFailedLogger(UploaderErrorCode.CLIENT_EXCEPTION, clientException.toString());
                    OSSPutUploaderImpl.this.uploadPartFailedLogger(UploaderErrorCode.CLIENT_EXCEPTION, clientException.toString());
                    return;
                }
                if (serviceException != null) {
                    if (serviceException.getStatusCode() != 403 || StringUtil.isEmpty(OSSPutUploaderImpl.this.config.getSecrityToken())) {
                        OSSLog.logDebug("[OSSUploader] - onFailure..." + serviceException.getErrorCode() + serviceException.getMessage());
                        OSSPutUploaderImpl.this.listener.onUploadFailed(serviceException.getErrorCode(), serviceException.getMessage());
                    } else {
                        OSSPutUploaderImpl.this.listener.onUploadTokenExpired();
                    }
                    OSSPutUploaderImpl.this.uploadPartFailedLogger(serviceException.getErrorCode(), serviceException.toString());
                    OSSPutUploaderImpl.this.uploadFailedLogger(serviceException.getErrorCode(), serviceException.toString());
                }
            }

            @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
            public void onSuccess(PutObjectRequest putObjectRequest2, PutObjectResult putObjectResult) {
                OSSPutUploaderImpl.this.uploadFileInfo.setStatus(UploadStateType.SUCCESS);
                OSSPutUploaderImpl.this.listener.onUploadSucceed();
                OSSPutUploaderImpl.this.uploadSuccessedLogger();
                OSSLog.logDebug("PutObject", "UploadSuccess");
                OSSLog.logDebug("ETag", putObjectResult.getETag());
                OSSLog.logDebug(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID, putObjectResult.getRequestId());
            }
        });
        this.uploadFileInfo.setStatus(UploadStateType.UPLOADING);
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void cancel() {
        if (this.oss == null) {
            return;
        }
        OSSLog.logDebug(ResumableUploaderImpl.class.getClass().getName(), "Resumeable Uploader Cancel");
        this.vodThreadService.execute(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.4
            @Override // java.lang.Runnable
            public void run() {
                OSSPutUploaderImpl.this.task.cancel();
                OSSPutUploaderImpl.this.uploadFileInfo.setStatus(UploadStateType.CANCELED);
            }
        });
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void init(OSSConfig oSSConfig, OSSUploadListener oSSUploadListener) {
        this.config = oSSConfig;
        this.listener = oSSUploadListener;
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
        if (!UploadStateType.UPLOADING.equals(status)) {
            OSSLog.logDebug("[OSSUploader] - status: " + status + " cann't be pause!");
            return;
        }
        OSSLog.logDebug("[OSSUploader] - pause...");
        this.uploadFileInfo.setStatus(UploadStateType.PAUSING);
        OSSLog.logDebug(ResumableUploaderImpl.class.getClass().getName(), "Resumeable Uploader Pause");
        if (this.task == null) {
            return;
        }
        this.vodThreadService.execute(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.5
            @Override // java.lang.Runnable
            public void run() {
                OSSPutUploaderImpl.this.task.cancel();
            }
        });
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void resume() {
        OSSLog.logDebug(ResumableUploaderImpl.class.getClass().getName(), "Resumeable Uploader Resume");
        this.uploadFileInfo.setStatus(UploadStateType.UPLOADING);
        this.vodThreadService.execute(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    OSSPutUploaderImpl oSSPutUploaderImpl = OSSPutUploaderImpl.this;
                    oSSPutUploaderImpl.start(oSSPutUploaderImpl.uploadFileInfo);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void setOSSClientConfiguration(ClientConfiguration clientConfiguration) {
        ClientConfiguration clientConfiguration2 = new ClientConfiguration();
        this.clientConfig = clientConfiguration2;
        if (clientConfiguration == null) {
            clientConfiguration2.setMaxErrorRetry(Integer.MAX_VALUE);
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
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void start(final UploadFileInfo uploadFileInfo) throws FileNotFoundException {
        UploadFileInfo uploadFileInfo2 = this.uploadFileInfo;
        if (uploadFileInfo2 != null && !uploadFileInfo.equals(uploadFileInfo2)) {
            uploadFileInfo.setStatus(UploadStateType.INIT);
        }
        this.uploadFileInfo = uploadFileInfo;
        this.vodThreadService.execute(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.1
            @Override // java.lang.Runnable
            public void run() {
                OSSPutUploaderImpl oSSPutUploaderImpl = OSSPutUploaderImpl.this;
                oSSPutUploaderImpl.oss = new OSSClient((Context) oSSPutUploaderImpl.context.get(), uploadFileInfo.getEndpoint(), OSSPutUploaderImpl.this.config.getProvider(), OSSPutUploaderImpl.this.clientConfig);
                OSSPutUploaderImpl oSSPutUploaderImpl2 = OSSPutUploaderImpl.this;
                oSSPutUploaderImpl2.asyncPutObjectFromLocalFile(oSSPutUploaderImpl2.uploadFileInfo.getBucket(), OSSPutUploaderImpl.this.uploadFileInfo.getObject(), OSSPutUploaderImpl.this.uploadFileInfo.getFilePath());
            }
        });
    }
}

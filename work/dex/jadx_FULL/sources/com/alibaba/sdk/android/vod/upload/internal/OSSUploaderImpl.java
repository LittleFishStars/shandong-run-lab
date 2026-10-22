package com.alibaba.sdk.android.vod.upload.internal;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.OSSResult;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.model.UploadPartRequest;
import com.alibaba.sdk.android.oss.model.UploadPartResult;
import com.alibaba.sdk.android.vod.upload.VODUploadClientImpl;
import com.alibaba.sdk.android.vod.upload.common.UploadStateType;
import com.alibaba.sdk.android.vod.upload.common.utils.StringUtil;
import com.alibaba.sdk.android.vod.upload.exception.VODErrorCode;
import com.alibaba.sdk.android.vod.upload.model.FilePartInfo;
import com.alibaba.sdk.android.vod.upload.model.OSSConfig;
import com.alibaba.sdk.android.vod.upload.model.UploadFileInfo;
import com.aliyun.vod.common.httpfinal.QupaiHttpFinal;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.aliyun.vod.log.core.AliyunLogger;
import com.aliyun.vod.log.core.AliyunLoggerManager;
import com.aliyun.vod.log.core.LogService;
import com.aliyun.vod.log.struct.AliyunLogKey;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.net.SocketTimeoutException;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OSSUploaderImpl implements OSSUploader {
    private static final int RETRY_INTERVAL = 3000;
    private ClientConfiguration clientConfig;
    private OSSCompletedCallback<CompleteMultipartUploadRequest, CompleteMultipartUploadResult> completedCallback;
    private OSSConfig config;
    private Context context;
    private int curPartNumber;
    private long currentPartSize;
    private OSSCompletedCallback<InitiateMultipartUploadRequest, InitiateMultipartUploadResult> initCallback;
    private OSSUploadListener listener;
    private OSS oss;
    private OSSCompletedCallback<UploadPartRequest, UploadPartResult> partCallback;
    private boolean retryShouldNotify;
    private UploadFileInfo uploadFileInfo;
    private String uploadId;
    private Long uploadedSize;
    private List<PartETag> uploadedParts = new ArrayList();
    private final HandlerThread mHandleThread = new HandlerThread("UploadThread");
    private Handler mHandler = null;

    /* JADX INFO: renamed from: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl$15, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass15 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$sdk$android$vod$upload$internal$OSSUploadRetryType;

        static {
            int[] iArr = new int[OSSUploadRetryType.values().length];
            $SwitchMap$com$alibaba$sdk$android$vod$upload$internal$OSSUploadRetryType = iArr;
            try {
                iArr[OSSUploadRetryType.ShouldRetry.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$vod$upload$internal$OSSUploadRetryType[OSSUploadRetryType.ShouldGetSTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$vod$upload$internal$OSSUploadRetryType[OSSUploadRetryType.ShouldNotRetry.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public class OSSCompletedCallbackImpl implements OSSCompletedCallback {
        public OSSCompletedCallbackImpl() {
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        public void onFailure(OSSRequest oSSRequest, ClientException clientException, ServiceException serviceException) {
            Exception exc;
            UploadStateType status = OSSUploaderImpl.this.uploadFileInfo.getStatus();
            if (clientException != null) {
                exc = clientException;
            } else {
                exc = serviceException != null ? serviceException : null;
            }
            if (exc == null) {
                OSSLog.logError("onFailure error: exception is null.");
                return;
            }
            if (UploadStateType.CANCELED.equals(status)) {
                OSSLog.logError("onFailure error: upload has been canceled, ignore notify.");
                OSSUploaderImpl.this.uploadCancelLogger();
                return;
            }
            int i = AnonymousClass15.$SwitchMap$com$alibaba$sdk$android$vod$upload$internal$OSSUploadRetryType[OSSUploaderImpl.this.shouldRetry(exc).ordinal()];
            if (i == 1) {
                if (UploadStateType.PAUSING.equals(status)) {
                    OSSLog.logDebug("[OSSUploader] - This task is pausing!");
                    OSSUploaderImpl.this.uploadFileInfo.setStatus(UploadStateType.PAUSED);
                    return;
                }
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                OSSUploaderImpl.this.onRetry(oSSRequest);
                if (OSSUploaderImpl.this.retryShouldNotify) {
                    if (clientException != null) {
                        OSSUploaderImpl.this.listener.onUploadRetry(UploaderErrorCode.CLIENT_EXCEPTION, clientException.toString());
                        if (oSSRequest instanceof UploadPartRequest) {
                            OSSUploaderImpl.this.uploadPartFailedLogger(UploaderErrorCode.CLIENT_EXCEPTION, clientException.getMessage().toString());
                        } else {
                            OSSUploaderImpl.this.uploadFailedLogger(UploaderErrorCode.CLIENT_EXCEPTION, clientException.getMessage().toString());
                        }
                    } else if (serviceException != null) {
                        OSSUploaderImpl.this.listener.onUploadRetry(serviceException.getErrorCode(), serviceException.getMessage());
                        if (oSSRequest instanceof UploadPartRequest) {
                            OSSUploaderImpl.this.uploadPartFailedLogger(serviceException.getErrorCode(), serviceException.getMessage());
                        } else {
                            OSSUploaderImpl.this.uploadFailedLogger(serviceException.getErrorCode(), serviceException.getMessage());
                        }
                    }
                    OSSUploaderImpl.this.retryShouldNotify = false;
                    return;
                }
                return;
            }
            if (i == 2) {
                OSSUploaderImpl.this.uploadFileInfo.setStatus(UploadStateType.PAUSED);
                OSSUploaderImpl.this.listener.onUploadTokenExpired();
                OSSUploaderImpl.this.uploadFailedLogger(VODErrorCode.UPLOAD_EXPIRED, "Upload Token Expired");
                return;
            }
            if (i != 3) {
                return;
            }
            OSSUploaderImpl.this.uploadFileInfo.setStatus(UploadStateType.FAIlURE);
            if (clientException != null) {
                OSSUploaderImpl.this.listener.onUploadFailed(UploaderErrorCode.CLIENT_EXCEPTION, clientException.toString());
                if (oSSRequest instanceof UploadPartRequest) {
                    OSSUploaderImpl.this.uploadPartFailedLogger(UploaderErrorCode.CLIENT_EXCEPTION, clientException.getMessage().toString());
                    return;
                } else {
                    OSSUploaderImpl.this.uploadFailedLogger(UploaderErrorCode.CLIENT_EXCEPTION, clientException.getMessage().toString());
                    return;
                }
            }
            if (serviceException != null) {
                OSSUploaderImpl.this.listener.onUploadFailed(serviceException.getErrorCode(), serviceException.getMessage());
                if (oSSRequest instanceof UploadPartRequest) {
                    OSSUploaderImpl.this.uploadPartFailedLogger(serviceException.getErrorCode(), serviceException.getMessage());
                } else {
                    OSSUploaderImpl.this.uploadFailedLogger(serviceException.getErrorCode(), serviceException.getMessage());
                }
            }
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        public void onSuccess(OSSRequest oSSRequest, OSSResult oSSResult) {
            UploadStateType status = OSSUploaderImpl.this.uploadFileInfo.getStatus();
            UploadStateType uploadStateType = UploadStateType.CANCELED;
            if (uploadStateType.equals(status)) {
                OSSLog.logError("onSuccess: upload has been canceled, ignore notify.");
                OSSUploaderImpl.this.uploadCancelLogger();
                return;
            }
            if (!OSSUploaderImpl.this.retryShouldNotify) {
                OSSUploaderImpl.this.listener.onUploadRetryResume();
                OSSUploaderImpl.this.retryShouldNotify = true;
            }
            if (oSSResult instanceof InitiateMultipartUploadResult) {
                OSSUploaderImpl.this.uploadId = ((InitiateMultipartUploadResult) oSSResult).getUploadId();
                OSSLog.logDebug("[OSSUploader] - InitiateMultipartUploadResult uploadId:" + OSSUploaderImpl.this.uploadId);
                OSSUploaderImpl.this.uploadedSize = 0L;
                OSSUploaderImpl.this.uploadPart();
                return;
            }
            if (!(oSSResult instanceof UploadPartResult)) {
                if (oSSResult instanceof CompleteMultipartUploadResult) {
                    OSSLog.logDebug("[OSSUploader] - CompleteMultipartUploadResult onSuccess ------------------");
                    OSSUploaderImpl.this.uploadFileInfo.setStatus(UploadStateType.SUCCESS);
                    OSSUploaderImpl.this.listener.onUploadSucceed();
                    OSSUploaderImpl.this.uploadSuccessedLogger();
                    OSSUploaderImpl.this.release();
                    return;
                }
                return;
            }
            OSSLog.logDebug("[OSSUploader] - UploadPartResult onSuccess ------------------" + ((UploadPartRequest) oSSRequest).getPartNumber());
            UploadPartResult uploadPartResult = (UploadPartResult) oSSResult;
            if (OSSUploaderImpl.this.curPartNumber == 1) {
                OSSUploaderImpl.this.uploadedParts.add(0, new PartETag(OSSUploaderImpl.this.curPartNumber, uploadPartResult.getETag()));
            } else {
                OSSUploaderImpl.this.uploadedParts.add(new PartETag(OSSUploaderImpl.this.curPartNumber, uploadPartResult.getETag()));
            }
            OSSUploaderImpl oSSUploaderImpl = OSSUploaderImpl.this;
            oSSUploaderImpl.uploadedSize = Long.valueOf(oSSUploaderImpl.uploadedSize.longValue() + OSSUploaderImpl.this.currentPartSize);
            FilePartInfo filePartInfo = OSSUploaderImpl.this.uploadFileInfo.getPartInfoList().get(OSSUploaderImpl.this.curPartNumber - 1);
            if (OSSUploaderImpl.this.curPartNumber == 1) {
                OSSUploaderImpl.this.curPartNumber = -1;
            } else if (OSSUploaderImpl.this.uploadFileInfo.getFileLength() == -1 || OSSUploaderImpl.this.uploadFileInfo.getFileLength() != filePartInfo.getSeek() + filePartInfo.getSize()) {
                OSSUploaderImpl.access$608(OSSUploaderImpl.this);
            } else {
                OSSUploaderImpl.this.curPartNumber = 1;
            }
            OSSUploaderImpl.this.uploadPartCompletedLogger();
            if (uploadStateType.equals(status)) {
                return;
            }
            if (UploadStateType.UPLOADING.equals(status)) {
                if (OSSUploaderImpl.this.curPartNumber == -1) {
                    OSSUploaderImpl.this.completeMultiPartUpload();
                    return;
                } else {
                    OSSUploaderImpl.this.uploadPart();
                    return;
                }
            }
            if (UploadStateType.PAUSING.equals(status)) {
                OSSLog.logDebug("[OSSUploader] - This task is pausing!");
                OSSUploaderImpl.this.uploadFileInfo.setStatus(UploadStateType.PAUSED);
            }
        }
    }

    public OSSUploaderImpl(Context context) {
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abortUpload() {
        if (this.uploadId != null) {
            try {
                this.oss.abortMultipartUpload(new AbortMultipartUploadRequest(this.uploadFileInfo.getBucket(), this.uploadFileInfo.getObject(), this.uploadId));
            } catch (ClientException e) {
                OSSLog.logWarn("[OSSUploader] - abort ClientException!code:" + e.getCause() + ", message:" + e.getMessage());
            } catch (ServiceException e2) {
                OSSLog.logWarn("[OSSUploader] - abort ServiceException!code:" + e2.getCause() + ", message:" + e2.getMessage());
            }
        }
    }

    public static /* synthetic */ int access$608(OSSUploaderImpl oSSUploaderImpl) {
        int i = oSSUploaderImpl.curPartNumber;
        oSSUploaderImpl.curPartNumber = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void completeMultiPartUpload() {
        getHandler().post(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.5
            @Override // java.lang.Runnable
            public void run() {
                OSSLog.logDebug("[OSSUploader] - completeMultiPartUpload");
                CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(OSSUploaderImpl.this.uploadFileInfo.getBucket(), OSSUploaderImpl.this.uploadFileInfo.getObject(), OSSUploaderImpl.this.uploadId, OSSUploaderImpl.this.uploadedParts);
                ObjectMetadata metadata = completeMultipartUploadRequest.getMetadata();
                if (metadata == null) {
                    metadata = new ObjectMetadata();
                }
                if (OSSUploaderImpl.this.uploadFileInfo.getVodInfo() != null) {
                    metadata.addUserMetadata("x-oss-notification", OSSUploaderImpl.this.uploadFileInfo.getVodInfo().toVodJsonStringWithBase64());
                }
                completeMultipartUploadRequest.setMetadata(metadata);
                try {
                    OSSUploaderImpl.this.completedCallback.onSuccess(completeMultipartUploadRequest, OSSUploaderImpl.this.oss.completeMultipartUpload(completeMultipartUploadRequest));
                } catch (ClientException e) {
                    OSSUploaderImpl.this.completedCallback.onFailure(completeMultipartUploadRequest, e, null);
                    e.printStackTrace();
                } catch (ServiceException e2) {
                    OSSUploaderImpl.this.completedCallback.onFailure(completeMultipartUploadRequest, null, e2);
                    e2.printStackTrace();
                }
            }
        });
    }

    private Handler getHandler() {
        if (this.mHandler == null) {
            this.mHandleThread.start();
            this.mHandler = new Handler(this.mHandleThread.getLooper());
        }
        return this.mHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initMultiPartUpload() {
        getHandler().post(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.4
            @Override // java.lang.Runnable
            public void run() {
                OSSLog.logDebug("[OSSUploader] - initMultiPartUpload");
                OSSUploaderImpl oSSUploaderImpl = OSSUploaderImpl.this;
                oSSUploaderImpl.startUploadLogger(oSSUploaderImpl.uploadFileInfo);
                InitiateMultipartUploadRequest initiateMultipartUploadRequest = new InitiateMultipartUploadRequest(OSSUploaderImpl.this.uploadFileInfo.getBucket(), OSSUploaderImpl.this.uploadFileInfo.getObject());
                try {
                    OSSUploaderImpl.this.initCallback.onSuccess(initiateMultipartUploadRequest, OSSUploaderImpl.this.oss.initMultipartUpload(initiateMultipartUploadRequest));
                } catch (ClientException e) {
                    OSSUploaderImpl.this.initCallback.onFailure(initiateMultipartUploadRequest, e, null);
                } catch (ServiceException e2) {
                    OSSUploaderImpl.this.initCallback.onFailure(initiateMultipartUploadRequest, null, e2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRetry(final OSSRequest oSSRequest) {
        getHandler().post(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    OSSRequest oSSRequest2 = oSSRequest;
                    if (oSSRequest2 instanceof InitiateMultipartUploadRequest) {
                        OSSUploaderImpl.this.initCallback.onSuccess((InitiateMultipartUploadRequest) oSSRequest, OSSUploaderImpl.this.oss.initMultipartUpload((InitiateMultipartUploadRequest) oSSRequest));
                    } else if (oSSRequest2 instanceof CompleteMultipartUploadRequest) {
                        OSSUploaderImpl.this.completedCallback.onSuccess((CompleteMultipartUploadRequest) oSSRequest, OSSUploaderImpl.this.oss.completeMultipartUpload((CompleteMultipartUploadRequest) oSSRequest));
                    } else if (oSSRequest2 instanceof UploadPartRequest) {
                        OSSUploaderImpl.this.partCallback.onSuccess((UploadPartRequest) oSSRequest, OSSUploaderImpl.this.oss.uploadPart((UploadPartRequest) oSSRequest));
                    }
                } catch (ClientException e) {
                    OSSRequest oSSRequest3 = oSSRequest;
                    if (oSSRequest3 instanceof InitiateMultipartUploadRequest) {
                        OSSUploaderImpl.this.initCallback.onFailure((InitiateMultipartUploadRequest) oSSRequest, e, null);
                    } else if (oSSRequest3 instanceof CompleteMultipartUploadRequest) {
                        OSSUploaderImpl.this.completedCallback.onFailure((CompleteMultipartUploadRequest) oSSRequest, e, null);
                    } else if (oSSRequest3 instanceof UploadPartRequest) {
                        OSSUploaderImpl.this.partCallback.onFailure((UploadPartRequest) oSSRequest, e, null);
                    }
                } catch (ServiceException e2) {
                    OSSRequest oSSRequest4 = oSSRequest;
                    if (oSSRequest4 instanceof InitiateMultipartUploadRequest) {
                        OSSUploaderImpl.this.initCallback.onFailure((InitiateMultipartUploadRequest) oSSRequest, null, e2);
                    } else if (oSSRequest4 instanceof CompleteMultipartUploadRequest) {
                        OSSUploaderImpl.this.completedCallback.onFailure((CompleteMultipartUploadRequest) oSSRequest, null, e2);
                    } else if (oSSRequest4 instanceof UploadPartRequest) {
                        OSSUploaderImpl.this.partCallback.onFailure((UploadPartRequest) oSSRequest, null, e2);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        if (this.mHandler != null) {
            this.mHandleThread.quit();
            this.mHandler = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUploadLogger(final UploadFileInfo uploadFileInfo) {
        final AliyunLogger logger = AliyunLoggerManager.getLogger(VODUploadClientImpl.class.getName());
        if (logger != null) {
            logger.updateRequestID();
            LogService logService = logger.getLogService();
            if (logService != null) {
                logService.execute(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.8
                    @Override // java.lang.Runnable
                    public void run() {
                        HashMap map = new HashMap();
                        map.put(AliyunLogKey.KEY_BUCKET, uploadFileInfo.getBucket());
                        map.put("ok", uploadFileInfo.getObject());
                        logger.pushLog(map, "upload", AliyunLogCommon.LogLevel.DEBUG, "upload", "upload", 20002, "upload", null);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUploadPartLogger() {
        LogService logService;
        final AliyunLogger logger = AliyunLoggerManager.getLogger(VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.9
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put("ui", OSSUploaderImpl.this.uploadId);
                map.put(AliyunLogKey.KEY_PART_NUMBER, String.valueOf(OSSUploaderImpl.this.curPartNumber));
                map.put("pr", OSSUploaderImpl.this.retryShouldNotify ? "0" : "1");
                logger.pushLog(map, "upload", AliyunLogCommon.LogLevel.DEBUG, "upload", "upload", 20005, "upload", null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadCancelLogger() {
        LogService logService;
        final AliyunLogger logger = AliyunLoggerManager.getLogger(VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.12
            @Override // java.lang.Runnable
            public void run() {
                logger.pushLog(null, "upload", AliyunLogCommon.LogLevel.DEBUG, "upload", "upload", 20008, "upload", null);
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
        logService.execute(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.13
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put(AliyunLogKey.KEY_UPLOAD_PART_FAILED_CODE, str);
                map.put(AliyunLogKey.KEY_UPLOAD_PART_FAILED_MESSAGE, str2);
                logger.pushLog(map, "upload", AliyunLogCommon.LogLevel.DEBUG, "upload", "upload", 20004, "upload", null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadPart() {
        getHandler().post(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.6
            /* JADX WARN: Code duplicated, block: B:62:0x012b A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:64:0x0126 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:66:0x00b5 A[EXC_TOP_SPLITTER, PHI: r4 r5
              0x00b5: PHI (r4v8 ??) = (r4v6 ??), (r4v7 ??), (r4v11 ??) binds: [B:24:0x00d0, B:30:0x00df, B:11:0x00b3] A[DONT_GENERATE, DONT_INLINE]
              0x00b5: PHI (r5v8 java.nio.channels.FileLock) = (r5v6 java.nio.channels.FileLock), (r5v7 java.nio.channels.FileLock), (r5v16 java.nio.channels.FileLock) binds: [B:24:0x00d0, B:30:0x00df, B:11:0x00b3] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:79:? A[SYNTHETIC] */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r3v2 */
            /* JADX WARN: Type inference failed for: r3v3, types: [java.io.RandomAccessFile] */
            /* JADX WARN: Type inference failed for: r3v4 */
            /* JADX WARN: Type inference failed for: r4v1, types: [int] */
            /* JADX WARN: Type inference failed for: r4v10 */
            /* JADX WARN: Type inference failed for: r4v11, types: [java.io.RandomAccessFile] */
            /* JADX WARN: Type inference failed for: r4v2 */
            /* JADX WARN: Type inference failed for: r4v3 */
            /* JADX WARN: Type inference failed for: r4v4 */
            /* JADX WARN: Type inference failed for: r4v5 */
            /* JADX WARN: Type inference failed for: r4v6, types: [java.io.RandomAccessFile] */
            /* JADX WARN: Type inference failed for: r4v7, types: [java.io.RandomAccessFile] */
            /* JADX WARN: Type inference failed for: r4v8 */
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                FileLock fileLockLock;
                OSSLog.logDebug("[OSSUploader] - uploadPart PartNumber:" + OSSUploaderImpl.this.curPartNumber);
                String bucket = OSSUploaderImpl.this.uploadFileInfo.getBucket();
                String object = OSSUploaderImpl.this.uploadFileInfo.getObject();
                String str = OSSUploaderImpl.this.uploadId;
                ?? randomAccessFile = OSSUploaderImpl.this.curPartNumber;
                UploadPartRequest uploadPartRequest = new UploadPartRequest(bucket, object, str, randomAccessFile);
                if (OSSUploaderImpl.this.uploadFileInfo.getPartInfoList().size() < OSSUploaderImpl.this.curPartNumber) {
                    OSSUploaderImpl.this.uploadFileInfo.setStatus(UploadStateType.PAUSED);
                    return;
                }
                FilePartInfo filePartInfo = OSSUploaderImpl.this.uploadFileInfo.getPartInfoList().get(OSSUploaderImpl.this.curPartNumber - 1);
                byte[] bArr = new byte[(int) filePartInfo.getSize()];
                ?? r3 = 0;
                try {
                    try {
                        randomAccessFile = new RandomAccessFile(OSSUploaderImpl.this.uploadFileInfo.getFilePath(), "r");
                        try {
                            fileLockLock = randomAccessFile.getChannel().lock(filePartInfo.getSeek(), filePartInfo.getSize(), true);
                            try {
                                randomAccessFile.seek(filePartInfo.getSeek());
                                randomAccessFile.read(bArr);
                                uploadPartRequest.setPartContent(bArr);
                                try {
                                    randomAccessFile.close();
                                } catch (IOException unused) {
                                }
                                if (fileLockLock != null) {
                                    try {
                                        fileLockLock.release();
                                    } catch (IOException unused2) {
                                    }
                                }
                            } catch (FileNotFoundException unused3) {
                                OSSLog.logError("[OSSUploader] - uploadPart RandomAccessFile FileNotFoundException");
                                if (randomAccessFile != 0) {
                                    try {
                                        randomAccessFile.close();
                                    } catch (IOException unused4) {
                                    }
                                }
                                if (fileLockLock != null) {
                                    fileLockLock.release();
                                }
                            } catch (IOException unused5) {
                                OSSLog.logError("[OSSUploader] - uploadPart RandomAccessFile IOException");
                                if (randomAccessFile != 0) {
                                    try {
                                        randomAccessFile.close();
                                    } catch (IOException unused6) {
                                    }
                                }
                                if (fileLockLock != null) {
                                    fileLockLock.release();
                                }
                            }
                        } catch (FileNotFoundException unused7) {
                            fileLockLock = null;
                        } catch (IOException unused8) {
                            fileLockLock = null;
                        } catch (Throwable th) {
                            th = th;
                            fileLockLock = null;
                            r3 = randomAccessFile;
                            if (r3 != 0) {
                                try {
                                    r3.close();
                                } catch (IOException unused9) {
                                }
                            }
                            if (fileLockLock != null) {
                                throw th;
                            }
                            try {
                                fileLockLock.release();
                                throw th;
                            } catch (IOException unused10) {
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (FileNotFoundException unused11) {
                    randomAccessFile = 0;
                    fileLockLock = null;
                } catch (IOException unused12) {
                    randomAccessFile = 0;
                    fileLockLock = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileLockLock = null;
                    if (r3 != 0) {
                        r3.close();
                    }
                    if (fileLockLock != null) {
                        throw th;
                    }
                    fileLockLock.release();
                    throw th;
                }
                OSSUploaderImpl.this.currentPartSize = filePartInfo.getSize();
                uploadPartRequest.setProgressCallback(new OSSProgressCallback<UploadPartRequest>() { // from class: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.6.1
                    @Override // com.alibaba.sdk.android.oss.callback.OSSProgressCallback
                    public void onProgress(UploadPartRequest uploadPartRequest2, long j, long j2) {
                        OSSUploaderImpl.this.listener.onUploadProgress(uploadPartRequest2, OSSUploaderImpl.this.uploadedSize.longValue() + j, OSSUploaderImpl.this.uploadFileInfo.getFileLength());
                    }
                });
                try {
                    UploadPartResult uploadPartResultUploadPart = OSSUploaderImpl.this.oss.uploadPart(uploadPartRequest);
                    OSSUploaderImpl.this.startUploadPartLogger();
                    OSSUploaderImpl.this.partCallback.onSuccess(uploadPartRequest, uploadPartResultUploadPart);
                } catch (ClientException e) {
                    OSSUploaderImpl.this.partCallback.onFailure(uploadPartRequest, e, null);
                } catch (ServiceException e2) {
                    OSSUploaderImpl.this.partCallback.onFailure(uploadPartRequest, null, e2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadPartCompletedLogger() {
        LogService logService;
        final AliyunLogger logger = AliyunLoggerManager.getLogger(VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.10
            @Override // java.lang.Runnable
            public void run() {
                logger.pushLog(null, "upload", AliyunLogCommon.LogLevel.DEBUG, "upload", "upload", 20007, "upload", null);
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
        logService.execute(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.14
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put(AliyunLogKey.KEY_UPLOAD_PART_FAILED_CODE, str);
                map.put(AliyunLogKey.KEY_UPLOAD_PART_FAILED_MESSAGE, str2);
                logger.pushLog(map, "upload", AliyunLogCommon.LogLevel.DEBUG, "upload", "upload", 20006, "upload", null);
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
        logService.execute(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.11
            @Override // java.lang.Runnable
            public void run() {
                logger.pushLog(null, "upload", AliyunLogCommon.LogLevel.DEBUG, "upload", "upload", 20003, "upload", null);
            }
        });
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void cancel() {
        UploadFileInfo uploadFileInfo = this.uploadFileInfo;
        if (uploadFileInfo == null) {
            return;
        }
        UploadStateType status = uploadFileInfo.getStatus();
        if (UploadStateType.INIT.equals(status) || UploadStateType.UPLOADING.equals(status) || UploadStateType.PAUSED.equals(status) || UploadStateType.PAUSING.equals(status)) {
            OSSLog.logDebug("[OSSUploader] - cancel...");
            this.uploadFileInfo.setStatus(UploadStateType.CANCELED);
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler.post(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    OSSLog.logDebug("[OSSUploader] - This task is cancelled!");
                    OSSUploaderImpl.this.uploadPartFailedLogger(UploadStateType.CANCELED.toString(), "This task is user cancelled!");
                    OSSUploaderImpl.this.abortUpload();
                    OSSUploaderImpl.this.release();
                }
            });
            return;
        }
        OSSLog.logDebug("[OSSUploader] - status: " + status + " cann't be cancel!");
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void init(OSSConfig oSSConfig, OSSUploadListener oSSUploadListener) {
        OSSLog.logDebug("[OSSUploader] - init...");
        this.config = oSSConfig;
        this.listener = oSSUploadListener;
        QupaiHttpFinal.getInstance().initOkHttpFinal();
        this.initCallback = new OSSCompletedCallbackImpl();
        this.partCallback = new OSSCompletedCallbackImpl();
        this.completedCallback = new OSSCompletedCallbackImpl();
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void pause() {
        UploadStateType status = this.uploadFileInfo.getStatus();
        if (UploadStateType.UPLOADING.equals(status)) {
            OSSLog.logDebug("[OSSUploader] - pause...");
            this.uploadFileInfo.setStatus(UploadStateType.PAUSING);
            return;
        }
        OSSLog.logDebug("[OSSUploader] - status: " + status + " cann't be pause!");
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void resume() {
        final UploadStateType status = this.uploadFileInfo.getStatus();
        if (UploadStateType.PAUSING.equals(status) || UploadStateType.PAUSED.equals(status)) {
            OSSLog.logDebug("[OSSUploader] - resume...");
            getHandler().post(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    OSSLog.logDebug("[OSSUploader] - resume Runnable");
                    if (UploadStateType.PAUSING.equals(status)) {
                        OSSUploaderImpl.this.uploadFileInfo.setStatus(UploadStateType.UPLOADING);
                        return;
                    }
                    if (UploadStateType.PAUSED.equals(status)) {
                        OSSUploaderImpl.this.uploadFileInfo.setStatus(UploadStateType.UPLOADING);
                        if (OSSUploaderImpl.this.uploadedSize.longValue() == -1) {
                            OSSUploaderImpl.this.initMultiPartUpload();
                        } else if (OSSUploaderImpl.this.curPartNumber != -1) {
                            OSSUploaderImpl.this.uploadPart();
                        } else {
                            OSSUploaderImpl.this.completeMultiPartUpload();
                        }
                    }
                }
            });
            return;
        }
        OSSLog.logDebug("[OSSUploader] - status: " + status + " cann't be resume!");
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

    public OSSUploadRetryType shouldRetry(Exception exc) {
        if (!(exc instanceof ClientException)) {
            if (!(exc instanceof ServiceException)) {
                return OSSUploadRetryType.ShouldNotRetry;
            }
            ServiceException serviceException = (ServiceException) exc;
            if ((serviceException.getErrorCode() == null || !serviceException.getErrorCode().equalsIgnoreCase("RequestTimeTooSkewed")) && serviceException.getStatusCode() < 500) {
                return (serviceException.getStatusCode() != 403 || StringUtil.isEmpty(this.config.getSecrityToken())) ? OSSUploadRetryType.ShouldNotRetry : OSSUploadRetryType.ShouldGetSTS;
            }
            return OSSUploadRetryType.ShouldRetry;
        }
        Exception exc2 = (Exception) exc.getCause();
        if ((exc2 instanceof InterruptedIOException) && !(exc2 instanceof SocketTimeoutException)) {
            OSSLog.logError("[shouldNotetry] - is interrupted!");
            return OSSUploadRetryType.ShouldNotRetry;
        }
        if (!(exc2 instanceof IllegalArgumentException) && !(exc2 instanceof SocketTimeoutException) && !(exc2 instanceof SSLHandshakeException)) {
            OSSLog.logDebug("shouldRetry - " + exc.toString());
            if (exc.getCause() != null) {
                exc.getCause().printStackTrace();
            }
            return OSSUploadRetryType.ShouldRetry;
        }
        return OSSUploadRetryType.ShouldNotRetry;
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void start(final UploadFileInfo uploadFileInfo) {
        OSSLog.logDebug("[OSSUploader] - start");
        getHandler().post(new Runnable() { // from class: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.1
            @Override // java.lang.Runnable
            public void run() {
                OSSLog.logDebug("[OSSUploader] - start Runnable");
                if (!uploadFileInfo.equals(OSSUploaderImpl.this.uploadFileInfo)) {
                    uploadFileInfo.setStatus(UploadStateType.INIT);
                }
                OSSUploaderImpl.this.uploadFileInfo = uploadFileInfo;
                OSSUploaderImpl oSSUploaderImpl = OSSUploaderImpl.this;
                oSSUploaderImpl.oss = new OSSClient(oSSUploaderImpl.context, uploadFileInfo.getEndpoint(), OSSUploaderImpl.this.config.getProvider(), OSSUploaderImpl.this.clientConfig);
                OSSUploaderImpl.this.uploadedSize = -1L;
                OSSUploaderImpl.this.curPartNumber = 2;
                OSSUploaderImpl.this.uploadedParts.clear();
                OSSUploaderImpl.this.retryShouldNotify = true;
                uploadFileInfo.setStatus(UploadStateType.UPLOADING);
                OSSUploaderImpl.this.initMultiPartUpload();
            }
        });
    }
}
